package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.model.ClienteTableModel;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ClientesView extends View {

	private static final long serialVersionUID = 5391579914332563550L;
	
	private final Tienda tienda;
	
	public static final String ADD_CLIENT_COMMAND = "add client";
	public static final String CLIENT_DETAILS_COMMAND = "client details";
	public static final String CLIENT_CONTRACT_COMMAND = "client contract";
	
	private final JTable cliTbl;

	private final JButton addCliBtn;
	private final JButton cliDetBtn;
	private final JButton contractBtn;

	public ClientesView(Tienda tienda) {
		this.tienda = tienda;
		
		this.setLayout(new BorderLayout());
		
		JLabel clientesLbl = new JLabel("Clientes:"); 
		this.add(clientesLbl, BorderLayout.NORTH);
		this.add(new JScrollPane(cliTbl = new JTable(new ClienteTableModel(tienda.getClientes()))), BorderLayout.CENTER);
	
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		btnPnl.add(addCliBtn = new JButton("Añadir cliente"));
		addCliBtn.setActionCommand(ADD_CLIENT_COMMAND);
		btnPnl.add(cliDetBtn = new JButton("Mostrar detalles"));
		cliDetBtn.setActionCommand(CLIENT_DETAILS_COMMAND);
		btnPnl.add(contractBtn = new JButton("Otorgar contrato"));
		contractBtn.setActionCommand(CLIENT_CONTRACT_COMMAND);
		
		this.add(btnPnl, BorderLayout.EAST);
	}
	
	@Override
	public void setControlador(final Controller c) {
		addCliBtn.addActionListener(c);
		cliDetBtn.addActionListener(c);
		contractBtn.addActionListener(c);
	}

	public Cliente getSelectedCliente() {
		return ((ClienteTableModel)cliTbl.getModel()).getClient(cliTbl.getSelectedRow());
	}

	public void refresh() {
		((ClienteTableModel)cliTbl.getModel()).setClients(tienda.getClientes());
	};
}
