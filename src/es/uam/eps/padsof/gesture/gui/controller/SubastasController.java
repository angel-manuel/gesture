package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.MainFrame;
import es.uam.eps.padsof.gesture.gui.view.SubastasView;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastasController extends Controller {
	
	private final Tienda tienda;

	/**
	 * Constructor de SubastasController
	 *
	 * @param view
	 */
	public SubastasController(Tienda tienda) {
		super(new SubastasView(tienda));
		this.tienda = tienda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SubastasView view = (SubastasView)this.view;
		Subasta s = view.getSelectedSubasta();
		
		switch (e.getActionCommand()) {
		case SubastasView.PUJAR_COMMAND:
			RegistrarPujaController pujCtrl = new RegistrarPujaController(tienda, s);
			MainFrame pujDia = new MainFrame("Pujar");
			pujDia.setControladorActual(pujCtrl);
			pujDia.setSize(200, 400);
			pujDia.addWindowListener(new WindowListener() {
				@Override public void windowOpened(WindowEvent e) {}
				@Override public void windowClosing(WindowEvent e) {}
				@Override public void windowClosed(WindowEvent e) {
					view.repaint();
				}
				@Override public void windowIconified(WindowEvent e) {}
				@Override public void windowDeiconified(WindowEvent e) {}
				@Override public void windowActivated(WindowEvent e) {}
				@Override public void windowDeactivated(WindowEvent e) {}
			});
			pujDia.setVisible(true);
			break;
		case SubastasView.PARTICIPATE_COMMAND:
			ParticiparController parCtrl = new ParticiparController(tienda, s);
			MainFrame parDia = new MainFrame("Participar");
			parDia.setControladorActual(parCtrl);
			parDia.setSize(200, 400);
			parDia.addWindowListener(new WindowListener() {
				@Override public void windowOpened(WindowEvent e) {}
				@Override public void windowClosing(WindowEvent e) {}
				@Override public void windowClosed(WindowEvent e) {
					view.repaint();
				}
				@Override public void windowIconified(WindowEvent e) {}
				@Override public void windowDeiconified(WindowEvent e) {}
				@Override public void windowActivated(WindowEvent e) {}
				@Override public void windowDeactivated(WindowEvent e) {}
			});
			parDia.setVisible(true);
			break;
		}
	}
}
