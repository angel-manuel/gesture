package es.uam.eps.padsof.gesture;

import java.io.Serializable;
import java.util.Date;


/**
 * Representa un artículo voluminoso
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ArticuloVoluminoso extends Articulo implements Serializable {
	private static final long serialVersionUID = 20160326L;
	private static final double PORTE_GRANDE = 50.0;
	private static final double PORTE_BASE_PEQUEÑO = 20.0;
	private static final double UMBRAL_PESADO = 15.0;
	private static final double EXTRA_PESADO_PESO = 5.0;
	private static final double EXTRA_PESADO_PORTE = 2.0;

	private double peso;
	private double alto;
	private double ancho;
	private double largo;
	
	/**
	 * Constructor de ArticuloVoluminoso.
	 *
	 * @param peso Peso(Kg)
	 * @param alto Alto(m)
	 * @param ancho Ancho(m)
	 * @param largo Largo(m)
	 */
	public ArticuloVoluminoso(String descripcion, double precioBase, String año, Date fechaAdquisicion,
			double costeAdquisicion, double peso, double alto, double ancho, double largo) {
		super(descripcion, precioBase, año, fechaAdquisicion, costeAdquisicion);
		this.peso = peso;
		this.alto = alto;
		this.ancho = ancho;
		this.largo = largo;
	}
	
	/**
	 * Calcula los gastos de envio
	 *
	 * @return los gastos de envio
	 */
	@Override
	public double calcularGastosEnvio() {
		if (alto > EXTRA_PESADO_PORTE || ancho > EXTRA_PESADO_PORTE || largo > EXTRA_PESADO_PORTE) {
			return PORTE_GRANDE;
		} else {
			if(peso > UMBRAL_PESADO) {
				return PORTE_BASE_PEQUEÑO + EXTRA_PESADO_PORTE*Math.ceil((peso - UMBRAL_PESADO)/EXTRA_PESADO_PESO);
			} else {
				return PORTE_BASE_PEQUEÑO;
			}
		}
	}
	/**
	 * Obtiene el peso del articulo
	 * @return peso Peso
	 */
	public double getPeso(){
		return peso;
	}
	/**
	 * Obtiene el alto del articulo
	 * @return alto Alto
	 */
	public double getAlto(){
		return alto;
	}
	/**
	 * Obtiene el ancho del articulo
	 * @return ancho Ancho
	 */
	public double getAncho(){
		return ancho;
	}
	/**
	 * Obtiene el largo del articulo
	 * @return largo Largo
	 */
	public double getLargo(){
		return largo;
	}
	
	/**
	 * String que muestra por pantalla las caracteristicas del articulo voluminoso
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return super.toString() + ": Voluminoso " + String.format("%.2fx%.2fx%.2f %.2fKg", alto, ancho, largo, peso);
	}

	/**
	 * Obtiene el tipo de articulo
	 *
	 * @return TipoDeArticulo.Voluminoso
	 */
	@Override
	public TipoDeArticulo getTipo() {
		return TipoDeArticulo.Voluminoso;
	}
}
