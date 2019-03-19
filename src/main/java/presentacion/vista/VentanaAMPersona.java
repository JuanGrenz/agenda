package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;


public class VentanaAMPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JComboBox<String> comboBoxLocalidad;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtPiso;
	private JTextField txtDpto;
	private JTextField txtEmail;
	private JTextField txtCumpleaños;
	private JComboBox<String> comboBoxCategoriaContacto;
	private JButton btnConfirmar;
	private static VentanaAMPersona INSTANCE;
	
	public static VentanaAMPersona getInstance()
	{
		if(INSTANCE == null)
			return new VentanaAMPersona();
		else
			return INSTANCE;
	}

	private VentanaAMPersona() 
	{
		super();
		setTitle("Persona");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 343, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 307, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 93, 46, 14);
		panel.add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 134, 113, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 175, 113, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 216, 46, 14);
		panel.add(lblPiso);
		
		JLabel lblDpto = new JLabel("Departamento");
		lblDpto.setBounds(10, 257, 46, 14);
		panel.add(lblDpto);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 298, 113, 14);
		panel.add(lblEmail);
		
		JLabel lblCumpleaños = new JLabel("Cumpleaños");
		lblCumpleaños.setBounds(10, 339, 113, 14);
		panel.add(lblCumpleaños);
		
		JLabel lblCategoriaContacto = new JLabel("Categoria");
		lblCategoriaContacto.setBounds(10, 380, 113, 14);
		panel.add(lblCategoriaContacto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		comboBoxLocalidad = new JComboBox<String>();
		comboBoxLocalidad.setBounds(133, 90, 164, 20);
		panel.add(comboBoxLocalidad);
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(133, 131, 164, 20);
		panel.add(txtCalle);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(133, 172, 164, 20);
		panel.add(txtAltura);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(133, 213, 164, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		
		txtDpto = new JTextField();
		txtDpto.setBounds(133, 254, 164, 20);
		panel.add(txtDpto);
		txtDpto.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(133, 295, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCumpleaños = new JTextField();
		txtCumpleaños.setBounds(133, 336, 164, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		
		comboBoxCategoriaContacto = new JComboBox<String>();
		comboBoxCategoriaContacto.setBounds(133, 377, 164, 20);
		panel.add(comboBoxCategoriaContacto);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(208, 509, 89, 23);
		panel.add(btnConfirmar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}
	
	public String getTxtLocalidad()
	{
		String localidadSeleccionada = (String) comboBoxLocalidad.getSelectedItem();
		return localidadSeleccionada;
	}
	
	public JTextField getTxtCalle()
	{
		return txtCalle;
	}
	
	public JTextField getTxtAltura()
	{
		return txtAltura;
	}
	
	public JTextField getTxtPiso()
	{
		return txtPiso;
	}
	
	public JTextField getTxtDpto()
	{
		return txtDpto;
	}
	
	public JTextField getTxtEmail()
	{
		return txtEmail;
	}
	
	public JTextField getTxtCumpleaños()
	{
		return txtCumpleaños;
	}
	
	public String getTxtCategoria()
	{
		String categoriaSeleccionada = (String) comboBoxCategoriaContacto.getSelectedItem();
		return categoriaSeleccionada;
	}

	public JButton getBtnConfirmar() 
	{
		return btnConfirmar;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtCalle.setText(null);
		this.txtAltura.setText(null);
		this.txtPiso.setText(null);
		this.txtDpto.setText(null);
		this.txtEmail.setText(null);
		this.txtCumpleaños.setText(null);
		this.dispose();
	}
}

