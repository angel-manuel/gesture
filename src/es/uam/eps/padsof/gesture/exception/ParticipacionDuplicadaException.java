package es.uam.eps.padsof.gesture.exception;

import es.uam.eps.padsof.gesture.Cliente;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ParticipacionDuplicadaException extends Exception {
	private static final long serialVersionUID = 20160328L;
	private final Cliente clienteDuplicado;
	
	/**
	 * Constructor de ParticipacionDuplicadaException
	 *
	 * @param clienteDuplicado
	 */
	public ParticipacionDuplicadaException(Cliente clienteDuplicado) {
		this.clienteDuplicado = clienteDuplicado;
	}
	
	/**
	 * Getter de clienteDuplicado
	 *
	 * @return el clienteDuplicado de ParticipacionDuplicadaException
	 */
	public Cliente getClienteDuplicado() {
		return clienteDuplicado;
	}
}
