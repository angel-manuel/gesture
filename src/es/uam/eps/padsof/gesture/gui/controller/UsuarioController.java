package es.uam.eps.padsof.gesture.gui.controller;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.UsuarioView;
import es.uam.eps.padsof.gesture.gui.view.View;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class UsuarioController extends Controller {

	public UsuarioController(Tienda tienda) {
		super(new UsuarioView(tienda));
	}

}
