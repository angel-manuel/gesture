package es.uam.eps.padsof.gesture.gui.view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.controller.Controller;
import es.uam.eps.padsof.gesture.gui.model.SubastasTableModel;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastasView extends View {

	private static final long serialVersionUID = 7568905310637807284L;
	
	private final Tienda tienda;
	
	public static final String SUBSCRIBE_COMMAND = "subscribe";
	public static final String PUJAR_COMMAND = "pujar";
	
	private final JTable subTbl;
	
	private final JButton subBtn;
	private final JButton pujBtn;

	public SubastasView(Tienda tienda) {
		this.tienda = tienda;
		
		this.setLayout(new BorderLayout());
		
		subTbl = new JTable(new SubastasTableModel(tienda.getSubastas()));
		
		this.add(subTbl, BorderLayout.CENTER);
		
		JPanel btnPnl = new JPanel();
		btnPnl.setLayout(new BoxLayout(btnPnl, BoxLayout.Y_AXIS));
		
		btnPnl.add(subBtn = new JButton("Subscribir"));
		subBtn.setActionCommand(SUBSCRIBE_COMMAND);
		btnPnl.add(pujBtn = new JButton("Pujar"));
		pujBtn.setActionCommand(PUJAR_COMMAND);
		
		this.add(btnPnl, BorderLayout.EAST);
	}
	
	public void setControlador(final Controller c) {
		subBtn.addActionListener(c);
		pujBtn.addActionListener(c);
	}

	/**
	 * @return
	 */
	public Subasta getSelectedSubasta() {
		int selRow = subTbl.getSelectedRow();
		
		if (selRow >= 0) {
			return tienda.getSubastas().get(selRow);
		}
		
		return null;
	}
}
