package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.controller.LoginController;
import es.uam.eps.padsof.gesture.gui.model.LoginModel;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class MainFrame extends JFrame {
	private Controller controladorActual;
	
	public MainFrame() {
		super("Gesture");
		setLayout(new BorderLayout());
		setSize(800, 600);
		setVisible(true);
	}

	/**
	 * Getter de controladorActual
	 *
	 * @return el controladorActual de MainFrame
	 */
	public Controller getControladorActual() {
		return controladorActual;
	}

	/**
	 * Setter de controladorActual
	 *
	 * @param controladorActual el controladorActual de MainFrame
	 */
	public void setControladorActual(Controller controlador) {
		if (this.controladorActual != null) {
			this.controladorActual.detachView();
		}
		
		this.controladorActual = controlador;
		this.removeAll();
		this.add(controlador.getView(), BorderLayout.CENTER);
		this.repaint();
	}
}
