package persistencia.dao.interfaz;

import java.util.List;

import dto.CategoriaDTO;

public interface CategoriaDAO {

	public boolean insert(CategoriaDTO persona);

	public boolean delete(CategoriaDTO persona_a_eliminar);
	
	public List<CategoriaDTO> readAll();
}
