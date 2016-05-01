package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;

import es.uam.eps.padsof.gesture.Lote;
import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class LoteView extends View {
	private static final long serialVersionUID = -3595143852070250522L;
	
	private final ColeccionArticulosView colView;
	private final JButton añadirArticuloBtn;
	private final JLabel precioTotalLbl;
	
	public LoteView(Lote lote) {
		colView = new ColeccionArticulosView(lote);
		añadirArticuloBtn = new JButton("Añadir artículo");
		precioTotalLbl = new JLabel();
		this.setPrecioTotal(lote.getPrecioBase());
		
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		layout.putConstraint(SpringLayout.WEST, colView, 6, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, colView, 10, SpringLayout.NORTH, this);
		
		layout.putConstraint(SpringLayout.NORTH, añadirArticuloBtn, 0, SpringLayout.NORTH, colView);
		layout.putConstraint(SpringLayout.WEST, añadirArticuloBtn, 6, SpringLayout.EAST, colView);
		
		layout.putConstraint(SpringLayout.NORTH, precioTotalLbl, 10, SpringLayout.SOUTH, añadirArticuloBtn);
		layout.putConstraint(SpringLayout.WEST, precioTotalLbl, 6, SpringLayout.EAST, colView);
		
		this.add(colView);
		this.add(añadirArticuloBtn);
		this.add(precioTotalLbl);
		this.setPreferredSize(new Dimension(800, 300));
	}
	
	@Override
	public void setControlador(Controller c) {
		añadirArticuloBtn.addActionListener(c);
	}

	public void setPrecioTotal(double precio) {
		this.precioTotalLbl.setText("Total: " + Double.toString(precio));
		this.precioTotalLbl.repaint();
	}
}
