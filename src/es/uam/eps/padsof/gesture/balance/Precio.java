package es.uam.eps.padsof.gesture.balance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Representa un precio con un desglose interno
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Precio implements Serializable, Iterable<ConceptoPrecio> {
	private static final long serialVersionUID = 20160329L;
	private ArrayList<ConceptoPrecio> desglose = new ArrayList<>();
	
	/**
	 * Constructor de Precio.
	 */
	public Precio() {
	}
	
	/**
	 * Añade un concepto.
	 *
	 * @param concepto Concepto a añadir
	 */
	public void añadirConcepto(ConceptoPrecio concepto) {
		desglose.add(concepto);
	}
	
	/**
	 * Calcula el total.
	 *
	 * @return Suma total de los cargos de los conceptos del desglose
	 */
	public double calcularTotal() {
		double sum = 0.0;
		
		for (ConceptoPrecio concepto: desglose) {
			sum += concepto.getCargo();
		}
		
		return sum;
	}
	
	/**
	 * Suma conceptos de cierto tipo.
	 *
	 * @param nombreConcepto Parte del nombre de concepto(se buscará en los conceptos)
	 * @return sum Suma de los cargos de los conceptos del desglose con el
	 * nombre que se pasa por argumento
	 */
	public double sumaConceptos(String nombreConcepto) {
		double sum = 0.0;
		
		for (ConceptoPrecio concepto: desglose) {
			if (concepto.getNombre().contains(nombreConcepto)) {
				sum += concepto.getCargo();
			}
		}
		
		return sum;
	}
	
	/**
	 * Da una representación textual de este precio. Formato estilo ticket.
	 *
	 * @return ret Representación textual de este precio
	 */
	@Override
	public String toString() {
		String ret = "";
		
		for (ConceptoPrecio concepto: desglose) {
			ret += concepto + "\n";
		}
		
		return ret;
	}

	/* (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<ConceptoPrecio> iterator() {
		return desglose.iterator();
	}
}
