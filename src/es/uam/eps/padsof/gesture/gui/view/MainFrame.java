package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2314913083107430405L;
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
