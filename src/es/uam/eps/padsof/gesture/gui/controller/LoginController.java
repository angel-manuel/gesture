package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.LoginView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class LoginController extends Controller {
	private final Tienda tienda;
	
	public LoginController(Tienda tienda) {
		super(new LoginView());
		this.tienda = tienda;
	}

	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		LoginView view = (LoginView)this.view;
		
		switch (comm) {
			case LoginView.USER_CHANGED_COMMAND:
				view.setClienteStatus(tienda.getUsuarios().stream().anyMatch(usuario -> usuario.getNombre().contentEquals(view.getNombre())));
				break;
			default:
				String nombre = view.getNombre();
				String contraseña = view.getContraseña();
				
				if (tienda.log(nombre, contraseña)) {
				} else {
					JOptionPane.showMessageDialog(view, "Contraseña incorrecta", "Error de login", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (tienda.getUsuarioLogeado().isGerente()) {
					this.frame.setControladorActual(new GerenteController(tienda));
				} else {
					this.frame.setControladorActual(new UsuarioController(tienda));
				}
		}
	}
}
