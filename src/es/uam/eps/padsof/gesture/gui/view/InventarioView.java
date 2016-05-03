package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class InventarioView extends View {
	private static final long serialVersionUID = 243059792546772343L;

	private final ColeccionArticulosView invView;
	private final JButton venderBtn;
	private final JButton detallesBtn;
	private final JButton añadirBtn;
	
	public static final String VENDER_COMMAND = "vender";
	public static final String DETALLES_COMMAND = "detalles";
	public static final String AÑADIR_COMMAND = "añadir";
	
	public InventarioView(Tienda tienda) {
		this.setLayout(new BorderLayout());
		
		invView = new ColeccionArticulosView(tienda.getInventario());
		
		this.add(invView, BorderLayout.CENTER);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		//btnPnl.setLayout(new FlowLayout());
		
		btnPnl.add(venderBtn = new JButton("Vender"));
		venderBtn.setActionCommand(VENDER_COMMAND);
		btnPnl.add(detallesBtn = new JButton("Mostrar detalles"));
		detallesBtn.setActionCommand(DETALLES_COMMAND);
		btnPnl.add(añadirBtn = new JButton("Añadir de archivo"));
		añadirBtn.setActionCommand(AÑADIR_COMMAND);
		
		this.add(btnPnl, BorderLayout.EAST);
	}
	
	@Override
	public void setControlador(final Controller c) {
		venderBtn.addActionListener(c);
		detallesBtn.addActionListener(c);
		añadirBtn.addActionListener(c);
	};
	
	public Articulo getSelectedArticulo() {
		return invView.getSelectedArticulo();
	}
}
