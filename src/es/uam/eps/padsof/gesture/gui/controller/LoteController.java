package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.util.Date;

import es.uam.eps.padsof.gesture.Lote;
import es.uam.eps.padsof.gesture.Menudencia;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.ColeccionArticulosView;
import es.uam.eps.padsof.gesture.gui.view.LoteView;
import es.uam.eps.padsof.gesture.gui.view.MainFrame;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class LoteController extends Controller {
	private final Tienda tienda;
	private final Lote lote;
	
	/**
	 * Constructor de LoteController
	 * @param tienda 
	 *
	 * @param view
	 */
	public LoteController(Tienda tienda, Lote lote) {
		super(new LoteView(lote));
		this.tienda = tienda;
		this.lote = lote;
	}
	
	public void actionPerformed(ActionEvent e) {
		LoteView view = (LoteView)this.getView();
		
		MainFrame selectDialog = new MainFrame();
		selectDialog.setControladorActual(new VoidController(new ColeccionArticulosView(tienda.getInventario())));
		((ColeccionArticulosView)selectDialog.getControladorActual().getView())
			.addSelectionListener(articulo -> { 
				lote.añadirArticulo(articulo);
				selectDialog.setVisible(false);
			});
		selectDialog.pack();
		selectDialog.setVisible(true);
		
		view.setPrecioTotal(lote.getPrecioBase());
	}
}
