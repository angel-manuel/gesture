package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.LoginView;
import es.uam.eps.padsof.gesture.gui.view.RegistrarUsuarioView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarUsuarioController extends Controller{
	private final Tienda tienda;
	
	public RegistrarUsuarioController(Tienda tienda, RegistrarUsuarioView view){
		super(view);
		this.tienda = tienda;
		
		view.setControlador(this);
	}
	
	public void ActionPerformed(ActionEvent e){
		String comm = e.getActionCommand();
		RegistrarUsuarioView view = (RegistrarUsuarioView)this.view;
		
		
	}
}
