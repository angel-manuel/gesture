package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.Usuario;
import es.uam.eps.padsof.gesture.gui.controller.Controller;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class UsuariosView extends View {
	private static final long serialVersionUID = 8105097725441386100L;
	
	private final Tienda tienda;
	
	private final JList<Usuario> usuLst;
	
	public static final String ADD_USER_COMMAND = "add user";
	
	private final JButton addUsuBtn;

	public UsuariosView(Tienda tienda) {
		this.tienda = tienda;
		
		this.setLayout(new BorderLayout());
		
		this.add(new JScrollPane(usuLst = new JList<>()), BorderLayout.CENTER);
		this.refresh();
		
		JPanel btnPnl = new JPanel();
		btnPnl.add(addUsuBtn = new JButton("Añadir usuario"));
		addUsuBtn.setActionCommand(ADD_USER_COMMAND);
		
		this.add(btnPnl, BorderLayout.EAST);
	}
	
	public void refresh() {
		DefaultListModel<Usuario> lm = new DefaultListModel<>();
		
		for (Usuario u: tienda.getUsuarios()) {
			lm.addElement(u);
		}
		
		usuLst.setModel(lm);
	}
	
	public void setControlador(final Controller c) {
		addUsuBtn.addActionListener(c);
	}
}
