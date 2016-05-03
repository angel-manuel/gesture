package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.ClienteView;
import es.uam.eps.padsof.gesture.gui.view.View;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class AñadirClienteController extends Controller {
	private final Tienda tienda;

	public AñadirClienteController(Tienda tienda, Cliente cliente) {
		super(new ClienteView(cliente, true));
		this.tienda = tienda;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ClienteView view = (ClienteView)this.view;
		Cliente cliente;
		try {
			cliente = view.getCliente();
		} catch (InvalidEmailAddressException e1) {
			JOptionPane.showMessageDialog(frame, "Direccion de email invalida", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		tienda.añadirCliente(cliente);
		frame.dispose();
	}
}
