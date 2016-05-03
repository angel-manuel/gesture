package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Menudencia;
import es.uam.eps.padsof.gesture.ArticuloVoluminoso;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.TipoDeArticulo;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.gui.view.ArticuloView;
import es.uam.eps.padsof.gesture.gui.view.ArticuloVoluminosoView;
import es.uam.eps.padsof.gesture.gui.view.InventarioView;
import es.uam.eps.padsof.gesture.gui.view.MenudenciaView;
import es.uam.eps.padsof.gesture.gui.view.ObraDeArteView;
import es.uam.eps.padsof.gesture.gui.view.View;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class InventarioController extends Controller {
	private final Tienda tienda;

	public InventarioController(Tienda tienda) {
		super(new InventarioView(tienda));
		this.tienda = tienda;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Articulo artSel = ((InventarioView)view).getSelectedArticulo();
		
		switch (e.getActionCommand()) {
		case InventarioView.VENDER_COMMAND:
			try {
				artSel.retirarDeInventario();
			} catch (NoAñadidoATiendaException | NoEstaEnInventarioException e1) {
				e1.printStackTrace();
			}
			view.repaint();
			break;
		case InventarioView.DETALLES_COMMAND:
			JDialog detDia = new JDialog(frame, true);
			switch (artSel.getTipo()) {
			case Menudencia:
				detDia.add(new MenudenciaView((Menudencia)artSel));
				break;
			case Voluminoso:
				detDia.add(new ArticuloVoluminosoView((ArticuloVoluminoso)artSel));
				break;
			case ObraDeArte:
				detDia.add(new ObraDeArteView((ObraDeArte)artSel));
				break;
			}
			detDia.setVisible(true);
			break;
		case InventarioView.AÑADIR_COMMAND:
			JFileChooser fc = new JFileChooser();
			int fc_ret = fc.showOpenDialog(frame);
			
			if (fc_ret == JFileChooser.APPROVE_OPTION) {
				try {
					tienda.getInventario().cargarArticulosDeArchivo(fc.getSelectedFile());
				} catch (IOException | ParseException e1) {
					e1.printStackTrace();
					return;
				}
				
				view.repaint();
			}
			
			break;
		default:
			break;
		}
	}
}
