package es.uam.eps.padsof.gesture.subasta;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Contrato;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.balance.Precio;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.exception.ParticipacionDuplicadaException;
import es.uam.eps.padsof.gesture.exception.ParticipacionSinContratoException;
import es.uam.eps.padsof.gesture.exception.PujaRechazadaException;
import es.uam.eps.padsof.gesture.exception.SubastaNoCancelableException;

/**
 * Representa una subasta.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Subasta implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private final Subastable objetoSubasta;
	private final double precioSalida;
	private final Date ultimoDia;
	private final double costeDeParticipacion;
	private ArrayList<Cliente> participantes = new ArrayList<>();
	private ArrayList<Cliente> subscriptores = new ArrayList<>();
	private Puja ultimaPuja = null;
	private Tienda tienda = null;
	
	/**
	 * Constructor de Subasta.
	 *
	 * @param objetoSubasta Objeto a subastar(debe estar añadido a Tienda)
	 * @param precioSalida Precio de salida
	 * @param ultimoDia Ultimo día natural de subasta
	 * @param costeDeParticipacion Coste de participación
	 * @throws NoAñadidoATiendaException Si el objeto a subastar no ha sido añadido a Tienda
	 * @throws NoEstaEnInventarioException Si el objeto a subastar ya no está en inventario
	 */
	public Subasta(Subastable objetoSubasta, double precioSalida, Date ultimoDia, double costeDeParticipacion) throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		objetoSubasta.retirarDeInventario();
		
		this.objetoSubasta = objetoSubasta;
		this.precioSalida = precioSalida;
		this.ultimoDia = ultimoDia;
		this.costeDeParticipacion = costeDeParticipacion;
	}
	
	/**
	 * Constructor de Subasta. Toma como precio de salida el precio de venta del objeto.
	 *
	 * @param objetoSubasta Objeto a subastar(debe estar añadido a Tienda)
	 * @param ultimoDia Ultimo día natural de subasta
	 * @param costeDeParticipacion Coste de participación
	 * @throws NoAñadidoATiendaException Si el objeto a subastar no ha sido añadido a Tienda
	 * @throws NoEstaEnInventarioException Si el objeto a subastar ya no está en inventario
	 */
	public Subasta(Subastable objetoSubasta, Date ultimoDia, double costeDeParticipacion) throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		this(objetoSubasta, objetoSubasta.getPrecioBase(), ultimoDia, costeDeParticipacion);
	}
	
	/**
	 * Comprueba si el cliente esta participando
	 *
	 * @param cliente Cliente
	 * @return si el cliente está participando actualmente
	 */
	public boolean estaParticipando(Cliente cliente) {
		for(Cliente participante: participantes) {
			if(participante == cliente) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Añadir participante.
	 *
	 * @param nuevoParticipante Nuevo participante
	 * @return Un objeto que representa la participación
	 * @throws ParticipacionDuplicadaException Si el cliente ya está participante
	 * @throws ParticipacionSinContratoException Si el cliente no tiene contrato
	 * @throws NoAñadidoATiendaException Si la subasta no está añadida a tienda
	 */
	public ParticipacionSubasta añadirParticipante(Cliente nuevoParticipante) throws ParticipacionDuplicadaException, ParticipacionSinContratoException, NoAñadidoATiendaException {
		if (tienda == null) {
			throw new NoAñadidoATiendaException();
		}
		
		Contrato contrato = nuevoParticipante.getContrato();
		
		if (contrato == null) {
			throw new ParticipacionSinContratoException(nuevoParticipante);
		}
		
		if (estaParticipando(nuevoParticipante)) {
			throw new ParticipacionDuplicadaException(nuevoParticipante);
		}
		
		// Si la política es Siempre ya se le subscribe desde Tienda a todas las subastas
		if(nuevoParticipante.getPoliticaNotificacion() == PoliticaNotificacion.AlParticipar) {
			subscribir(nuevoParticipante);
		}
		
		participantes.add(nuevoParticipante);
		
		Precio precio = contrato.calcularPrecioParticipacion(costeDeParticipacion);
		
		ParticipacionSubasta participacion = new ParticipacionSubasta(nuevoParticipante, this, precio);
		
		this.tienda.getBalance().registrarParticipacion(participacion);
		
		return participacion;
	}
	
	/**
	 * Comprueba si un cliente está subscrito.
	 *
	 * @param cliente Cliente
	 * @return si está subscrito.
	 */
	public boolean estaSubscrito(Cliente cliente) {
		for(Cliente subscriptor: subscriptores) {
			if(subscriptor == cliente) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Subscribir un cliente
	 *
	 * @param nuevoSubscriptor Nuevo subscriptor
	 */
	public void subscribir(Cliente nuevoSubscriptor) {
		if (estaSubscrito(nuevoSubscriptor)) {
			return;
		}
		
		subscriptores.add(nuevoSubscriptor);
	}
	
	/**
	 * Desubscribir a un cliente
	 *
	 * @param subscriptor El cliente a desubscribir
	 * @return true si el cliente estaba participante, false en caso contrario
	 */
	public boolean desubscribir(Cliente subscriptor) {
		return subscriptores.remove(subscriptor);
	}
	
	/**
	 * Comprueba si la subasta debería estar terminada.
	 *
	 * @return si la subasta debería estar terminada.
	 */
	public boolean isTerminada() {
		long now = new Date().getTime();
		long end = ultimoDia.getTime();
		
		return (now - end) >= 24*60*60*1000;
	}
	
	/**
	 * Finaliza la subasta
	 *
	 * @return El resultado de la subasta
	 * @throws FailedInternetConnectionException
	 * @throws NoAñadidoATiendaException Si la subasta no ha sido añadido a Tienda
	 */
	public ResultadoSubasta finalizar() throws FailedInternetConnectionException, NoAñadidoATiendaException {
		if (tienda == null) {
			throw new NoAñadidoATiendaException();
		}
		
		if (ultimaPuja == null) {
			return null;
		} else {
			ResultadoSubasta res = new ResultadoSubasta(ultimaPuja.getPostor(), ultimaPuja.getValor(), objetoSubasta);

			notificarFinalizacion(res.getGanador());
			
			tienda.getBalance().registrarResultadoSubasta(res);
			
			return res;
		}
	}
	
	/**
	 * Comprueba si la subasta es a ciegas.
	 *
	 * @return Si la subasta es a ciegas.
	 */
	public boolean isCiega() {
		long now = new Date().getTime();
		long end = ultimoDia.getTime();
		
		return now >= end && !isTerminada();
	}
	
	/**
	 * Pujar.
	 *
	 * @param puja Una puja
	 * @throws PujaRechazadaException Si la puja no tiene el suficiente valor o si el postor no está subscrito
	 */
	public void pujar(Puja puja) throws PujaRechazadaException {
		Cliente postor = puja.getPostor();
		
		if (!estaSubscrito(postor)) {
			throw new PujaRechazadaException(puja, "Postor no subscrito a subasta");
		}
		
		if (ultimaPuja == null) {
			if (puja.getValor() >= precioSalida) {
				ultimaPuja = puja;
			} else {
				throw new PujaRechazadaException(puja, "Puja por debajo del precio de salida");
			}
		} else {
			if (puja.isSuperior(ultimaPuja)) {
				ultimaPuja = puja;
			} else {
				if (isCiega()) {
					return; //Si es ciega hacemos fallar la puja silenciosamente
				}
				
				throw new PujaRechazadaException(puja, "La puja no supera a la última puja");
			}
		}
		
		if (!isCiega()) {
			try {
				notificarPuja(ultimaPuja);
			} catch (FailedInternetConnectionException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Notificar inicio.
	 */
	public void notificarInicio() throws FailedInternetConnectionException {
		for (Cliente subscriptor: subscriptores) {
			subscriptor.enviarMail("Subasta abierta!",
					"Nueva subasta a partir de " + precioSalida + " por " +  objetoSubasta + "\n"
					+ "Participe por solo " + costeDeParticipacion);
		}
	}
	
	/**
	 * Notificar cancelacion.
	 */
	private void notificarCancelacion() throws FailedInternetConnectionException {
		for (Cliente subscriptor: subscriptores) {
			subscriptor.enviarMail("Subasta cancelada!",
					"Lo sentimos pero la subasta de " + objetoSubasta + " ha sido cancelada");
		}
	}

	/**
	 * Notificar puja.
	 *
	 * @param puja La puja a notificar.
	 */
	private void notificarPuja(Puja puja) throws FailedInternetConnectionException {
		for (Cliente subscriptor: subscriptores) {
			subscriptor.enviarMail("Puja superada!", 
					"Nueva puja de " + puja.getValor() + " en la subasta de " + objetoSubasta);
		}
	}
	
	/**
	 * Notifica la finalización a los subscriptores y da la enhorabuena al ganador.
	 *
	 * @param ganador El ganador.
	 */
	private void notificarFinalizacion(Cliente ganador) throws FailedInternetConnectionException {
		for (Cliente subscriptor: subscriptores) {
			subscriptor.enviarMail("Subasta finalizada!", "La subasta de " + objetoSubasta + " ha finalizado");
		}
		
		ganador.enviarMail("Enhorabuena!", "Ha ganado la subasta de " + objetoSubasta);
	}

	/**
	 * Getter de objetoSubasta.
	 *
	 * @return el objetoSubasta de Subasta
	 */
	public Subastable getObjetoSubasta() {
		return objetoSubasta;
	}

	/**
	 * Getter de precioSalida.
	 *
	 * @return el precioSalida de Subasta
	 */
	public double getPrecioSalida() {
		return precioSalida;
	}

	/**
	 * Getter de ultimoDia.
	 *
	 * @return el ultimoDia de Subasta
	 */
	public Date getUltimoDia() {
		return ultimoDia;
	}

	/**
	 * Getter de costeDeParticipacion.
	 *
	 * @return el costeDeParticipacion de Subasta
	 */
	public double getCosteDeParticipacion() {
		return costeDeParticipacion;
	}

	/**
	 * Setter de tienda.
	 *
	 * @param tienda el tienda de Subasta
	 */
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	/**
	 * Cancelar la subasta.
	 *
	 * @throws SubastaNoCancelableException Si la subasta no se puede cancelar por haber recibido pujas.
     */
	public void cancelar() throws SubastaNoCancelableException, NoAñadidoATiendaException, FailedInternetConnectionException {
		if (ultimaPuja != null) {
			throw new SubastaNoCancelableException(this);
		}
		
		// Devolver objeto
		objetoSubasta.devolverAInventario();
		
		notificarCancelacion();
		
		if (tienda != null) {
			tienda.getSubastas().remove(this);
		}
	}

	/**
	 * Getter de ultimaPuja
	 *
	 * @return el ultimaPuja de Subasta
	 */
	public Puja getUltimaPuja() {
		return ultimaPuja;
	}
	
	
}
