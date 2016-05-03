package es.uam.eps.padsof.gesture.exception;

import es.uam.eps.padsof.gesture.Vendible;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class NoALaVentaException extends Exception {

	private static final long serialVersionUID = -4625985835762859966L;

	private final Vendible vendible;

	/**
	 * Constructor de NoALaVentaException
	 *
	 * @param vendible
	 */
	public NoALaVentaException(Vendible vendible) {
		super();
		this.vendible = vendible;
	}

	/**
	 * Getter de vendible
	 *
	 * @return el vendible de NoALaVentaException
	 */
	public Vendible getVendible() {
		return vendible;
	}
}
