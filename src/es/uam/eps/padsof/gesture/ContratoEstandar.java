package es.uam.eps.padsof.gesture;

import es.uam.eps.padsof.gesture.balance.ConceptoPrecio;
import es.uam.eps.padsof.gesture.balance.Precio;
import es.uam.eps.padsof.gesture.balance.Venta;
import es.uam.eps.padsof.gesture.balance.VentaContrato;

/**
 * Representa un contrato estandar.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ContratoEstandar extends Contrato {
	private static final long serialVersionUID = 20160329L;
	public static final double PRECIO = 25.0;
	private static final double UMBRAL_GASTO = 200.0;private static final int UMBRAL_PARTICIPACIONES = 6;
	private double gastoAcumulado = 0.0;
	private int participaciones = 0;

	@Override
	public VentaContrato generarVenta() {
		Precio precio = new Precio();
		precio.añadirConcepto(new ConceptoPrecio("Precio contrato estandar", PRECIO));
	
		return new VentaContrato(cliente, this, precio);
	}

	@Override
	public Precio calcularPrecioParticipacion(double costeDeParticipacion) {
		Precio precio = new Precio();
		
		precio.añadirConcepto(new ConceptoPrecio("Participación en subasta", costeDeParticipacion));
		
		if (++participaciones >= UMBRAL_PARTICIPACIONES) { //A partir de la sexta subasta
			precio.añadirConcepto(new ConceptoPrecio("Descuento sobre participación", -costeDeParticipacion));
		}
		
		return precio;
	}

	@Override
	public Venta procesarVenta(Venta venta) {
		Precio precio = venta.getPrecio();
		
		if(gastoAcumulado >= UMBRAL_GASTO) {
			precio.añadirConcepto(
					new ConceptoPrecio("Descuento sobre precio",
							-venta.getObjetoVendido().calcularDescuento()));
		}
		
		gastoAcumulado += precio.calcularTotal();
		
		return venta;
	}

}
