package es.uam.eps.padsof.gesture;

import java.io.Serializable;

/**
 * Representa a un array de artículos mutable.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ColeccionArticulosMutable extends ColeccionArticulos implements Serializable {
	private static final long serialVersionUID = 20160327L;

	/**
	 * Añade un articulo
	 *
	 * @param articulo Articulo a añadir
	 */
	public void añadirArticulo(Articulo articulo) {
		articulos.add(articulo);
	}
}
