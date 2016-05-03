package es.uam.eps.padsof.gesture;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Lector de artículos de fichero.
 *
 * @author Borja González Farías
 * @author Ángel Manuel Martín
 */
public class ArticulosReader {
	private final File file;

	/**
	 * Constructor de ArticulosReader.
	 *
	 * @param filename Nombre del archivo a leer
	 */
	public ArticulosReader(String filename) {
		this.file = new File(filename);
	}
	
	/**
	 * Constructor de ArticulosReader
	 *
	 * @param file
	 */
	public ArticulosReader(File file) {
		this.file = file;
	}

	/**
	 * Lee el fichero de articulos.
	 *
	 * @return col Coleccion de articulos
	 */
	public ColeccionArticulos leerTodo() throws IOException, ParseException {
		ColeccionArticulosMutable col = new ColeccionArticulosMutable();
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		while (true) {
			String line = in.readLine();
			
			if (line == null) {
				break;
			}
			
			if (line.isEmpty()) {
				continue;
			}
			
			String[] tokens = line.split(";");
			
			switch (tokens[0]) {
			case "M":
				col.añadirArticulo(tokensAMenudencia(tokens));
				break;
			case "V":
				col.añadirArticulo(tokensAVoluminoso(tokens));
				break;
			case "A":
				col.añadirArticulo(tokensAObraDeArte(tokens));
				break;
			default:
				continue;
			}
		}
		
		in.close();
		 
		return col;
	}

	private Menudencia tokensAMenudencia(String[] tokens) throws ParseException {
		String descripcion = tokens[1];
		String año = tokens[2];
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date fechaAdquisicion = formatter.parse(tokens[3]);
		double costeAdquisicion = Double.parseDouble(tokens[4]);
		double precioBase = Double.parseDouble(tokens[5]);
		int porcentajeDescuento = Integer.parseInt(tokens[6]);
		
		return new Menudencia(descripcion, precioBase, año, fechaAdquisicion, costeAdquisicion,
				porcentajeDescuento);
	}
	
	private ArticuloVoluminoso tokensAVoluminoso(String[] tokens) throws ParseException {
		String descripcion = tokens[1];
		String año = tokens[2];
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date fechaAdquisicion = formatter.parse(tokens[3]);
		double costeAdquisicion = Double.parseDouble(tokens[4]);
		double precioBase = Double.parseDouble(tokens[5]);
		double peso = Double.parseDouble(tokens[6]);
		double alto = Double.parseDouble(tokens[7]);
		double ancho = Double.parseDouble(tokens[8]);
		double largo = Double.parseDouble(tokens[9]);
		
		return new ArticuloVoluminoso(descripcion, precioBase, año, fechaAdquisicion, costeAdquisicion,
				peso, alto, ancho, largo);
	}
	
	private ObraDeArte tokensAObraDeArte(String[] tokens) throws ParseException {
		String descripcion = tokens[1];
		String año = tokens[2];
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		Date fechaAdquisicion = formatter.parse(tokens[3]);
		double costeAdquisicion = Double.parseDouble(tokens[4]);
		double precioBase = Double.parseDouble(tokens[5]);
		String autor = tokens[6];
		TipoDeObra tipo = TipoDeObra.valueOf(tokens[7]);
		boolean certificado = tokens[8].contentEquals("S");
		
		return new ObraDeArte(descripcion, precioBase, año, fechaAdquisicion, costeAdquisicion,
				autor, tipo, certificado);
	}
}
