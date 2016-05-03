package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.MainFrame;
import es.uam.eps.padsof.gesture.gui.view.ObrasView;
import es.uam.eps.padsof.gesture.gui.view.View;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ObrasController extends Controller {
	private final Tienda tienda;

	public ObrasController(Tienda tienda) {
		super(new ObrasView(tienda));
		this.tienda = tienda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ObrasView view = (ObrasView)this.view;
		ObraDeArte selObra = view.getSelectedObra();
		
		switch (e.getActionCommand()) {
		case ObrasView.SUBASTA_OBRA_COMMAND:
			if (selObra == null) {
				return;
			}
			
			MainFrame subDia = new MainFrame("Subastar");
			subDia.setControladorActual(new SubastaController(tienda, selObra));
			subDia.setVisible(true);
			break;
		}
	}
}
