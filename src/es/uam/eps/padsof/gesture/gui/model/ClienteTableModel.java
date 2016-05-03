package es.uam.eps.padsof.gesture.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.ContratoEstandar;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ClienteTableModel extends AbstractTableModel implements TableModel {

	private static final long serialVersionUID = 2088224891473905234L;

	private static final String[] COLS = { "Nombre", "Apellidos", "Contrato" };

	private List<Cliente> clientes;
	
	public ClienteTableModel(List<Cliente> clientes) {
		this.clientes = clientes;
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
		return clientes.size();
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
		Cliente c = clientes.get(rowIndex);
		
		String[] strs = {
			c.getNombre(),
			c.getApellido(),
			c.getContrato() == null ? "Ninguno" : ((c.getContrato() instanceof ContratoEstandar) ? "Estandar" : "Preferente") 
		};
		
		return strs[columnIndex];
	}

	/**
	 * @param selectedRow
	 * @return
	 */
	public Cliente getClient(int selectedRow) {
		try {
			return clientes.get(selectedRow);
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public void setClients(List<Cliente> clientes) {
		this.clientes = clientes;
		this.fireTableDataChanged();
	}

}
