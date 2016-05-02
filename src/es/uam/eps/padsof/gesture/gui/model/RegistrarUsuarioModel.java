package es.uam.eps.padsof.gesture.gui.model;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarUsuarioModel {
	private String nombre;
	private String password;
	
	public RegistrarUsuarioModel() {
		this.nombre = "Nombre de usuario";
		this.password = "";
	}

	public String getUsername() {
		return nombre;
	}

	public void setUsername(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
