package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.ParticipacionDuplicadaException;
import es.uam.eps.padsof.gesture.exception.ParticipacionSinContratoException;
import es.uam.eps.padsof.gesture.exception.PujaRechazadaException;
import es.uam.eps.padsof.gesture.gui.view.ParticiparView;
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
public class ParticiparController extends Controller {
	private final Subasta subasta;

	public ParticiparController(Tienda tienda, Subasta subasta) {
		super(new ParticiparView(tienda, subasta));
		this.subasta = subasta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ParticiparView view = (ParticiparView)this.view;
		Cliente c = view.getCliente();
		
		if (c != null) {
			try {
				subasta.añadirParticipante(c);
			} catch (ParticipacionDuplicadaException e1) {
				JOptionPane.showMessageDialog(frame, "Ya está participando", "Participacion rechazada", JOptionPane.ERROR_MESSAGE);
			} catch (ParticipacionSinContratoException e1) {
				JOptionPane.showMessageDialog(frame, "Se necesita un contrato", "Participacion rechazada", JOptionPane.ERROR_MESSAGE);
				return;
			} catch (NoAñadidoATiendaException e1) {
				e1.printStackTrace();
				return;
			}
			
			frame.dispose();
		}
	}
}
