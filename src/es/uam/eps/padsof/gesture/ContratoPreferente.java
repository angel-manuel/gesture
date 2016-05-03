package es.uam.eps.padsof.gesture;

import es.uam.eps.padsof.gesture.balance.ConceptoPrecio;
import es.uam.eps.padsof.gesture.balance.Precio;
import es.uam.eps.padsof.gesture.balance.Venta;
import es.uam.eps.padsof.gesture.balance.VentaContrato;

/**
 * Representa un contrato preferente.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ContratoPreferente extends Contrato {
	private static final long serialVersionUID = 20160329L;
	public static final double PRECIO = 100.0;
	
	@Override
	public VentaContrato generarVenta() {
		Precio precio = new Precio();
		precio.añadirConcepto(new ConceptoPrecio("Precio contrato preferente", PRECIO));
	
		return new VentaContrato(cliente, this, precio);
	}

	@Override
	public Precio calcularPrecioParticipacion(double costeDeParticipacion) {
		Precio precio = new Precio();
		
		precio.añadirConcepto(new ConceptoPrecio("Participación en subasta", costeDeParticipacion));
		precio.añadirConcepto(new ConceptoPrecio("Descuento sobre participación", -costeDeParticipacion));
		
		return precio;
	}

	@Override
	public Venta procesarVenta(Venta venta) {
		Precio precio = venta.getPrecio();
		precio.añadirConcepto(
				new ConceptoPrecio("Descuento sobre precio",
						-venta.getObjetoVendido().calcularDescuento()));
		
		return venta;
	}
}
