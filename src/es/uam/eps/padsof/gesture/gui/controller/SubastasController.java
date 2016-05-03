package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import es.uam.eps.padsof.gesture.Tienda;
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

	/**
	 * Constructor de SubastasController
	 *
	 * @param view
	 */
	public SubastasController(Tienda tienda) {
		super(new SubastasView(tienda));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SubastasView view = (SubastasView)this.view;
		Subasta s = view.getSelectedSubasta();
		
		switch (e.getActionCommand()) {
		case SubastasView.PUJAR_COMMAND:
			break;
		case SubastasView.SUBSCRIBE_COMMAND:
			break;
		}
	}
}
