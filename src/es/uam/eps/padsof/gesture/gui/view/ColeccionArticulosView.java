package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import es.uam.eps.padsof.gesture.ColeccionArticulos;

public class ColeccionArticulosView extends View {
	private static final long serialVersionUID = -5082367301518818759L;
	private final ColeccionArticulos coleccion;
	private JTable table;
	
	public ColeccionArticulosView(ColeccionArticulos coleccion) {
		super();
		this.coleccion = coleccion;
		this.setPreferredSize(new Dimension(500, 80));
		this.setSize(new Dimension(300, 300));
		
		table = new JTable(this.coleccion);
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		this.add(new JScrollPane(table));
		this.setPreferredSize(new Dimension(600, 300));
	}
}
