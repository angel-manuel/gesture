package es.uam.eps.padsof.gesture.gui.model;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarClienteModel {
	private String nombre;
	private String apellido;
	private String email;
	private String direccion;
	private String codigoPostal;
	/**
	 * Constructor de RegistrarClienteModel
	 *
	 * @param nombre
	 * @param apellido
	 * @param email
	 * @param direccion
	 * @param codigoPostal
	 */
	public RegistrarClienteModel() {
		this.nombre = "Nombre del cliente";
		this.apellido = "Apellidos del cliente";
		this.email = "Correo electronico del cliente";
		this.direccion = "Direccion del cliente";
		this.codigoPostal = "Codigo postal del cliente";
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
	
	
}
