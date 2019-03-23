package persistencia.dao.interfaz;

import java.util.List;

import dto.CategoriaDTO;

public interface CategoriaDAO {

	public boolean insert(CategoriaDTO categoria);

	public boolean delete(CategoriaDTO categoria_a_eliminar);
	
	public List<CategoriaDTO> readAll();

	public boolean update(CategoriaDTO categoria_a_editar);
}
