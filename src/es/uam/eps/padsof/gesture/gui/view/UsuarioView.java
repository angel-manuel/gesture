package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.controller.ClientesController;
import es.uam.eps.padsof.gesture.gui.controller.InventarioController;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class UsuarioView extends View {
	private static final long serialVersionUID = -2011686703563102934L;
	private JPanel upperPanel;
	private JTabbedPane tabs;
	
	public UsuarioView(Tienda tienda) {
		setLayout(new BorderLayout());
		
		upperPanel = new JPanel();
		upperPanel.add(new JLabel(tienda.getUsuarioLogeado().getNombre()));
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		
		InventarioController invCtrl = new InventarioController(tienda);
		tabs.add("Inventario", invCtrl.getView());
		ClientesController cliCtrl = new ClientesController(tienda);
		tabs.add("Clientes", cliCtrl.getView());
		
		this.add(upperPanel, BorderLayout.NORTH);
		this.add(tabs, BorderLayout.CENTER);
	}
}
