package es.uam.eps.padsof.gesture.exception;

import es.uam.eps.padsof.gesture.Cliente;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ParticipacionSinContratoException extends Exception {
	private static final long serialVersionUID = 20160328L;
	private final Cliente clienteSinContrato;
	
	/**
	 * Constructor de ParticipacionSinContratoException
	 *
	 * @param clienteSinContrato
	 */
	public ParticipacionSinContratoException(Cliente clienteSinContrato) {
		this.clienteSinContrato = clienteSinContrato;
	}
	
	/**
	 * Getter de clienteSinContrato
	 *
	 * @return el clienteSinContrato de ParticipacionSinContratoException
	 */
	public Cliente getClienteSinContrato() {
		return clienteSinContrato;
	}
}
