package es.uam.eps.padsof.gesture;

import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;

/**
 * Interfaz que deben implementar todos los objetos potencialmente vendibles.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public interface Vendible {
    /**
     * Obtiene el precio base
     *
     * @return Precio base
     */
	public double getPrecioBase();

	 /**
     * Obtiene el descuento
     *
     * @return Descuento
     */
	public double calcularDescuento();

    /**
     * Obtiene el coste de adquisicion.
     *
     * @return Coste de adquisicion.
     */
	public double getCosteAdquisicion();

    /**
     * Calcula los gastos de envio.
     *
     * @return Gastos de envio.
     */
	public double calcularGastosEnvio();

	/**
     * Comprueba si el objeto se puede vender ahora.
     *
     * @return si el objeto se puede vender ahora.
     */
	public boolean isALaVenta();

    /**
     * Retira el objeto de inventario.
     *
     * @throws NoAñadidoATiendaException Si el objeto no está añadido a Tienda.
     * @throws NoEstaEnInventarioException Si el objeto ya no está en inventario.
     */
	public void retirarDeInventario() throws NoAñadidoATiendaException, NoEstaEnInventarioException;
	
     /**
     * Devuelve el objeto a inventario.
     *
     * @throws NoAñadidoATiendaException Si el objeto no está añadido a Tienda.
     */
	public void devolverAInventario() throws NoAñadidoATiendaException;
}
