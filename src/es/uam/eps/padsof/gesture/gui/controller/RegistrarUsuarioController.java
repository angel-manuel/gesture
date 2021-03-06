package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.gui.view.LoginView;
import es.uam.eps.padsof.gesture.gui.view.RegistrarUsuarioView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarUsuarioController extends Controller{
	private final Tienda tienda;
	
	public RegistrarUsuarioController(Tienda tienda){
		super(new RegistrarUsuarioView());
		this.tienda = tienda;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comm = e.getActionCommand();
		RegistrarUsuarioView view = (RegistrarUsuarioView)this.view;
		
		switch (comm) {
		case LoginView.USER_CHANGED_COMMAND:
			view.setUsuarioStatus(tienda.getUsuarios().stream().anyMatch(usuario -> usuario.getNombre().contentEquals(view.getNombre())));
			break;
		default:
			String nombre = view.getNombre();
			String contraseña = view.getPassword();
			Usuario user = new Usuario(nombre, contraseña);
			
			try {
				if (tienda.añadirUsuario(user)) {
				} else {
					JOptionPane.showMessageDialog(view, "Usuario Existente", "Error de registro", JOptionPane.ERROR_MESSAGE);
					return;
				}
			} catch (HeadlessException | AutorizacionIncorrectaException e1) {
				e1.printStackTrace();
				return;
			}
			
			frame.dispose();
		}
	}
}
