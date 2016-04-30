package es.uam.eps.padsof.gesture.gui.model;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastaModel {
	private String precioSalida;
	private String objetoSubasta;
	private String duracion;
	
	
	public SubastaModel() {
		this.precioSalida = "Precio de Salida";
		this.objetoSubasta = "Objeto a subastar";
		this.duracion = "Duración de la subasta";
	}


	/**
	 * Getter de precioSalida
	 *
	 * @return el precioSalida de SubastaModel
	 */
	public String getPrecioSalida() {
		return precioSalida;
	}


	/**
	 * Setter de precioSalida
	 *
	 * @param precioSalida el precioSalida de SubastaModel
	 */
	public void setPrecioSalida(String precioSalida) {
		this.precioSalida = precioSalida;
	}


	/**
	 * Getter de objetoSubasta
	 *
	 * @return el objetoSubasta de SubastaModel
	 */
	public String getObjetoSubasta() {
		return objetoSubasta;
	}


	/**
	 * Setter de objetoSubasta
	 *
	 * @param objetoSubasta el objetoSubasta de SubastaModel
	 */
	public void setObjetoSubasta(String objetoSubasta) {
		this.objetoSubasta = objetoSubasta;
	}


	/**
	 * Getter de duracion
	 *
	 * @return el duracion de SubastaModel
	 */
	public String getDuracion() {
		return duracion;
	}


	/**
	 * Setter de duracion
	 *
	 * @param duracion el duracion de SubastaModel
	 */
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	
	
}
