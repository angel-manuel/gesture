package es.uam.eps.padsof.gesture.subasta;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.Cliente;

/**
 * Representa el resultado final de una subasta.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ResultadoSubasta implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private final Cliente ganador;
	private final double precioFinal;
	private final Subastable objetoSubasta;
	private final Date fecha;
	
	/**
	 * Constructor de ResultadoSubasta.
	 *
	 * @param ganador Ganador de la subasta
	 * @param precioFinal Precio final(valor de la puja ganadora)
	 * @param objetoSubasta Objeto subastado
	 */
	public ResultadoSubasta(Cliente ganador, double precioFinal,
			Subastable objetoSubasta) {
		this.ganador = ganador;
		this.precioFinal = precioFinal;
		this.objetoSubasta = objetoSubasta;
		this.fecha = new Date();
	}

	/**
	 * Getter de ganador.
	 *
	 * @return el ganador de ResultadoSubasta
	 */
	public Cliente getGanador() {
		return ganador;
	}

	/**
	 * Getter de precioFinal.
	 *
	 * @return el precio de ResultadoSubasta
	 */
	public double getPrecioFinal() {
		return precioFinal;
	}

	/**
	 * Getter de objetoSubasta.
	 *
	 * @return el objetoSubasta de ResultadoSubasta
	 */
	public Subastable getObjetoSubasta() {
		return objetoSubasta;
	}

	/**
	 * Getter de fecha.
	 *
	 * @return la fecha de ResultadoSubasta
	 */
	public Date getFecha() {
		return fecha;
	}
}
