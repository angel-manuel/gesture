package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.ColeccionArticulos;

public class ColeccionArticulosView extends View {
	private static final long serialVersionUID = -5082367301518818759L;
	private final ColeccionArticulos coleccion;
	private JTable table;
	private List<Consumer<Articulo>> selectionListeners = new ArrayList<>();
	
	public ColeccionArticulosView(ColeccionArticulos coleccion) {
		super();
		this.coleccion = coleccion;
		this.setPreferredSize(new Dimension(500, 80));
		
		table = new JTable(this.coleccion);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel()
		.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Articulo articulo = getSelectedArticulo();
				if (articulo != null && !e.getValueIsAdjusting()) {
					for (Consumer<Articulo> listener: selectionListeners) {
						listener.accept(articulo);
					}
				}
			}});
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		this.add(new JScrollPane(table));
		this.setPreferredSize(new Dimension(550, 250));
	}
	
	public Articulo getSelectedArticulo() {
		int selectedRow = table.getSelectedRow();
		
		if (selectedRow >= 0) {
			return coleccion.get(selectedRow);
		} else {
			return null;
		}
	}
	
	public void addSelectionListener(Consumer<Articulo> listener) {
		selectionListeners.add(listener);
	}
}
