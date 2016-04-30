package es.uam.eps.padsof.gesture.balance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import es.uam.eps.padsof.gesture.subasta.ParticipacionSubasta;
import es.uam.eps.padsof.gesture.subasta.ResultadoSubasta;

/**
 * Representa el balance de ventas.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class Balance implements Serializable {
	private static final long serialVersionUID = 20160329L;
	private ArrayList<Venta> ventas = new ArrayList<>();
	private ArrayList<ResultadoSubasta> resultadosSubastas = new ArrayList<>();
	private ArrayList<ParticipacionSubasta> participaciones = new ArrayList<>();
	private ArrayList<VentaContrato> ventasContratos = new ArrayList<>();
	
	/**
	 * Suma los conceptos de ventas.
	 *
	 * @param concepto Concepto de la venta
	 * @return sum Suma de los conceptos de las ventas
	 */
	public double sumaConceptosVentas(String concepto) {
		double sum = 0.0;
		
		for (Venta venta: ventas) {
			sum += venta.getPrecio().sumaConceptos(concepto);
		}
		
		return sum;
	}
	
	/**
	 * Calcula los beneficios brutos de las ventas.
	 *
	 * @return sum Beneficios finales
	 */
	public double calcularBeneficiosBrutosVenta() {
		double sum = sumaConceptosVentas("Precio base");
		
		for (Venta venta: ventas) {
			sum -= venta.getObjetoVendido().getCosteAdquisicion();
		}
		
		return sum;
	}
	
	/**
	 * Calcula los descuentos de las ventas.
	 *
	 * @return la suma de los conceptos de las ventas teniendo como concepto el
	 * descuento
	 */
	public double calcularDescuentosVenta() {
		return sumaConceptosVentas("Descuento");
	}
	
	/**
	 * Calcula los beneficios de las ventas.
	 *
	 * @return beneficios brutos mas los descuentos de las ventas
	 */
	public double calcularBeneficiosVenta() {
		return calcularBeneficiosBrutosVenta() + calcularDescuentosVenta();
	}
	
	/**
	 * Calcula los beneficios de las subastas.
	 *
	 * @return sum Suma de los costes finales de los productos subastados
	 */
	public double calcularBeneficiosSubastas() {
		double sum = 0.0;
		
		for (ResultadoSubasta resultado: resultadosSubastas) {
			sum += resultado.getPrecioFinal() - resultado.getObjetoSubasta().getCosteAdquisicion();
		}
		
		return sum;
	}
	
	/**
	 * Suma los conceptos de las participaciones.
	 *
	 * @param concepto Concepto de la participacion
	 * @return sun Suma de los precios de conceptos de participaciones
	 */
	public double sumaConceptosParticipaciones(String concepto) {
		double sum = 0.0;
		
		for (ParticipacionSubasta participacion: participaciones) {
			sum += participacion.getPrecio().sumaConceptos(concepto);
		}
		
		return sum;
	}
	
	/**
	 * Calcula los beneficios brutos de las participaciones en las subastas.
	 *
	 * @return la suma de los conceptos de participaciones teniendo como
	 * concepto la participacion en la subasta
	 */
	public double calcularBeneficiosBrutosParticipacionesSubastas() {
		return sumaConceptosParticipaciones("Participación");
	}
	
	/**
	 * Calcula los descuentos de las participaciones en subastas.
	 *
	 * @return suma de los conceptos de participaciones teniendo como concepto
	 * el descuento
	 */
	public double calcularDescuentosParticipacionesSubastas() {
		return sumaConceptosParticipaciones("Descuento");
	}
	
	/**
	 * Calcula los beneficios en las participaciones en subastas.
	 *
	 * @return suma de los beneficios brutos en las participaciones en subastas
	 * mas los descuentos de las participaciones en subastas
	 */
	public double calcularBeneficiosParticipacionesSubastas() {
		return calcularBeneficiosBrutosParticipacionesSubastas() + calcularDescuentosParticipacionesSubastas();
	}
	
	/**
	 * Suma los conceptos de venta de los contratos.
	 *
	 * @param concepto
	 * @return suma de los conceptos de los contratos
	 */
	public double sumaConceptosVentaContratos(String concepto) {
		double sum = 0.0;
		
		for (VentaContrato vc: ventasContratos) {
			sum += vc.getPrecio().sumaConceptos(concepto);
		}
		
		return sum;
	}
	
	/**
	 * Calcula los beneficios de venta de contratos estandar.
	 *
	 * @return suma de los conceptos de venta de contratos teniendo "estandar"
	 * como concepto
	 */
	public double calcularBeneficiosVentaContratosEstandar() {
		return sumaConceptosVentaContratos("estandar");
	}
	
	/**
	 * Calcula los beneficios de venta de contratos preferentes.
	 *
	 * @return suma de los conceptos de venta de contratos teniendo "preferente"
	 * como concepto
	 */
	public double calcularBeneficiosVentaContratosPreferente() {
		return sumaConceptosVentaContratos("preferente");
	}
	
	/**
	 * Calcula los beneficios de venta de contratos.
	 *
	 * @return beneficios de la venta de contratos estandar mas los 
	 * beneficios de la venta de contratos preferentes
	 */
	public double calcularBeneficiosVentaContratos() {
		return calcularBeneficiosVentaContratosEstandar() + calcularBeneficiosVentaContratosPreferente();
	}
	
	/**
	 * Calcula los descuentos totales.
	 *
	 * @return descuentos de venta mas los descuentos de participaciones
	 * en subastas
	 */
	public double calcularDescuentosTotales() {
		return calcularDescuentosVenta()
				+ calcularDescuentosParticipacionesSubastas();
	}
	
	/**
	 * Calcula los beneficios brutos totales.
	 *
	 * @return la suma de todos los beneficios brutos
	 */
	public double calcularBeneficiosBrutosTotales() {
		return calcularBeneficiosBrutosVenta()
				+ calcularBeneficiosSubastas()
				+ calcularBeneficiosBrutosParticipacionesSubastas()
				+ calcularBeneficiosVentaContratos();
	}
	
	/**
	 * Calcula los beneficios totales.
	 *
	 * @return la suma de todos los beneficios
	 */
	public double calcularBeneficiosTotales() {
		return calcularBeneficiosVenta()
				+ calcularBeneficiosSubastas()
				+ calcularBeneficiosParticipacionesSubastas()
				+ calcularBeneficiosVentaContratos();
	}
	
	/**
	 * Da un representación en texto del balance
	 *
	 * @return Representación en texto
	 */
	@Override
	public String toString() {
		return "Beneficios Brutos Ventas: " + calcularBeneficiosBrutosVenta() + "\n" +
				"Descuentos Ventas: " + calcularDescuentosVenta() + "\n" +
				"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" +
				"Beneficios Ventas: " + calcularBeneficiosVenta() + "\n" +
				"---------------------------------------------------\n" +
				"Beneficios Subastas: " + calcularBeneficiosSubastas() + "\n" +
				"---------------------------------------------------\n" +
				"Beneficios Brutos Participaciones: " + calcularBeneficiosBrutosParticipacionesSubastas() + "\n" +
				"Descuentos Participaciones: " + calcularDescuentosParticipacionesSubastas() + "\n" +
				"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" +
				"Beneficios Participaciones: " + calcularBeneficiosParticipacionesSubastas() + "\n" +
				"---------------------------------------------------\n" +
				"Beneficios Venta Contratos Estandar: " + calcularBeneficiosVentaContratosEstandar() + "\n" +
				"Beneficios Venta Contratos Preferente: " + calcularBeneficiosVentaContratosPreferente() + "\n" +
				"vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n" +
				"Beneficios Venta Contratos: " + calcularBeneficiosVentaContratos() + "\n" +
				"---------------------------------------------------\n" +
				"+++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
				"---------------------------------------------------\n" +
				"Total: " + calcularBeneficiosTotales() + "\n";
	}
	
	/**
	 * Registra la participacion.
	 *
	 * @param participacion Participacion a registrar
	 */
	public void registrarParticipacion(ParticipacionSubasta participacion) {
		participaciones.add(participacion);
	}
	
	/**
	 * Registra el resultado de la subasta.
	 *
	 * @param resultado Resultado a registrar
	 */
	public void registrarResultadoSubasta(ResultadoSubasta resultado) {
		resultadosSubastas.add(resultado);
	}

	/**
	 * Registra la venta.
	 *
	 * @param venta Venta a registrar
	 */
	public void registrarVenta(Venta venta) {
		ventas.add(venta);
	}
	
	/**
	 * Registra una venta a un contrato.
	 *
	 * @param vc Venta de contrato a registrar
	 */
	public void registrarVentaContrato(VentaContrato vc) {
		ventasContratos.add(vc);
	}
	
	/**
	 * Devuelve las últimas ventas
	 * 
	 * @param desde Fecha a partir de la que se devuelven ventas
	 * @return las últimas ventas
	 */
	public List<Venta> obtenerUltimasVentas(Date desde) {
		ArrayList<Venta> ret = new ArrayList<>();
		
		for (Venta venta: ventas) {
			if (venta.getFecha().after(desde)) {
				ret.add(venta);
			}
		}
		
		return ret;
	}
	
	/**
	 * Devuelve las últimas ventas de contrato
	 * 
	 * @param desde Fecha a partir de la que se devuelven ventas de contrato
	 * @return las últimas ventas de contrato
	 */
	public List<VentaContrato> obtenerUltimasVentasContrato(Date desde) {
		ArrayList<VentaContrato> ret = new ArrayList<>();
		
		for (VentaContrato vc: ventasContratos) {
			if (vc.getFecha().after(desde)) {
				ret.add(vc);
			}
		}
		
		return ret;
	}
	
	/**
	 * Devuelve las últimos resultados subasta
	 * 
	 * @param desde Fecha a partir de la que se devuelven resultados
	 * @return las últimos resultados subasta
	 */
	public List<ResultadoSubasta> obtenerUltimosResultadosSubasta(Date desde) {
		ArrayList<ResultadoSubasta> ret = new ArrayList<>();
		
		for (ResultadoSubasta resultado: resultadosSubastas) {
			if (resultado.getFecha().after(desde)) {
				ret.add(resultado);
			}
		}
		
		return ret;
	}
}
