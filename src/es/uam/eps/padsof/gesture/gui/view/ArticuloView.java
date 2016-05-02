package es.uam.eps.padsof.gesture.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

import es.uam.eps.padsof.gesture.Articulo;

/**
 * TODO: Descripcion del tipo
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 *
 */
public class ArticuloView extends View {

	private static final long serialVersionUID = 3173924798777072595L;
	
	public ArticuloView(Articulo articulo) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		JLabel articuloLbl = new JLabel("Tipo: " + articulo.getTipo().toString());
		JLabel descripcionLbl = new JLabel("Descripcion: " + articulo.getDescripcion());
		JLabel precioBaseLbl = new JLabel("Precio base: " + Double.toString(articulo.getPrecioBase()));
		JLabel añoLbl = new JLabel("Año: " + articulo.getAño());
		JLabel fechaAdquisicionLbl = new JLabel("Fecha de adquisicion:" + sdf.format(articulo.getFechaAdquisicion()));
		JLabel costeAdquisicionLbl = new JLabel("Coste de adquisicion: " + Double.toString(articulo.getCosteAdquisicion()));
		this.add(articuloLbl);
		this.add(descripcionLbl);
		this.add(precioBaseLbl);
		this.add(añoLbl);
		this.add(fechaAdquisicionLbl);
		this.add(costeAdquisicionLbl);
		
		this.setPreferredSize(new Dimension(400, 16*this.getComponentCount()));
	}
}
