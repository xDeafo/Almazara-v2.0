package fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilesFecha {
	/**
	 * Formato de fecha por defecto, de la forma 30-12-2013.
	 */
	private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Devuelve la fecha como un String con el formato por defecto
	 * 
	 * @param fecha
	 *            fecha que se devuelve como String
	 * @return String formateado
	 */
	public static String format(java.util.Date fecha) {
		if (fecha == null) {
			return null;
		}
		return DEFAULT_DATE_FORMAT.format(fecha.getTime());
	}

	/**
	 * Devuelve la fecha como un String con el formato indicado
	 * 
	 * @param fecha
	 *            fecha que se devuelve como String
	 * @param formato
	 *            formato de fecha a aplicar
	 * @return String formateado
	 */
	public static String format(Date fecha, String formato) {
		if (fecha == null) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(formato);
		return df.format(fecha.getTime());
	}

	/**
	 * Convierte un string con el formato de fecha por defecto en java.util.Date
	 * 
	 * Devuelve null si no se puede convertir.
	 * 
	 * @param date
	 *            Cadena a convertir
	 * @return el String convertido a fecha
	 */
	public static java.util.Date parse(String dateString) {
		try {
			return DEFAULT_DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Convierte un string con el formato de fecha indicado en un java.util.Date
	 * 
	 * Devuelve null si no se puede convertir.
	 * 
	 * @param date
	 *            Cadena a convertir
	 * @return el String convertido a fecha
	 */
	public static java.util.Date parse(String dateString, String formato) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(formato);
			return df.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Devuelve la fecha actual
	 * 
	 * @return la fecha actual
	 */
	public static java.util.Date getFechaActual() {
		return new Date();
	}

	/**
	 * Devuelve un objeto sql.Date a partir de un util.Date
	 * 
	 * @param d
	 *            el util.Date
	 * @return el sql.Date
	 */
	public static java.sql.Date toSqlDate(java.util.Date d) {
		if (d == null)
			return null;
		else
			return new java.sql.Date(d.getTime());
	}

}
