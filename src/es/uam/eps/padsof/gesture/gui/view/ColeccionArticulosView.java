package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.ColeccionArticulos;

public class ColeccionArticulosView extends JPanel {
	private static final long serialVersionUID = -5082367301518818759L;
	private final ColeccionArticulos coleccion;
	private JTable tabla;
	
	public ColeccionArticulosView(ColeccionArticulos coleccion) {
		super();
		this.coleccion = coleccion;
		this.setPreferredSize(new Dimension(500, 80));
		this.setSize(new Dimension(300, 300));
		
		this.render();
	}
	
	private void render() {
		DefaultTableModel tablaModel = new DefaultTableModel();
		tablaModel.addColumn("Tipo");
		tablaModel.addColumn("Descripcion");
		tablaModel.addColumn("Precio Base");
		
		for (Articulo articulo: coleccion) {
			Object[] row = { 
					articulo.getTipo().toString(),
					articulo.getDescripcion(),
					articulo.getPrecioBase() };
			tablaModel.addRow(row);
		}
		
		tabla = new JTable(tablaModel);
		
		tabla.setPreferredScrollableViewportSize(new Dimension(500, 80));
		
		this.add(tabla);
	}
}
