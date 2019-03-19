package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaAgregarCategoria;
import presentacion.vista.VentanaAgregarLocalidad;
import presentacion.vista.VentanaAMPersona;
import presentacion.vista.VentanaCategoria;
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
		
		private VentanaAMPersona ventanaPersona;
		private VentanaAgregarLocalidad ventanaAMLocalidad;
		private VentanaAgregarCategoria ventanaAMCategoria;
		private VentanaLocalidad ventanaLocalidad;
		private VentanaCategoria ventanaCategoria;
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.ventanaPersona = VentanaAMPersona.getInstance();
			this.ventanaLocalidad = VentanaLocalidad.getInstance();
			this.ventanaCategoria = VentanaCategoria.getInstance();
			this.ventanaAMLocalidad = VentanaAgregarLocalidad.getInstance();
			this.ventanaAMCategoria = VentanaAgregarCategoria.getInstance();
			
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnEditar().addActionListener(e->editarPersona(e));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.vista.getBtnLocalidad().addActionListener(l->ventanaLocalidad(l));
			this.vista.getBtnCategoria().addActionListener(c->ventanaCategoria(c));		
			this.ventanaLocalidad.getBtnAgregar().addActionListener(a->ventanaAgregarLocalidad(a));
			this.ventanaLocalidad.getBtnBorrar().addActionListener(s->borrarLocalidad(s));
			this.ventanaCategoria.getBtnAgregar().addActionListener(a->ventanaAgregarCategoria(a));
			this.ventanaCategoria.getBtnBorrar().addActionListener(s->borrarCategoria(s));

			this.ventanaPersona.getBtnConfirmar().addActionListener(p->guardarPersona(p));
			this.ventanaAMLocalidad.getBtnConfirmar().addActionListener(c->guardarLocalidad(c));
			this.ventanaAMCategoria.getBtnConfirmar().addActionListener(c->guardarCategoria(c));
			
			this.agenda = agenda;
			this.personas_en_tabla = null;
			this.localidades_en_tabla = null;
			this.categorias_en_tabla = null;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}
		
		private void guardarPersona(ActionEvent p) {	
			
			this.agenda.agregarPersona(addPersona());
			this.llenarTablaPersonas();
			this.ventanaPersona.cerrar();
		}
		
		private PersonaDTO addPersona() {
			PersonaDTO nuevaPersona = new PersonaDTO(0,
					this.ventanaPersona.getTxtNombre().getText(),
					this.ventanaPersona.getTxtTelefono().getText(),
					this.ventanaPersona.getTxtEmail().getText(),
                    this.ventanaPersona.getTxtCumpleaños().getText(),
					this.ventanaPersona.getTxtCalle().getText(),
					this.ventanaPersona.getTxtAltura().getText(),
					this.ventanaPersona.getTxtPiso().getText(),
					this.ventanaPersona.getTxtDpto().getText());
			return nuevaPersona;
		}
		
		private void editarPersona(ActionEvent e) {
			// TODO Auto-generated method stub
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
			this.ventanaAMLocalidad.mostrarVentana();
		}
		
		private void guardarLocalidad(ActionEvent c)
		{
			this.agenda.agregarLocalidad(addLocalidad());
			this.llenarTablaLocalidades();
			this.ventanaAMLocalidad.cerrar();
		}
		
		private LocalidadDTO addLocalidad()
		{
			LocalidadDTO nuevaLocalidad = new LocalidadDTO(0, this.ventanaAMLocalidad.getTxtLocalidad().getText());
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
			this.ventanaAMCategoria.mostrarVentana();
		}
		
		private void guardarCategoria(ActionEvent c)
		{
			this.agenda.agregarCategoria(addCategoria());
			this.llenarTablaCategorias();
			this.ventanaAMCategoria.cerrar();
		}

		private CategoriaDTO addCategoria()
		{
			CategoriaDTO nuevaCategoria = new CategoriaDTO(0, this.ventanaAMCategoria.getTxtCategoria().getText());
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
}
