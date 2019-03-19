package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class VentanaLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaLocalidad;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private DefaultTableModel modelLocalidad;
	private String[] nombreColumnas = {"Localidad"};
	private static VentanaLocalidad INSTANCE;
	
	public static VentanaLocalidad getInstance()
	{
		if(INSTANCE == null)
			return new VentanaLocalidad();
		else
			return INSTANCE;
	}

	private VentanaLocalidad() 
	{
		super();
		setTitle("ABM Localidad");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 480, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 442, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spLocalidad = new JScrollPane();
		spLocalidad.setBounds(0, 0, 323, 297);
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
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(343, 45, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(343, 79, 89, 23);
		panel.add(btnBorrar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}
	
	public JButton getBtnEditar()
	{
		return btnEditar;
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

