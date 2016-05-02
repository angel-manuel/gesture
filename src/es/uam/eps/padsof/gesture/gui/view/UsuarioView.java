package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import es.uam.eps.padsof.gesture.Tienda;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class UsuarioView extends View {
	private static final long serialVersionUID = -2011686703563102934L;
	private JPanel upperPanel;
	
	public UsuarioView(Tienda tienda) {
		setLayout(new BorderLayout());
		
		upperPanel = new JPanel();
		upperPanel.add(new JLabel(tienda.getUsuarioLogeado().getNombre()));
		
		this.add(upperPanel, BorderLayout.NORTH);
	}
}
