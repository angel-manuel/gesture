package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;

import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.ArticuloVoluminoso;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ArticuloVoluminosoView extends ArticuloView{
	
	private static final long serialVersionUID = 3520400143271374338L;

	public ArticuloVoluminosoView(ArticuloVoluminoso artVol){
		super(artVol);
		
		JLabel pesoLbl = new JLabel("Peso: " + Double.toString(artVol.getPeso()) + "Kg");
		JLabel altoLbl = new JLabel("Alto: " + Double.toString(artVol.getAlto()) + " m");
		JLabel anchoLbl = new JLabel("Ancho: " + Double.toString(artVol.getAncho()) + " m");
		JLabel largoLbl = new JLabel("Largo: " + Double.toString(artVol.getLargo()) + " m");
		this.add(pesoLbl);
		this.add(altoLbl);
		this.add(anchoLbl);
		this.add(largoLbl);
		
		this.setPreferredSize(new Dimension(400, 16*this.getComponentCount()));
	}
}
