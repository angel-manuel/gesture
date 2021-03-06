package es.uam.eps.padsof.gesture.gui.view;

import java.util.stream.Collectors;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.model.ClienteTableModel;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarPujaView extends View {
	private static final long serialVersionUID = -5462590280151481605L;
	
	private final JTable cliTbl;
	private final JTextField valFld;
	private final JButton pujBtn;
	
	public RegistrarPujaView(Tienda tienda, Subasta subasta) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(new JScrollPane(cliTbl = new JTable(new ClienteTableModel(
				tienda.getClientes().stream().filter(cliente -> subasta.estaParticipando(cliente))
				.collect(Collectors.toCollection(ArrayList::new))
		))));
		this.add(valFld = new JTextField());
		this.add(pujBtn = new JButton("Pujar!"));
	}

	public Cliente getCliente() {
		return ((ClienteTableModel)cliTbl.getModel()).getClient(cliTbl.getSelectedRow());
	}

	public Double getValor() {
		String str = valFld.getText();
	
		if (str == "") {
			return null;
		} else {
			return new Double(Double.parseDouble(str));
		}
	}
	
	public void setControlador(final Controller c) {
		pujBtn.addActionListener(c);
	}
}
