package es.uam.eps.padsof.gesture;

import java.io.Serializable;

import es.uam.eps.padsof.emailconnection.EmailSystem;
import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.balance.ConceptoPrecio;
import es.uam.eps.padsof.gesture.balance.Precio;
import es.uam.eps.padsof.gesture.balance.Venta;
import es.uam.eps.padsof.gesture.balance.VentaContrato;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;

/**
 * Representa un cliente.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Cliente implements Comparable<Cliente>, Serializable {
	private static final long serialVersionUID = 20160329L;
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String codigoPostal;
	private PoliticaNotificacion politicaNotificacion;
	private Contrato contrato = null;
	private Tienda tienda = null;
	
	/**
	 * Constructor de Cliente.
	 *
	 * @param nombre Nombre
	 * @param apellido Apellidos
	 * @param email Email(debe tener un formato valido)
	 * @param direccion Dirección
	 * @param codigoPostal Código Postal
	 * @param politicaNotificacion Politica de notificación en subastas
	 * @throws InvalidEmailAddressException Si el correo no tiene un formato valido
	 */
	public Cliente(String nombre, String apellido, String email, String direccion, String codigoPostal,
			PoliticaNotificacion politicaNotificacion) throws InvalidEmailAddressException {
		if (!EmailSystem.isValidEmailAddr(email)) {
			throw new InvalidEmailAddressException(email);
		}
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.politicaNotificacion = politicaNotificacion;
	}
	
	/**
	 * Compra un producto.
	 *
	 * @param vendible Objeto a comprar
	 * @return Venta
	 * @throws NoAñadidoATiendaException Si el cliente no ha sido añadido a Tienda
	 * @throws NoEstaEnInventarioException Si el objeto no está en inventario
	 */
	public Venta comprar(Vendible vendible) throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		if (tienda == null) {
			throw new NoAñadidoATiendaException();
		}
		
		vendible.retirarDeInventario();
		
		Precio precio = new Precio();
		
		precio.añadirConcepto(new ConceptoPrecio("Precio base", vendible.getPrecioBase()));
	
		Venta venta = new Venta(this, vendible, precio);
		
		if (contrato != null) {
			venta = contrato.procesarVenta(venta);
		}
		
		tienda.getBalance().registrarVenta(venta);
		return venta;
	}
	
	/**
	 * Obtiene el nombre.
	 *
	 * @return nombre (nombre del cliente)
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene el apellido.
	 *
	 * @return apellido (apellido del cliente)
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Obtiene el email.
	 *
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Obtiene la direccion.
	 *
	 * @return direccion (direccion del cliente)
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Obtiene el codigo postal.
	 *
	 * @return codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	/**
	 * Obtiene la politica notificacion.
	 *
	 * @return politicaNotificacion (la politica de Notificacion)
	 */
	public PoliticaNotificacion getPoliticaNotificacion() {
		return politicaNotificacion;
	}
	
	/**
	 * Obtiene el contrato.
	 *
	 * @return contrato (contrato del cliente)
	 */
	public Contrato getContrato() {
		return contrato;
	}

	/**
	 * Otorgar contrato.
	 *
	 * @param contrato Contrato a otorgar
	 * @return VentaContrato
	 * @throws NoAñadidoATiendaException Si el cliente no ha sido añadido a Tienda
	 */
	public VentaContrato otorgarContrato(Contrato contrato) throws NoAñadidoATiendaException {
		if (tienda == null) {
			throw new NoAñadidoATiendaException();
		}
		
		contrato.setCliente(this);
		
		VentaContrato vc = contrato.generarVenta();
		
		tienda.getBalance().registrarVentaContrato(vc);
		
		this.contrato = contrato;
		
		return vc;
	}

	/**
	 * Enviar mail.
	 *
	 * @param subject Titulo del email
     * @param body Cuerpo del email
	 */
	public void enviarMail(String subject, String body) throws FailedInternetConnectionException {
		try {
			EmailSystem.send(email, subject, body, true);
		} catch (InvalidEmailAddressException e) {
			throw new RuntimeException(e); //No deberia pasar, ya comprobamos que sea valida en el constructor
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Cliente otro) {
		return email.compareTo(otro.email);
	}

	/**
	 * Setter de tienda.
	 *
	 * @param tienda del Cliente
	 */
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	/**
	 * String que muestra por pantalla al cliente con su nombre y apellidos
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

	/**
	 * Invalida el contrato de este cliente
	 */
	public void invalidarContrato() {
		contrato = null;
	}
}
