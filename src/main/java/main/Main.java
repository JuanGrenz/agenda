package main;

import java.io.IOException;
import java.sql.SQLException;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();
		try {
			controlador.inicializar();
		} catch (ClassNotFoundException | SQLException | IOException | InvalidPropertiesException e) {
			controlador.inicializarConfig();
		}
	}
}
 