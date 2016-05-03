package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.Contrato;
import es.uam.eps.padsof.gesture.ContratoEstandar;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ContratoView extends View{

	private static final long serialVersionUID = -4986480833904432258L;
	
	public ContratoView(Contrato contrato) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String tipo;
		
		if (contrato instanceof ContratoEstandar){
			tipo = "Contrato Estandar";
		} else {
			tipo = "Contrato Preferente";
		}
		
		JLabel clienteLbl = new JLabel("Cliente: " + contrato.getCliente());
		JLabel tipoLbl = new JLabel("Tipo: " + tipo);
		JLabel validoHastaLbl = new JLabel("Válido hasta: " + sdf.format(contrato.getValidoHasta()));
		
		this.add(clienteLbl);
		this.add(tipoLbl);
		this.add(validoHastaLbl);
		
		this.setPreferredSize(new Dimension(400, 16*this.getComponentCount()));
	}

}
