package es.uam.eps.padsof.gesture.gui.controller;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.GerenteView;
import es.uam.eps.padsof.gesture.gui.view.View;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class GerenteController extends Controller {

	public GerenteController(Tienda tienda) {
		super(new GerenteView(tienda));
	}

}
