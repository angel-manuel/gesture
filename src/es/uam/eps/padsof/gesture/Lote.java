package es.uam.eps.padsof.gesture;

import es.uam.eps.padsof.gesture.exception.NoAñadidoATiendaException;
import es.uam.eps.padsof.gesture.exception.NoEstaEnInventarioException;
import es.uam.eps.padsof.gesture.subasta.Subastable;

/**
 * Representa un lote.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Lote extends ColeccionArticulosMutable implements Subastable {
	private static final long serialVersionUID = 20160327L;
	private boolean reservado = false;
	
	/**
	 * Reserva el lote.
	 */
	public void reservar() throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		retirarDeInventario();
		
		reservado = true;
	}
	
	/**
	 * Comprueba que el lote esta a la venta
	 *
	 * @return false, los lotes no se pueden vender, solo subastar
	 */
	@Override
	public boolean isALaVenta() {
		return false;
	}

	@Override
	public double getPrecioBase() {
		double sum = 0.0;
		
		for(Articulo articulo: articulos) {
			sum += articulo.getPrecioBase();
		}
		
		return sum;
	}
	
	@Override
	public double calcularDescuento() {
		double sum = 0.0;
		
		for(Articulo articulo: articulos) {
			sum += articulo.calcularDescuento();
		}
		
		return sum;
	}
	
	@Override
	public double getCosteAdquisicion() {
		double sum = 0.0;
		
		for(Articulo articulo: articulos) {
			sum += articulo.getCosteAdquisicion();
		}
		
		return sum;
	}

	@Override
	public double calcularGastosEnvio() {
		double sumGastosEnvio = 0.0;
		
		for(Articulo articulo: articulos) {
			sumGastosEnvio += articulo.calcularGastosEnvio();
		}
		
		return sumGastosEnvio;
	}
	
	@Override
	public boolean isDisponibleParaSubasta() {
		return true;
	}
	
	@Override
	public void retirarDeInventario() throws NoAñadidoATiendaException, NoEstaEnInventarioException {
		if (!reservado) { // Si esta reservado ya lo hemos retirado del inventario
			for(Articulo articulo: articulos) {
				articulo.retirarDeInventario();
			}
		}
	}
	
	@Override
	public void devolverAInventario() throws NoAñadidoATiendaException {
		for (Articulo articulo: articulos) {
			articulo.devolverAInventario();
		}
	}

	/* (non-Javadoc)
	 * @see es.uam.eps.padsof.gesture.subasta.Subastable#getDescripcion()
	 */
	@Override
	public String getDescripcion() {
		String desc = "Lote(" + articulos.size() + "): ";
		
		for (Articulo articulo: articulos) {
			desc += articulo.getDescripcion() + ", ";
		}
		
		return desc;
	}
}
