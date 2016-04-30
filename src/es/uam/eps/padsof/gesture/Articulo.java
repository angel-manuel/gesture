package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;


/**
 * Clase abstracta para artículo.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */

public abstract class Articulo implements Vendible, Serializable {
	private static final long serialVersionUID = 20160326L;
	protected final String descripcion;
	protected final double precioBase;
	protected final String año;
	protected final Date fechaAdquisicion;
	protected final double costeAdquisicion;
	private Inventario inventario = null;
	
	/**
	 * Constructor de Articulo.
	 *
	 * @param descripcion Descripción o nombre del artículo
	 * @param precioBase Precio base del artículo
	 * @param año Año del artículo
	 * @param fechaAdquisicion Fecha de adquisición del artículo
	 * @param costeAdquisicion Coste de adquisición del artículo
	 */
	public Articulo(String descripcion, double precioBase, String año, Date fechaAdquisicion, double costeAdquisicion) {
		this.descripcion = descripcion;
		this.precioBase = precioBase;
		this.año = año;
		this.fechaAdquisicion = fechaAdquisicion;
		this.costeAdquisicion = costeAdquisicion;
	}
	
	@Override
	public void retirarDeInventario() throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		if (inventario == null) {
			throw new NoAñadidoATiendaException();
		}
		
		inventario.retirarArticulo(this);
	}
	
	@Override
	public void devolverAInventario() throws NoAñadidoATiendaException {
		if (inventario == null) {
			throw new NoAñadidoATiendaException();
		}
		
		inventario.añadirArticulo(this);
	}
	
	/**
	 * Obtiene el precio base
	 *
	 * @return precioBase
	 */
	public double getPrecioBase() {
		return precioBase;
	}
	
	/**
	 * Calcula el descuento
	 *
	 * @return 0.0, en general los artículos no tienen descuento.
	 */
	public double calcularDescuento() {
		return 0.0;
	}
	
	/**
	 * Getter de costeAdquisicion.
	 *
	 * @return el costeAdquisicion de Artículo
	 */
	public double getCosteAdquisicion() {
		return costeAdquisicion;
	}

	/**
	 * Obtiene la descripcion.
	 *
	 * @return descripcion del articulo
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Calcula gastos de envio
	 *
	 * @return 0.0, en general los artículos no tienen costes de envio.
	 */
	public double calcularGastosEnvio() {
		return 0.0;
	}
	
	/**
	 * Comprueba que el articulo esta a la venta
	 *
	 * @return true, en general los artículos en inventario están a la venta.
	 */
	public boolean isALaVenta() {
		return true;
	}
	
	/**
	 * String que muestra por pantalla el articulo con sus caracteristicas
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return String.format("%s(%s) %.2f€ adquirido por %.2f€ el %s", descripcion, año, precioBase,
				costeAdquisicion, fechaAdquisicion.toString());
	}
	
	/**
	 * Devuelve el tipo de artículo
	 *
	 * @return el tipo de este artículo
	 */
	public abstract TipoDeArticulo getTipo();

	/**
	 * Getter de inventario.
	 *
	 * @return el inventario de Articulo
	 */
	public Inventario getInventario() {
		return inventario;
	}

	/**
	 * Setter de inventario.
	 *
	 * @param inventario el inventario
	 */
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	/**
	 * Getter de año
	 *
	 * @return el año
	 */
	public String getAño() {
		return año;
	}

	/**
	 * Getter de fechaAdquisicion
	 *
	 * @return la fecha de adquisición
	 */
	public Date getFechaAdquisicion() {
		return fechaAdquisicion;
	}
}
