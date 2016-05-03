package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.UsuarioView;

public class UsuarioController extends Controller {
	private final Tienda tienda;
	
	public UsuarioController(Tienda tienda) {
		super(new UsuarioView(tienda));
		this.tienda = tienda;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.setControladorActual(new LoginController(tienda));
	}
}
