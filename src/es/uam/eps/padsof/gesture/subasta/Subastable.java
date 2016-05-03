package es.uam.eps.padsof.gesture.subasta;

import es.uam.eps.padsof.gesture.Vendible;

/**
 * Interfaz que deben implementar todos los objetos potencialmente subastable.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public interface Subastable extends Vendible {
    /**
     * Comprueba si el objeto se puede subastar ahora.
     *
     * @return si el objeto se puede subastar ahora.
     */
	public boolean isDisponibleParaSubasta();

	/**
	 * @return
	 */
	public String getDescripcion();
}
