package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;

import javax.swing.JLabel;

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
	/**
	 * Constructor de MenudenciaView
	 *
	 * @param articulo
	 */
	public MenudenciaView(Menudencia menudencia) {
		super(menudencia);

		JLabel descuentoLbl = new JLabel("Descuento :" + Double.toString(menudencia.getPorcentajeDescuento()) + "%");
		this.add(descuentoLbl);
		
		this.setPreferredSize(new Dimension(400, 16*this.getComponentCount()));
	}
}
