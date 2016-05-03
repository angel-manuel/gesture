package es.uam.eps.padsof.gesture.gui.view;

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

public class ColeccionArticulosView extends JScrollPane {
	private static final long serialVersionUID = -5082367301518818759L;
	private ColeccionArticulos coleccion;
	private JTable table;
	private List<Consumer<Articulo>> selectionListeners = new ArrayList<>();
	
	public ColeccionArticulosView(ColeccionArticulos coleccion) {
		super();
		this.coleccion = coleccion;
		
		table = new JTable(this.coleccion);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getSelectionModel()
		.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Articulo articulo = getSelectedArticulo();
				if (!e.getValueIsAdjusting()) {
					for (Consumer<Articulo> listener: selectionListeners) {
						listener.accept(articulo);
					}
				}
			}});
		
		table.setFillsViewportHeight(true);
		this.setViewportView(table);
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

	/**
	 * Getter de coleccion
	 *
	 * @return el coleccion de ColeccionArticulosView
	 */
	public ColeccionArticulos getColeccion() {
		return coleccion;
	}

	/**
	 * Setter de coleccion
	 *
	 * @param coleccion el coleccion de ColeccionArticulosView
	 */
	public void setColeccion(ColeccionArticulos coleccion) {
		this.coleccion = coleccion;
		this.table.setModel(coleccion);
		this.table.repaint();
	}
}
