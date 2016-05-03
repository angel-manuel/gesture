package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.model.ClienteTableModel;
import es.uam.eps.padsof.gesture.gui.model.SubastasTableModel;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ParticiparView extends View {
	
	private static final long serialVersionUID = 3939298084927693961L;
	private final JTable cliTbl;
	private final JButton parBtn;

	public ParticiparView(Tienda tienda, Subasta subasta) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.add(new JScrollPane(cliTbl = new JTable(new ClienteTableModel(
				tienda.getClientes().stream().filter(cliente -> !subasta.estaParticipando(cliente))
				.collect(Collectors.toCollection(ArrayList::new))
		))));
		this.add(parBtn = new JButton("Participar"));
	}

	public Cliente getCliente() {
		return ((ClienteTableModel)cliTbl.getModel()).getClient(cliTbl.getSelectedRow());
	}
	
	public void setControlador(final Controller c) {
		parBtn.addActionListener(c);
	}
}
