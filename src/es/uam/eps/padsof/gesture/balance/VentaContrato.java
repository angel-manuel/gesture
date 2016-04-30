package es.uam.eps.padsof.gesture.balance;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Contrato;

/**
 * Contiene información sobre la venta de un contrato
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class VentaContrato implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private final Cliente comprador;
	private final Contrato contratoVendido;
	private final Precio precio;
	private final Date fecha;
	
	/**
	 * Constructor de VentaContrato.
	 *
	 * @param comprador Comprador
	 * @param contratoVendido Contrato vendido
	 * @param precio Precio de venta del contrato
	 */
	public VentaContrato(Cliente comprador, Contrato contratoVendido,
			Precio precio) {
		this.comprador = comprador;
		this.contratoVendido = contratoVendido;
		this.precio = precio;
		this.fecha = new Date();
	}

	/**
	 * Getter de comprador.
	 *
	 * @return el comprador de VentaContrato
	 */
	public Cliente getComprador() {
		return comprador;
	}

	/**
	 * Getter de contratoVendido.
	 *
	 * @return el contratoVendido de VentaContrato
	 */
	public Contrato getContratoVendido() {
		return contratoVendido;
	}

	/**
	 * Getter de precio.
	 *
	 * @return el precio de VentaContrato
	 */
	public Precio getPrecio() {
		return precio;
	}

	/**
	 * Getter de fecha.
	 *
	 * @return el fecha de VentaContrato
	 */
	public Date getFecha() {
		return fecha;
	}
}
