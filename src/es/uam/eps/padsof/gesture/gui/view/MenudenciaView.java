package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.Articulo;
import es.uam.eps.padsof.gesture.Menudencia;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class MenudenciaView extends ArticuloView{
	private static final long serialVersionUID = 1918961567458535540L;
	private final Menudencia menudencia;
	/**
	 * Constructor de MenudenciaView
	 *
	 * @param articulo
	 */
	public MenudenciaView(Menudencia menudencia) {
		super(menudencia);
		this.menudencia = menudencia;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel descuentoLbl = new JLabel("Descuento " + Double.toString(menudencia.getPorcentajeDescuento()) + "%");
		this.add(descuentoLbl);
		
		this.setSize(new Dimension(200, 24*this.getComponentCount()));
	}
}
