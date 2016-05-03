package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Menudencia;
import es.uam.eps.padsof.gesture.ArticuloVoluminoso;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.TipoDeArticulo;
import es.uam.eps.padsof.gesture.exception.NoALaVentaException;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.gui.view.ArticuloView;
import es.uam.eps.padsof.gesture.gui.view.ArticuloVoluminosoView;
import es.uam.eps.padsof.gesture.gui.view.InventarioView;
import es.uam.eps.padsof.gesture.gui.view.MenudenciaView;
import es.uam.eps.padsof.gesture.gui.view.ObraDeArteView;
import es.uam.eps.padsof.gesture.gui.view.ListaClientesView;
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
		InventarioView view = ((InventarioView)this.view);
		Articulo artSel = view.getSelectedArticulo();
		
		switch (e.getActionCommand()) {
		case InventarioView.FILTER_CHANGED_COMMAND:
			view.refreshFilter();
			break;
		case InventarioView.VENDER_COMMAND:
			if (artSel != null) {
				if (artSel.isALaVenta() == false) {
					JOptionPane.showMessageDialog(frame, artSel.toString() + " no está a la venta", "Error en venta", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				ListaClientesView selCliView = new ListaClientesView(tienda.getClientes());
				JDialog cliDia = new JDialog(frame, true);
				selCliView.addClientSelectedListener(cliente -> {
					if (cliente != null) {
						try {
							tienda.getBalance().registrarVenta(cliente.comprar(artSel));
						} catch (Exception e1) {
							e1.printStackTrace();
							return;
						}
						
						cliDia.dispose();
						view.refreshFilter();
					}
				});
				cliDia.add(selCliView);
				cliDia.setSize(200, 400);
				cliDia.setVisible(true);
			}
			break;
		case InventarioView.DETALLES_COMMAND:
			if (artSel != null) {
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
			}
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
				
				view.refreshFilter();
			}
			
			break;
		default:
			break;
		}
	}
}
