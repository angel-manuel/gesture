package es.uam.eps.padsof.gesture.exception;

import es.uam.eps.padsof.gesture.subasta.Puja;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class PujaRechazadaException extends Exception {
	private static final long serialVersionUID = 20160328L;
	private final Puja pujaRechazada;
	private final String motivo;
	
	/**
	 * Constructor de PujaRechazadaException
	 *
	 * @param pujaRechazada
	 * @param motivo
	 */
	public PujaRechazadaException(Puja pujaRechazada, String motivo) {
		this.pujaRechazada = pujaRechazada;
		this.motivo = motivo;
	}
	
	/**
	 * Getter de pujaRechazada
	 *
	 * @return el pujaRechazada de PujaRechazadaException
	 */
	public Puja getPujaRechazada() {
		return pujaRechazada;
	}
	
	/**
	 * Getter de motivo
	 *
	 * @return el motivo de PujaRechazadaException
	 */
	public String getMotivo() {
		return motivo;
	}
}
