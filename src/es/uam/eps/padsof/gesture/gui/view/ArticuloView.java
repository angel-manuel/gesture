package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.balance.ConceptoPrecio;
import es.uam.eps.padsof.gesture.balance.Precio;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ArticuloView extends View {

	private static final long serialVersionUID = 3173924798777072595L;
	private final Articulo articulo;
	
	public ArticuloView(Articulo articulo) {
		this.articulo = articulo;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		this.render();
	}
	
	public void render() {
		this.removeAll();
		

		JLabel articuloLbl = new JLabel("Articulo: " + articulo.toString());
		articuloLbl.setForeground(new Color(0, 180, 0));
		this.add(articuloLbl);
		
		this.setSize(new Dimension(200, 24*this.getComponentCount()));
	}

}
