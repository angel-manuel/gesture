package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
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

	public ClientesController(Tienda tienda) {
		super(new ClientesView(tienda));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClientesView view = (ClientesView)this.view;
		Cliente selCli = view.getSelectedCliente();
		
		switch (e.getActionCommand()) {
		case ClientesView.ADD_CLIENT_COMMAND:
			MainFrame addCliDia = new MainFrame("Añadir Cliente");
			break;
		case ClientesView.CLIENT_DETAILS_COMMAND:
			if (selCli != null) {
				
			}
			break;
		default:
			break;
		}
	}
}
