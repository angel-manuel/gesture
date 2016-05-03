package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.controller.ClientesController;
import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.controller.InventarioController;
import es.uam.eps.padsof.gesture.gui.controller.SubastasController;
import es.uam.eps.padsof.gesture.gui.controller.UsuariosController;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class GerenteView extends View {
	private static final long serialVersionUID = -3740038922611181989L;
	private final JPanel upperPanel;
	private final JTabbedPane tabs;
	private final JButton logoutBtn;

	public GerenteView(Tienda tienda) {
		setLayout(new BorderLayout());
		
		upperPanel = new JPanel();
		upperPanel.add(new JLabel(tienda.getUsuarioLogeado().getNombre()));
		upperPanel.add(logoutBtn = new JButton("Logout"));
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		
		UsuariosController usuCtrl = new UsuariosController(tienda);
		tabs.add("Usuarios", usuCtrl.getView());
		/*ObrasController obrasCtrl = new ObrasController(tienda);
		tabs.add("Obras de arte", obrasCtrl.getView());
		LotesController lotCtrl = new LotesController(tienda);
		tabs.add("Lotes", lotCtrl.getView());
		SubastasGController subasCtrl = new SubastasGController(tienda);
		tabs.add("Subastas", subasCtrl.getView());*/
		
		this.add(upperPanel, BorderLayout.NORTH);
		this.add(tabs, BorderLayout.CENTER);
	}
	
	public void setControlador(final Controller c) {
		logoutBtn.addActionListener(c);
	}
}
