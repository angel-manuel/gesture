package es.uam.eps.padsof.gesture.exception;

import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastaNoCancelableException extends Exception {
	private static final long serialVersionUID = 20160330L;
	private final Subasta subasta;

	/**
	 * Constructor de SubastaNoCancelableException
	 *
	 * @param subasta
	 */
	public SubastaNoCancelableException(Subasta subasta) {
		this.subasta = subasta;
	}

	/**
	 * Getter de subasta
	 *
	 * @return el subasta de SubastaNoCancelableException
	 */
	public Subasta getSubasta() {
		return subasta;
	}
}
