package dto;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String email;
	private String cumpleaños;
	private String calle;
	private String altura;
	private String piso;  
	private String dpto;
	
	private String categoria;
	private String localidad;

	public PersonaDTO(int idPersona, String nombre, String telefono, String email, 
						String cumpleaños,String calle, String altura, String piso,
						String dpto, String localidad, String categoria)
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.cumpleaños = cumpleaños;
		this.calle = calle;
		this.altura = altura;
		this.piso = piso;
		this.dpto = dpto;
		this.categoria = categoria;
		this.localidad = localidad;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}
	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}
	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}
	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getCumpleaños()
	{
		return cumpleaños;
	}
	public void setCumpleaños(String cumpleaños)
	{
		this.cumpleaños = cumpleaños;
	}

	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getAltura() {
		return altura;
	}
	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}

	public String getDpto() {
		return dpto;
	}
	public void setDpto(String dpto) {
		this.dpto = dpto;
	}

	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getLocalidad() {
		return localidad;
	}
	
}
