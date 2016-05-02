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
	private final Articulo articulo;
	
	public ArticuloView(Articulo articulo) {
		this.articulo = articulo;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		String precioBase;
		String fechaAdquisicion;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String costeAdquisicion;

		JLabel articuloLbl = new JLabel(articulo.getTipo().toString() + ":");
		JLabel descripcionLbl = new JLabel(articulo.getDescripcion());
		JLabel precioBaseLbl = new JLabel (precioBase = Double.toString(articulo.getPrecioBase()));
		JLabel añoLbl = new JLabel (articulo.getAño());
		JLabel fechaAdquisicionLbl = new JLabel (fechaAdquisicion = sdf.format(articulo.getFechaAdquisicion()));
		JLabel costeAdquisicionLbl = new JLabel (costeAdquisicion = Double.toString(articulo.getCosteAdquisicion()));
		this.add(articuloLbl);
		this.add(descripcionLbl);
		this.add(precioBaseLbl);
		this.add(añoLbl);
		this.add(fechaAdquisicionLbl);
		this.add(costeAdquisicionLbl);
		
		this.setSize(new Dimension(200, 24*this.getComponentCount()));
	}
}
