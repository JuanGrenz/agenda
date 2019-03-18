package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import persistencia.conexion.Conexion;

public class VentanaLocalidad
{
	private JFrame frmAgenda;
	private JTable tablaLocalidad;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private DefaultTableModel modelLocalidad;
	private String[] nombreColumnas = {"Localidad"};

	public VentanaLocalidad() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frmAgenda = new JFrame();
		frmAgenda.setTitle("ABM Localidad");
		frmAgenda.setBounds(100, 100, 461, 358);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 445, 319);
		frmAgenda.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spLocalidad = new JScrollPane();
		spLocalidad.setBounds(10, 11, 323, 297);
		panel.add(spLocalidad);
		
		modelLocalidad = new DefaultTableModel(null,nombreColumnas);
		tablaLocalidad = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Localidad"
			}
		));
		
		spLocalidad.setViewportView(tablaLocalidad);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(343, 11, 89, 23);
		panel.add(btnAgregar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(343, 45, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(343, 79, 89, 23);
		panel.add(btnBorrar);
	}
	
	public void show()
	{
		this.frmAgenda.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frmAgenda.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "Estas seguro que quieres salir de la Agenda!?", 
		             "Confirmacion", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	//Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frmAgenda.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}

	public DefaultTableModel getModelLocalidad() 
	{
		return modelLocalidad;
	}
	
	public JTable getTablaLocalidad()
	{
		return tablaLocalidad;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
}
