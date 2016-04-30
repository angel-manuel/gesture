package es.uam.eps.padsof.gesture.balance;

import java.io.Serializable;

/**
 * Representa un concepto del desglose de un precio
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ConceptoPrecio implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private final String nombre;
	private final double cargo;
	
	/**
	 * Constructor de ConceptoPrecio.
	 *
	 * @param nombre Nombre/Descripcion del concepto
	 * @param cargo Cargo por este concepto(negativo si es descuento)
	 */
	public ConceptoPrecio(String nombre, double cargo) {
		this.nombre = nombre;
		this.cargo = cargo;
	}

	/**
	 * Getter de nombre.
	 *
	 * @return el nombre de ConceptoPrecio
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Getter de cargo.
	 *
	 * @return el cargo de ConceptoPrecio
	 */
	public double getCargo() {
		return cargo;
	}
	
	/**
	 * Da una representación en texto del concepto
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return nombre + ":\t" + cargo; 
	}
}
