package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.gui.view.SubastaView;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastaController implements ActionListener {
	private final Tienda tienda;
	private final SubastaView view;
	private Date ultimoDia;
	
	public SubastaController (Tienda tienda, SubastaView view) {
		this.tienda = tienda;
		this.view = view;
		
		/*view.setControlador(this);*/
	}
	
	public void actionPerformed(ActionEvent e){
		/*Subasta subasta;
		
		
		try {
			subasta = new Subasta(
					
		}*/
	}

}
