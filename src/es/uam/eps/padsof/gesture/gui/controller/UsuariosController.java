package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.MainFrame;
import es.uam.eps.padsof.gesture.gui.view.UsuariosView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class UsuariosController extends Controller {
	private final Tienda tienda;

	public UsuariosController(Tienda tienda) {
		super(new UsuariosView(tienda));
		this.tienda = tienda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == UsuariosView.ADD_USER_COMMAND) {
			MainFrame addUsuDia = new MainFrame("Añadir usuario");
			addUsuDia.setControladorActual(new RegistrarUsuarioController(tienda));
			addUsuDia.addWindowListener(new WindowListener() {
				@Override public void windowOpened(WindowEvent e) {}
				@Override public void windowClosing(WindowEvent e) {}
				@Override public void windowClosed(WindowEvent e) {
					((UsuariosView)view).refresh();
				}
				@Override public void windowIconified(WindowEvent e) {}
				@Override public void windowDeiconified(WindowEvent e) {}
				@Override public void windowActivated(WindowEvent e) {}
				@Override public void windowDeactivated(WindowEvent e) {}
			});
			addUsuDia.setVisible(true);
		}
	}
}
