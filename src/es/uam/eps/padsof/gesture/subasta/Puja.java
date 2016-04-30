package es.uam.eps.padsof.gesture.subasta;

import java.io.Serializable;

import es.uam.eps.padsof.gesture.Cliente;

/**
 * Representa una puja.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Puja implements Serializable {
	private static final long serialVersionUID = 20160329L;
	
	/* Distancia minima entre puja y puja */
	private static final double DISTANCIA_MINIMA = 0.05;
	private Cliente postor;
	private double valor;
	
	/**
	 * Constructor de Puja.
	 *
	 * @param postor
	 * @param valor
	 */
	public Puja(Cliente postor, double valor) {
		this.postor = postor;
		this.valor = valor;
	}

	/**
	 * Getter de postor.
	 *
	 * @return el postor de Puja
	 */
	public Cliente getPostor() {
		return postor;
	}

	/**
	 * Getter de valor.
	 *
	 * @return el valor de Puja
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * Comprueba si la puja es superior a la anterior
	 *
	 * @param otra La puja anterior
	 * @return si la puja es superior a la anterior
	 */
	public boolean isSuperior(Puja otra) {
		return (valor - otra.valor) > DISTANCIA_MINIMA;
	}
}
