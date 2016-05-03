package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.ClienteView;
import es.uam.eps.padsof.gesture.gui.view.ClientesView;
import es.uam.eps.padsof.gesture.gui.view.MainFrame;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ClientesController extends Controller {
	private final Tienda tienda;

	public ClientesController(Tienda tienda) {
		super(new ClientesView(tienda));
		this.tienda = tienda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClientesView view = (ClientesView)this.view;
		Cliente selCli = view.getSelectedCliente();
		
		switch (e.getActionCommand()) {
		case ClientesView.ADD_CLIENT_COMMAND:
			MainFrame addCliDia = new MainFrame("Añadir Cliente");
			try {
				addCliDia.setControladorActual(new AñadirClienteController(tienda, 
						new Cliente("", "", "client@servidor", "", "", PoliticaNotificacion.AlParticipar)));
			} catch (InvalidEmailAddressException e1) {
				e1.printStackTrace();
				return;
			}
			addCliDia.addWindowListener(new WindowListener() {
				@Override public void windowOpened(WindowEvent e) {}
				@Override public void windowClosing(WindowEvent e) {}
				@Override public void windowClosed(WindowEvent e) {
					view.refresh();
					view.repaint();
				}
				@Override public void windowIconified(WindowEvent e) {}
				@Override public void windowDeiconified(WindowEvent e) {}
				@Override public void windowActivated(WindowEvent e) {}
				@Override public void windowDeactivated(WindowEvent e) {}
			});
			addCliDia.setVisible(true);
			break;
		case ClientesView.CLIENT_DETAILS_COMMAND:
			if (selCli != null) {
				MainFrame cliDetDia = new MainFrame("Detalles de cliente");
				cliDetDia.setControladorActual(new VoidController(new ClienteView(selCli, false)));
				cliDetDia.setVisible(true);
			}
			break;
		default:
			break;
		}
	}
}
