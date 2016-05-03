package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.TipoDeArticulo;
import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.model.ObrasTableModel;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ObrasView extends View {
	private static final long serialVersionUID = -4485907546327074040L;
	
	private final JTable obrasTbl;
	
	public static final String SUBASTA_OBRA_COMMAND = "subasta obra";

	private final JButton subBtn;

	public ObrasView(Tienda tienda) {
		this.setLayout(new BorderLayout());
		
		List<ObraDeArte> obras = tienda.getInventario().filtrarPorTipo(TipoDeArticulo.ObraDeArte)
				.stream().map(art -> (ObraDeArte)art).collect(Collectors.toList());
		this.add(new JScrollPane(obrasTbl = new JTable(new ObrasTableModel(obras))), BorderLayout.CENTER);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		btnPnl.add(subBtn = new JButton("Subastar"));
		subBtn.setActionCommand(SUBASTA_OBRA_COMMAND);
	}
	
	public void setControlador(final Controller c) {
		obrasTbl.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int row = e.getFirstRow();
		        int column = e.getColumn();
		        ObrasTableModel model = (ObrasTableModel)e.getSource();
		        Object data = model.getValueAt(row, column);
				
		        
			}
		});
		
		subBtn.addActionListener(c);
	}

	public ObraDeArte getSelectedObra() {
		return ((ObrasTableModel)obrasTbl.getModel()).getObra(obrasTbl.getSelectedRow());
	}
}
