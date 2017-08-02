package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class UtilesJdbc {

	static Connection con = null;

	public static Connection conectar(String driver, String url, String usr,
			String pwd) throws ConnectionException {
		try {
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url, usr, pwd);
		} catch (SQLException e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Fallo en SQL", e);
		} catch (Exception e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Se ha producido un error con el driver", e);
		}
		return con;

	}

	public static Connection conectar(String ficheroConfiguracion)
			throws ConnectionException {
		try {
			Properties propiedades = new Properties();
			propiedades.load(new FileInputStream(
					ficheroConfiguracion));

			DataSource ds = BasicDataSourceFactory
					.createDataSource(propiedades);
			con = ds.getConnection();

		} catch (FileNotFoundException e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Fichero no encontrado", e);
		} catch (IOException e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Fallo en la carga del archivo", e);
		} catch (Exception e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Se ha producido un error con la clase DataSource", e);
		}

		return con;

	}

	public static void cerrar(Connection con) {

		try {
			if (con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Fallo al cerrar la conexión", e);
		}

	}

	public static void cerrar(Statement stm) {
		try {
			if((stm!=null) && !stm.isClosed())
			stm.close();
		} catch (SQLException e){
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Fallo al cerrar el statement", e);
		}
		
	}

	public static void cerrar(ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			Logger.getLogger(UtilesJdbc.class.getName()) 
			.log(Level.SEVERE, "Fallo al cerrar el resulSet", e);
		}
	}
}
