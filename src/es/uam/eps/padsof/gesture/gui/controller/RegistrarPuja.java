package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.exception.PujaRechazadaException;
import es.uam.eps.padsof.gesture.gui.view.RegistrarPujaView;
import es.uam.eps.padsof.gesture.gui.view.View;
import es.uam.eps.padsof.gesture.subasta.Puja;
import es.uam.eps.padsof.gesture.subasta.Subasta;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class RegistrarPuja extends Controller {
	private final Tienda tienda;
	private final Subasta subasta;

	public RegistrarPuja(Tienda tienda, Subasta subasta) {
		super(new RegistrarPujaView(tienda, subasta));
		this.tienda = tienda;
		this.subasta = subasta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		RegistrarPujaView view = (RegistrarPujaView)this.view;
		Cliente c = view.getCliente();
		Double valor = view.getValor();
		
		if (c != null && valor != null) {
			try {
				subasta.pujar(new Puja(c, valor));
			} catch (PujaRechazadaException e1) {
				JOptionPane.showMessageDialog(frame, e1.getMotivo(), "Puja rechazada", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
	}
}
