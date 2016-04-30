package es.uam.eps.padsof.gesture.balance;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Vendible;

/**
 * Contiene información sobre la venta de un artículo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Venta implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private final Cliente comprador;
	private final Precio precio;
	private final Vendible objetoVendido;
	private final Date fecha;
	
	/**
	 * Constructor de Venta
	 *
	 * @param comprador Comprador
	 * @param objetoVendido Objeto vendido
	 * @param precio Precio de venta(incluyendo descuentos y gastos de envio)
	 */
	public Venta(Cliente comprador, Vendible objetoVendido, Precio precio) {
		this.comprador = comprador;
		this.precio = precio;
		this.objetoVendido = objetoVendido;
		this.fecha = new Date();
	}

	/**
	 * Getter de comprador.
	 *
	 * @return el comprador de Venta
	 */
	public Cliente getComprador() {
		return comprador;
	}

	/**
	 * Getter de precio.
	 *
	 * @return el precio de Venta
	 */
	public Precio getPrecio() {
		return precio;
	}

	/**
	 * Getter de objetoVendido.
	 *
	 * @return el objetoVendido de Venta
	 */
	public Vendible getObjetoVendido() {
		return objetoVendido;
	}

	/**
	 * Getter de fecha.
	 *
	 * @return fecha de Venta
	 */
	public Date getFecha() {
		return fecha;
	}
	
	/**
	 * Genera una representación textual de la venta
	 *
	 * @return Representación textual de la venta
	 */
	@Override
	public String toString() {
		return comprador + " compra [" + objetoVendido + "] el " + fecha + "\n" + precio;
	}
}
