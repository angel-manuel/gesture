package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.model.LoginModel;
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
	private Usuario model = null;
	private LoginView view;
	
	public LoginController(Tienda tienda, LoginView view) {
		this.tienda = tienda;
		this.view = view;
		
		view.setControlador(this);
	}

	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		
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
				break;
		}
	}

	@Override
	public JPanel getView() {
		return view;
	}

	@Override
	public void detachView() {
		view = null;	
	}
}
