package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import es.uam.eps.padsof.emailconnection.FailedInternetConnectionException;
import es.uam.eps.padsof.gesture.ObraDeArte;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.exception.AutorizacionIncorrectaException;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.gui.view.SubastaView;
import es.uam.eps.padsof.gesture.subasta.Subasta;
import es.uam.eps.padsof.gesture.subasta.Subastable;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class SubastaController extends Controller {
	private final Tienda tienda;
	private final Subastable sub;
	
	public SubastaController (Tienda tienda, Subastable sub) {
		super(new SubastaView(tienda));
		this.tienda = tienda;
		this.sub = sub;
	}
	
	public void actionPerformed(ActionEvent e){
		SubastaView view = (SubastaView)this.view;
		double precio = view.getPrecioSalida();
		int duracion = view.getDuracionSubasta();
		
		try {
			tienda.añadirSubasta(new Subasta(sub, new Date(), precio));
		} catch (FailedInternetConnectionException | AutorizacionIncorrectaException | NoAñadidoATiendaException
				| NoEstaEnInventarioException e1) {
			e1.printStackTrace();
			return;
		}
	}

}
