package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaAgregarCategoria;
import presentacion.vista.VentanaAgregarLocalidad;
import presentacion.vista.VentanaAgregarPersona;
import presentacion.vista.VentanaCategoria;
import presentacion.vista.VentanaEditarPersona;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.Vista;
import dto.CategoriaDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private List<LocalidadDTO> localidades_en_tabla;
		private List<CategoriaDTO> categorias_en_tabla;
		
		private VentanaAgregarPersona ventanaAgregarPersona;
		private VentanaEditarPersona ventanaEditarPersona;
		private VentanaAgregarLocalidad ventanaAgregarLocalidad;
		private VentanaAgregarCategoria ventanaAgregarCategoria;
		private VentanaLocalidad ventanaLocalidad;
		private VentanaCategoria ventanaCategoria;
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.ventanaAgregarPersona = VentanaAgregarPersona.getInstance();
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaCategoria = VentanaCategoria.getInstance();
			this.ventanaEditarPersona = VentanaEditarPersona.getInstance();
			this.ventanaAgregarLocalidad = VentanaAgregarLocalidad.getInstance();
			this.ventanaAgregarCategoria = VentanaAgregarCategoria.getInstance();
			
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnEditar().addActionListener(e->ventanaEditarPersona(e));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnLocalidad().addActionListener(l->ventanaLocalidad(l));
			this.vista.getBtnCategoria().addActionListener(c->ventanaCategoria(c));		
			this.ventanaLocalidad.getBtnAgregar().addActionListener(a->ventanaAgregarLocalidad(a));
			this.ventanaLocalidad.getBtnBorrar().addActionListener(s->borrarLocalidad(s));
			this.ventanaCategoria.getBtnAgregar().addActionListener(a->ventanaAgregarCategoria(a));
			this.ventanaCategoria.getBtnBorrar().addActionListener(s->borrarCategoria(s));

			this.ventanaAgregarPersona.getBtnConfirmar().addActionListener(p->guardarPersona(p));
			this.ventanaEditarPersona.getBtnConfirmar().addActionListener(p->editarPersona(p));
			this.ventanaAgregarLocalidad.getBtnConfirmar().addActionListener(c->guardarLocalidad(c));
			this.ventanaAgregarCategoria.getBtnConfirmar().addActionListener(c->guardarCategoria(c));
			
			this.agenda = agenda;
			this.personas_en_tabla = null;
			this.localidades_en_tabla = null;
			this.categorias_en_tabla = null;
		}
		
		private void ventanaAgregarPersona(ActionEvent a)
		{
			this.llenarComboBox();
			this.ventanaAgregarPersona.mostrarVentana();
		}
		
		private void guardarPersona(ActionEvent p)
		{
			this.agenda.agregarPersona(addPersona());
			this.llenarTablaPersonas();
			this.ventanaAgregarPersona.cerrar();
		}
		
		private PersonaDTO addPersona()
		{
			PersonaDTO nuevaPersona = new PersonaDTO(0,
					this.ventanaAgregarPersona.getTxtNombre().getText(),
					this.ventanaAgregarPersona.getTxtTelefono().getText(),
					this.ventanaAgregarPersona.getTxtEmail().getText(),
                    this.ventanaAgregarPersona.getTxtCumpleaños().getText(),
					this.ventanaAgregarPersona.getTxtCalle().getText(),
					this.ventanaAgregarPersona.getTxtAltura().getText(),
					this.ventanaAgregarPersona.getTxtPiso().getText(),
					this.ventanaAgregarPersona.getTxtDpto().getText(),
					this.ventanaAgregarPersona.getTxtLocalidad(),
					this.ventanaAgregarPersona.getTxtCategoria());
					
			return nuevaPersona;
		}
		
		private void ventanaEditarPersona(ActionEvent e) {
			this.llenarComboBox();
			this.llenarCampos(this.personas_en_tabla.get(this.vista.getTablaPersonas().getSelectedRow()));
			this.ventanaEditarPersona.mostrarVentana();
		}
		
		private void editarPersona(ActionEvent p)
		{
			this.agenda.editarPersona(editPersona());
			this.llenarTablaPersonas();
			this.ventanaEditarPersona.cerrar();
		}
		
		private PersonaDTO editPersona()
		{
			PersonaDTO personaEditada = new PersonaDTO(0,
					this.ventanaEditarPersona.getTxtNombre().getText(),
					this.ventanaEditarPersona.getTxtTelefono().getText(),
					this.ventanaEditarPersona.getTxtEmail().getText(),
	                this.ventanaEditarPersona.getTxtCumpleaños().getText(),
					this.ventanaEditarPersona.getTxtCalle().getText(),
					this.ventanaEditarPersona.getTxtAltura().getText(),
					this.ventanaEditarPersona.getTxtPiso().getText(),
					this.ventanaEditarPersona.getTxtDpto().getText(),
					this.ventanaEditarPersona.getTxtLocalidad(),
					this.ventanaEditarPersona.getTxtCategoria());
						
			return personaEditada;
		}
		
		private void llenarCampos(PersonaDTO personaDTO) {
			this.ventanaEditarPersona.getTxtNombre().setText(personaDTO.getNombre());
			this.ventanaEditarPersona.getTxtTelefono().setText(personaDTO.getTelefono());
			this.ventanaEditarPersona.getComboBoxLocalidad().setSelectedItem(personaDTO.getLocalidad());
			this.ventanaEditarPersona.getTxtCalle().setText(personaDTO.getCalle());
			this.ventanaEditarPersona.getTxtAltura().setText(personaDTO.getAltura());
			this.ventanaEditarPersona.getTxtPiso().setText(personaDTO.getPiso());
			this.ventanaEditarPersona.getTxtDpto().setText(personaDTO.getDpto());
			this.ventanaEditarPersona.getTxtEmail().setText(personaDTO.getEmail());
			this.ventanaEditarPersona.getTxtCumpleaños().setText(personaDTO.getCumpleaños());
			this.ventanaEditarPersona.getComboBoxCategoriaContacto().setSelectedItem(personaDTO.getCategoria());
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila:filas_seleccionadas)
			{
				this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
			}
			
			this.llenarTablaPersonas(); 
		}

		private void ventanaLocalidad(ActionEvent l) {
			this.llenarTablaLocalidades();
			this.ventanaLocalidad.mostrarVentana();
		}
		
		private void ventanaAgregarLocalidad(ActionEvent a) {
			this.ventanaAgregarLocalidad.mostrarVentana();
		}
		
		private void guardarLocalidad(ActionEvent c)
		{
			this.agenda.agregarLocalidad(addLocalidad());
			this.llenarComboBox();
			this.llenarTablaLocalidades();
			this.ventanaAgregarLocalidad.cerrar();
		}
		
		private LocalidadDTO addLocalidad()
		{
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, this.ventanaAgregarLocalidad.getTxtLocalidad().getText());
			return nuevaLocalidad;
		}

		public void borrarLocalidad(ActionEvent s)
		{
			int[] filas_seleccionadas = this.ventanaLocalidad.getTablaLocalidad().getSelectedRows();
			for (int fila:filas_seleccionadas)
			{
				this.agenda.borrarLocalidad(this.localidades_en_tabla.get(fila));
			}
			
			this.llenarTablaLocalidades(); 
		}
		
		private void ventanaCategoria(ActionEvent c) {
			this.llenarTablaCategorias();
			this.ventanaCategoria.mostrarVentana();
		}
		
		private void ventanaAgregarCategoria(ActionEvent a) {
			this.ventanaAgregarCategoria.mostrarVentana();
		}
		
		private void guardarCategoria(ActionEvent c)
		{
			this.agenda.agregarCategoria(addCategoria());
			this.llenarComboBox();
			this.llenarTablaCategorias();
			this.ventanaAgregarCategoria.cerrar();
		}

		private CategoriaDTO addCategoria()
		{
			CategoriaDTO nuevaCategoria = new CategoriaDTO(0, this.ventanaAgregarCategoria.getTxtCategoria().getText());
			return nuevaCategoria;
		}

		private void borrarCategoria(ActionEvent s)
		{
			int[] filas_seleccionadas = this.ventanaCategoria.getTablaCategoria().getSelectedRows();
			for (int fila:filas_seleccionadas)
			{
				this.agenda.borrarCategoria(this.categorias_en_tabla.get(fila));
			}
			
			this.llenarTablaCategorias(); 
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}
		
		public void inicializar()
		{
			this.llenarTablaPersonas();
			this.vista.show();
		}
	
		private void llenarTablaPersonas()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getNombre(),
						this.personas_en_tabla.get(i).getTelefono(),
						this.personas_en_tabla.get(i).getEmail(),
						this.personas_en_tabla.get(i).getCumpleaños(),
						this.personas_en_tabla.get(i).getLocalidad(),
						this.personas_en_tabla.get(i).getCalle(),
						this.personas_en_tabla.get(i).getAltura(),
						this.personas_en_tabla.get(i).getPiso(),
						this.personas_en_tabla.get(i).getDpto(),
						this.personas_en_tabla.get(i).getCategoria()					
						};
				this.vista.getModelPersonas().addRow(fila);			
			}			
		}

		private void llenarTablaLocalidades()
		{
			this.ventanaLocalidad.getModelLocalidad().setRowCount(0);
			this.ventanaLocalidad.getModelLocalidad().setColumnCount(0);
			this.ventanaLocalidad.getModelLocalidad().setColumnIdentifiers(this.ventanaLocalidad.getNombreColumnas());
			
			this.localidades_en_tabla = agenda.obtenerLocalidades();
			for (int i = 0; i < this.localidades_en_tabla.size(); i ++)
			{
				Object[] fila = {this.localidades_en_tabla.get(i).getNombre()};
				this.ventanaLocalidad.getModelLocalidad().addRow(fila);
			}
		}
		
		private void llenarTablaCategorias()
		{
			this.ventanaCategoria.getModelCategoria().setRowCount(0);
			this.ventanaCategoria.getModelCategoria().setColumnCount(0);
			this.ventanaCategoria.getModelCategoria().setColumnIdentifiers(this.ventanaCategoria.getNombreColumnas());
			
			this.categorias_en_tabla = agenda.obtenerCategorias();
			for (int i = 0; i < this.categorias_en_tabla.size(); i ++)
			{
				Object[] fila = {this.categorias_en_tabla.get(i).getNombre()};
				this.ventanaCategoria.getModelCategoria().addRow(fila);
			}
		}

		private void llenarComboBox() {
			this.ventanaAgregarPersona.getComboBoxCategoriaContacto().removeAllItems();
			this.ventanaAgregarPersona.getComboBoxLocalidad().removeAllItems();
			this.ventanaEditarPersona.getComboBoxCategoriaContacto().removeAllItems();
			this.ventanaEditarPersona.getComboBoxLocalidad().removeAllItems();
			
			for (CategoriaDTO categoria : this.agenda.obtenerCategorias()) {
				this.ventanaAgregarPersona.getComboBoxCategoriaContacto().addItem(categoria.getNombre());
				this.ventanaEditarPersona.getComboBoxCategoriaContacto().addItem(categoria.getNombre());
			}
			for (LocalidadDTO localidad : this.agenda.obtenerLocalidades()) {
				this.ventanaAgregarPersona.getComboBoxLocalidad().addItem(localidad.getNombre());
				this.ventanaEditarPersona.getComboBoxLocalidad().addItem(localidad.getNombre());
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
}
