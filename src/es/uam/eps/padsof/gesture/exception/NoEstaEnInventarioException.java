package es.uam.eps.padsof.gesture.exception;

import es.uam.eps.padsof.gesture.Articulo;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class NoEstaEnInventarioException extends Exception {
	private static final long serialVersionUID = 20160330L;
	private final Articulo articulo;

	/**
	 * Constructor de NoEstaEnInventarioException
	 *
	 * @param articulo
	 */
	public NoEstaEnInventarioException(Articulo articulo) {
		this.articulo = articulo;
	}

	/**
	 * Getter de articulo
	 *
	 * @return el articulo de NoEstaEnInventarioException
	 */
	public Articulo getArticulo() {
		return articulo;
	}
}
