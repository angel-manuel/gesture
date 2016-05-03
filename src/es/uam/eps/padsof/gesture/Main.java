package es.uam.eps.padsof.gesture;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.uam.eps.padsof.gesture.gui.controller.LoginController;
import es.uam.eps.padsof.gesture.gui.view.MainFrame;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame("Gesture");
		
		Tienda tienda = Tienda.cargarDeArchivo("tienda.gesture");
		mainFrame.setControladorActual(new LoginController(tienda));
		
		mainFrame.addWindowListener(new WindowListener() {
			@Override public void windowOpened(WindowEvent e) {}
			@Override public void windowClosing(WindowEvent e) {}
			@Override public void windowClosed(WindowEvent e) {
				Tienda.guardarEnArchivo(tienda, "tienda.gesture");
			}
			@Override public void windowIconified(WindowEvent e) {}
			@Override public void windowDeiconified(WindowEvent e) {}
			@Override public void windowActivated(WindowEvent e) {}
			@Override public void windowDeactivated(WindowEvent e) {}
		});
		
		mainFrame.setVisible(true);
	}

}
