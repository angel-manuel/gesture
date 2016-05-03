package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.ColeccionArticulos;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarVentaView extends View{

	private static final long serialVersionUID = 7269957199443823488L;
	private final ColeccionArticulos coleccion;
	private final JButton venderBtn;
	
	public RegistrarVentaView(ColeccionArticulos coleccion){
		this.coleccion = coleccion;
		this.setPreferredSize(new Dimension(500, 80));
		
		ColeccionArticulosView view = new ColeccionArticulosView(coleccion);
		
		JLabel articulosLbl = new JLabel("Articulos:");
		
		SpringLayout layout = new SpringLayout();
		JPanel formPanel = this;
		setLayout(layout);

		venderBtn = new JButton("Vender");
		
		layout.putConstraint(SpringLayout.WEST, articulosLbl, 250, SpringLayout.WEST, formPanel);
		layout.putConstraint(SpringLayout.NORTH, view, 20, SpringLayout.SOUTH, articulosLbl);
		layout.putConstraint(SpringLayout.WEST, venderBtn, 250, SpringLayout.WEST, formPanel);
		layout.putConstraint(SpringLayout.NORTH, venderBtn, 20, SpringLayout.SOUTH, view);
		
		formPanel.add(articulosLbl);
		formPanel.add(view);
		formPanel.add(venderBtn);
		
		formPanel.setPreferredSize(new Dimension(550, 250));
		
		venderBtn.setActionCommand("registrar click");
		
		setMinimumSize(new Dimension(300, 80));
		setMaximumSize(new Dimension(300, 80));
	}
}
