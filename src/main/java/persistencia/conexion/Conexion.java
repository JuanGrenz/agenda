package persistencia.conexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


import org.apache.log4j.Logger;

import excepciones.InvalidPropertiesException;


public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	private static Properties properties = new Properties();
	private static boolean configurar;
	
	private Conexion()
	{
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
//			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","pass");
//			log.info("Conexión exitosa");
//		}
//		catch(Exception e)
//		{
//			log.error("Conexión fallida", e);
//		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() throws FileNotFoundException, IOException, ClassNotFoundException, 
	SQLException, InvalidPropertiesException 
	{
		if (this.connection != null) {
			if (this.connection.isClosed()) {
				connect();
			}
		} else {
			connect();
		}
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}

	private void connect() throws FileNotFoundException, IOException, ClassNotFoundException, InvalidPropertiesException {
		  String cwd = System.getProperty("user.dir");
	        System.out.println("Current working directory : " + cwd);
		System.out.println(" propertiesPath: " + cwd + "/db.properties");
		// FileInputStream fileInput = new FileInputStream(file);
		File file = new File(cwd + "/db.properties");
		FileInputStream fileInput = new FileInputStream(file);
		properties.load(fileInput);
		// propertiesPath.close();
		Class.forName("com.mysql.jdbc.Driver"); // quitar si no es necesario
		fileInput.close();
		String ip = properties.getProperty("ip");
		String port = properties.getProperty("port");
		String user = properties.getProperty("user");
		
		String password = properties.getProperty("password");
		configurar = Boolean.parseBoolean((String) properties.get("bienvenida"));
		
		try {
			this.connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/agenda", user, password);
		} catch (SQLException e) {
			throw new InvalidPropertiesException("No se pudo establecer una conexion. Ingrese otra configuracion.");
		}
		log.info("Conexión exitosa");
	}
	
	public static boolean darBienvenida() {
		return configurar;
	}
}
