package es.uam.eps.padsof.gesture.gui.controller;

import java.awt.event.ActionEvent;

import es.uam.eps.padsof.gesture.Cliente;
import es.uam.eps.padsof.gesture.Tienda;
import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.gui.view.OtorgarContratoView;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class OtorgarContratoController extends Controller {
	private final Cliente cliente;
	
	public OtorgarContratoController(Cliente cliente){
		super(new OtorgarContratoView(cliente));
		this.cliente = cliente;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		OtorgarContratoView view = (OtorgarContratoView)this.view;
		
		try {
			cliente.otorgarContrato(view.getContrato());
		} catch (NoAñadidoATiendaException e1) {
			e1.printStackTrace();
		}
		
		frame.dispose();
	}
}
