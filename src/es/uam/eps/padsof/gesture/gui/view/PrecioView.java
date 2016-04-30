package es.uam.eps.padsof.gesture.gui.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import es.uam.eps.padsof.gesture.balance.ConceptoPrecio;
import es.uam.eps.padsof.gesture.balance.Precio;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class PrecioView extends JPanel {
	private final Precio precio;
	
	public PrecioView(Precio precio) {
		this.precio = precio;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.render();
	}
	
	public void render() {
		this.removeAll();
		
		for (ConceptoPrecio concepto: precio) {
			this.add(new JLabel(concepto.toString()));
		}

		JLabel totalLbl = new JLabel("Total: " + precio.calcularTotal());
		totalLbl.setForeground(new Color(0, 180, 0));
		this.add(totalLbl);
		
		this.setSize(new Dimension(200, 24*this.getComponentCount()));
	}
}
