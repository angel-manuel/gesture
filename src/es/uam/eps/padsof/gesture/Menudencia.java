package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.util.Date;

/**
 * Representa una menudencia.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Menudencia extends Articulo implements Serializable {
	private static final long serialVersionUID = 20160326L;
	private final int porcentajeDescuento;
	
	/**
	 * Constructor de Menudencia.
	 *
	 * @param porcentajeDescuento Entero de 0 a 100 que determina el porcentaje de descuento que tiene la menudencia.
	 */
	public Menudencia(String descripcion, double precioBase, String año, Date fechaAdquisicion, double costeAdquisicion,
			int porcentajeDescuento) {
		super(descripcion, precioBase, año, fechaAdquisicion, costeAdquisicion);
		this.porcentajeDescuento = porcentajeDescuento;
	}

	@Override
	public double calcularDescuento() {
		return precioBase*(double)porcentajeDescuento/100;
	}
	
	/**
	 * Obtiene el porcentaje de descuento.
	 *
	 * @return porcentajeDescuento
	 */
	public int getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	/**
	 * String que muestra por pantalla las caracteristicas de la menudencia
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return super.toString() + ": Menudencia con " + porcentajeDescuento + "% de descuento";
	}
	
	@Override
	public TipoDeArticulo getTipo() {
		return TipoDeArticulo.Menudencia;
	}
}
