package es.uam.eps.padsof.gesture.subasta;

import java.io.Serializable;
import java.util.Date;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.balance.Precio;

/**
 * Representa una participación en una subasta.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ParticipacionSubasta implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private final Cliente participante;
	private final Subasta subasta;
	private final Precio precio;
	private final Date fecha;
	
	/**
	 * Constructor de ParticipacionSubasta.
	 *
	 * @param participante Participante
	 * @param subasta Subasta
	 * @param precio Precio de participación
	 */
	public ParticipacionSubasta(Cliente participante, Subasta subasta,
			Precio precio) {
		this.participante = participante;
		this.subasta = subasta;
		this.precio = precio;
		this.fecha = new Date();
	}
	
	/**
	 * Getter de participante.
	 *
	 * @return el participante de ParticipacionSubasta
	 */
	public Cliente getParticipante() {
		return participante;
	}
	
	/**
	 * Getter de subasta.
	 *
	 * @return el subasta de ParticipacionSubasta
	 */
	public Subasta getSubasta() {
		return subasta;
	}
	
	/**
	 * Getter de precio.
	 *
	 * @return el precio de ParticipacionSubasta
	 */
	public Precio getPrecio() {
		return precio;
	}
	
	/**
	 * Getter de fecha.
	 *
	 * @return el fecha de ParticipacionSubasta
	 */
	public Date getFecha() {
		return fecha;
	}
}
