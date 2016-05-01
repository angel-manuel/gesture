package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.RegistrarClienteView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarClienteController extends Controller {
	private final Tienda tienda;
	private Cliente model = null;
	
	/**
	 * Constructor de RegistrarClienteController
	 * 
	 * @param view
	 */
	public RegistrarClienteController(Tienda tienda, RegistrarClienteView view) {
		super(view);
		this.tienda = tienda;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		RegistrarClienteView view = (RegistrarClienteView)this.view;
		
		try {
			model = new Cliente(
				view.getNombre(),
				view.getApellidos(),
				view.getEmail(),
				view.getDireccion(),
				view.getCodigoPostal(),
				view.getPoliticaNotificacion()
			);
		} catch (InvalidEmailAddressException e1) {
			JOptionPane.showMessageDialog(view, "Introduzca un correo valido", "Correo invalido", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		tienda.añadirCliente(model);
	}
	
	
}
