package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

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
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
			this.remove(this.controladorActual.getView());
			this.controladorActual.detachView();
		}
		
		this.controladorActual = controlador;
		this.add(controlador.getView());
		this.pack();
	}
}
