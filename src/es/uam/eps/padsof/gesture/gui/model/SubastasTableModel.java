package es.uam.eps.padsof.gesture.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import es.uam.eps.padsof.gesture.subasta.Puja;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastasTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = -579286235502544465L;

	private static final String[] COLS = { "Descripcion", "Salida", "Mejor puja" };

	private List<Subasta> subastas;
	
	public SubastasTableModel(List<Subasta> subastas) {
		this.subastas = subastas;
	}
	
	@Override
	public String getColumnName(int column) {
		return COLS[column];
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return subastas.size();
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return COLS.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Subasta s = subastas.get(rowIndex);
		Puja ultPuj = s.getUltimaPuja();
		
		String[] strs = {
			s.getObjetoSubasta().getDescripcion(),
			Double.toString(s.getPrecioSalida()),
			ultPuj == null ? "Ninguna" : Double.toString(ultPuj.getValor())
		};
		
		return strs[columnIndex];
	}

}
