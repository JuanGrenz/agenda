package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaAMPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaAMPersona ventanaPersona; 
		private Agenda agenda;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaAMPersona.getInstance();
			this.ventanaPersona.getBtnConfirmar().addActionListener(p->guardarPersona(p));
			this.agenda = agenda;
			this.personas_en_tabla = null;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			PersonaDTO nuevaPersona = new PersonaDTO(0,
					this.ventanaPersona.getTxtNombre().getText(),
					this.ventanaPersona.getTxtTelefono().getText(),
					this.ventanaPersona.getTxtEmail().getText(),
                    this.ventanaPersona.getTxtCumpleaños().getText(),
                    "torcuato",
//					this.ventanaPersona.getTxtLocalidad(),
					this.ventanaPersona.getTxtCalle().getText(),
					this.ventanaPersona.getTxtAltura().getText(),
					this.ventanaPersona.getTxtPiso().getText(),
					this.ventanaPersona.getTxtDpto().getText(),
					"amigo");
					//this.ventanaPersona.getTxtCategoria());				
					
			this.agenda.agregarPersona(nuevaPersona);
			this.llenarTabla();
			this.ventanaPersona.cerrar();
		}

		private void mostrarReporte(ActionEvent r) {
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();	
		}

		public void borrarPersona(ActionEvent s)
		{
			int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila:filas_seleccionadas)
			{
				this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
			}
			
			this.llenarTabla(); 
		}
		
		public void inicializar()
		{
			this.llenarTabla();
			this.vista.show();
		}
		
		private void llenarTabla()
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

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
		
}
