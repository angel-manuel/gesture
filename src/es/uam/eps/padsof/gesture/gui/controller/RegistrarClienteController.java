package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.emailconnection.InvalidEmailAddressException;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.PoliticaNotificacion;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.model.LoginModel;
import es.uam.eps.padsof.gesture.gui.model.RegistrarClienteModel;
import es.uam.eps.padsof.gesture.gui.view.LoginView;
import es.uam.eps.padsof.gesture.gui.view.RegistrarClienteView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarClienteController implements ActionListener {
	private final Tienda tienda;
	private Cliente model = null;
	private final RegistrarClienteView view;
	
	/**
	 * Constructor de RegistrarClienteController
	 * 
	 * @param view
	 */
	public RegistrarClienteController(Tienda tienda, RegistrarClienteView view) {
		this.tienda = tienda;
		this.view = view;
		
		view.setControlador(this);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Cliente cliente;
		
		try {
			cliente = new Cliente(
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
		
		model = cliente;
		
		tienda.añadirCliente(cliente);
	}
	
	
}
