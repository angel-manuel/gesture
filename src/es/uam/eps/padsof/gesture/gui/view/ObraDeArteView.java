package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Dimension;

import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.ObraDeArte;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ObraDeArteView extends ArticuloView{

	private static final long serialVersionUID = -1570096861385887675L;

	public ObraDeArteView(ObraDeArte oda){
		super(oda);
		
		JLabel autorLbl = new JLabel("Autor: " + oda.getAutor());
		JLabel tipoObraLbl = new JLabel("Tipo de Obra: " + oda.getTipoObra());
		JLabel certificadoLbl = new JLabel("Certificado: " + (oda.getCertificado() ? " con certificado de autenticidad" : ""));
		this.add(autorLbl);
		this.add(tipoObraLbl);
		this.add(certificadoLbl);
		
		this.setPreferredSize(new Dimension(400, 16*this.getComponentCount()));
	}
}
