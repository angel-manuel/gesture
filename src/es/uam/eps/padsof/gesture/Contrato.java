package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.balance.Precio;
import es.uam.eps.padsof.gesture.balance.Venta;
import es.uam.eps.padsof.gesture.balance.VentaContrato;

/**
 * Clase abstracta para contrato.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public abstract class Contrato implements Serializable {
	private static final long serialVersionUID = 20160329L;
	protected final Date validoHasta;
	protected Cliente cliente = null;
	
	/**
	 * Constructor de Contrato.
	 *
	 * @param validoHasta Limite de validez del contrato
	 */
	public Contrato(Date validoHasta) {
		this.validoHasta = validoHasta;
	}
	
	
	/**
	 * Instancia un nuevo contrato.
	 */
	public Contrato() {
		Date enUnAño = new Date(new Date().getTime() + 365*24*60*60*1000);
		this.validoHasta = enUnAño;
	}
	
	/**
	 * Obtiene la fecha hasta la cual el contrato es válido.
	 *
	 * @return fecha limite del contrato
	 */
	public Date getValidoHasta() {
		return validoHasta;
	}
	
	/**
	 * Comprueba si el contrato es valido.
	 *
	 * @return si el contrato es valido.
	 */
	public boolean isValido() {
		long now = new Date().getTime();
		return now < validoHasta.getTime();
	}
	
	/**
	 * @return Objeto que representa la venta de este contrato
	 */
	public abstract VentaContrato generarVenta();

	/**
	 * Calcula los conceptos del precio de participar en una subasta.
	 *
	 * @param costeDeParticipacion Coste base de participación
	 * @return precio con descuento si aplica
	 */
	public abstract Precio calcularPrecioParticipacion(double costeDeParticipacion);
	
	/**
	 * Calcula los conceptos del precio de comprar un objeto.
	 *
	 * @param venta Venta
	 * @return precio con descuento si aplica
	 */
	public abstract Venta procesarVenta(Venta venta);

	/**
	 * Getter de cliente.
	 *
	 * @return el cliente de Contrato
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Setter de cliente.
	 *
	 * @param cliente el cliente de Contrato
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
