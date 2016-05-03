package es.uam.eps.padsof.gesture.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import es.uam.eps.padsof.gesture.ObraDeArte;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ObrasTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 2627850375855616771L;
	
	private static final String[] COLS = { "Descripcion", "Autor", "Año", "Precio", "Certificado", "Vendible" };

	private List<ObraDeArte> obras;
	
	public ObrasTableModel(List<ObraDeArte> obras) {
		this.obras = obras;
	}

	@Override
	public String getColumnName(int column) {
		return COLS[column];
	}
	
	@Override
	public Class getColumnClass(int column) {
		Class[] cls = {
			String.class,
			String.class,
			String.class,
			String.class,
			Boolean.class,
			Boolean.class
		};
		
		return cls[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return column == 5;
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return COLS.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return obras.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int row, int col) {
		ObraDeArte obra = obras.get(row);
		
		Object[] strs = {
			obra.getDescripcion(),
			obra.getAutor(),
			obra.getAño(),
			Double.toString(obra.getPrecioBase()),
			new Boolean(obra.getCertificado()),
			new Boolean(obra.isALaVenta())
		};
		
		return strs[col];
	}

	/**
	 * @param selectedRow
	 * @return
	 */
	public ObraDeArte getObra(int selectedRow) {
		try {
			return obras.get(selectedRow);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
