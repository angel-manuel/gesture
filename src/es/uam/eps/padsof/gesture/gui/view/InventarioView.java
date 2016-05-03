package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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

	private final Tienda tienda;
	
	private final ColeccionArticulosView invView;
	private final JTextField filterFld;
	private final JButton venderBtn;
	private final JButton detallesBtn;
	private final JButton añadirBtn;
	
	public static final String VENDER_COMMAND = "vender";
	public static final String DETALLES_COMMAND = "detalles";
	public static final String AÑADIR_COMMAND = "añadir";

	public static final String FILTER_CHANGED_COMMAND = "filter changed";
	
	public InventarioView(Tienda tienda) {
		this.setLayout(new BorderLayout());
		this.tienda = tienda;
		
		invView = new ColeccionArticulosView(tienda.getInventario());
		
		this.add(invView, BorderLayout.CENTER);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		//btnPnl.setLayout(new FlowLayout());
		
		btnPnl.add(new JLabel("Filtro:"));
		btnPnl.add(filterFld = new JTextField());
		filterFld.setMaximumSize(new Dimension(400, 20));
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
		filterFld.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) { change();}
			public void removeUpdate(DocumentEvent e) { change(); }
			public void insertUpdate(DocumentEvent e) { change(); }
			public void change() {
			   c.actionPerformed(new ActionEvent(filterFld, ActionEvent.ACTION_LAST, FILTER_CHANGED_COMMAND));
			}
		});
		
		venderBtn.addActionListener(c);
		detallesBtn.addActionListener(c);
		añadirBtn.addActionListener(c);
	};
	
	public Articulo getSelectedArticulo() {
		return invView.getSelectedArticulo();
	}
	
	public void refreshFilter() {
		invView.setColeccion(this.tienda.getInventario().filtrarPorDescripcion(filterFld.getText()));
	}

	/**
	 * @return
	 */
	public String getFilter() {
		return filterFld.getText();
	}
}
