package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CategoriaDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.CategoriaDAO;

public class CategoriaDAOSQL implements CategoriaDAO{

	private static final String insert = "INSERT INTO categoria(idCategoria, nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM categoria WHERE idCategoria = ?";
	private static final String readall = "SELECT * FROM categoria";
	
	@Override
	public boolean insert(CategoriaDTO categoria) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, categoria.getIdCategoria());
			statement.setString(2, categoria.getNombre());
			if(statement.executeUpdate() > 0) //Si se ejecut� devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(CategoriaDTO categoria_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(categoria_a_eliminar.getIdCategoria()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CategoriaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<CategoriaDTO> categorias = new ArrayList<CategoriaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				categorias.add(new CategoriaDTO(resultSet.getInt("idLocalidad"),
						resultSet.getString("Nombre")
						));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return categorias;
	}

}
