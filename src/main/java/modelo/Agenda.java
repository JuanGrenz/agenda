package modelo;

import java.util.List;

import dto.CategoriaDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.CategoriaDAO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private CategoriaDAO categoria;
	private LocalidadDAO localidad;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	public void agregarCategoria(CategoriaDTO nuevaCategoria)
	{
		this.categoria.insert(nuevaCategoria);
	}

	public void borrarCategoria(CategoriaDTO categoria_a_eliminar) 
	{
		this.categoria.delete(categoria_a_eliminar);
	}
	
	public List<CategoriaDTO> obtenerCategorias()
	{
		return this.categoria.readAll();		
	}
	
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar) 
	{
		this.localidad.delete(localidad_a_eliminar);
	}
	
	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();		
	}
	
}
