package presentacion.vista;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;


public class VentanaEditarPersona extends JFrame 
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
	private JFormattedTextField txtCumpleaños;
	private DateFormat df = new SimpleDateFormat("dd/mm");
	private JComboBox<String> comboBoxCategoriaContacto;
	private JButton btnConfirmar;
	private static VentanaEditarPersona INSTANCE;
	
	public static VentanaEditarPersona getInstance()
	{
		if(INSTANCE == null)
			return new VentanaEditarPersona();
		else
			return INSTANCE;
	}

	private VentanaEditarPersona() 
	{
		super();
		setTitle("Editar persona");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 452, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 416, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 179, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 52, 179, 14);
		panel.add(lblTelfono);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 93, 179, 14);
		panel.add(lblLocalidad);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 134, 179, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 175, 179, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 216, 179, 14);
		panel.add(lblPiso);
		
		JLabel lblDpto = new JLabel("Departamento");
		lblDpto.setBounds(10, 257, 179, 14);
		panel.add(lblDpto);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 298, 179, 14);
		panel.add(lblEmail);
		
		JLabel lblCumpleaños = new JLabel("Fecha de cumpleaños");
		lblCumpleaños.setBounds(10, 339, 179, 14);
		panel.add(lblCumpleaños);
		
		JLabel lblCategoriaContacto = new JLabel("Categoria de contacto");
		lblCategoriaContacto.setBounds(10, 380, 179, 14);
		panel.add(lblCategoriaContacto);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(199, 8, 207, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(199, 49, 207, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		verificarNumero(txtTelefono);
		
		comboBoxLocalidad = new JComboBox<String>();
		comboBoxLocalidad.setBounds(199, 90, 207, 20);
		panel.add(comboBoxLocalidad);		
		
		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(199, 131, 207, 20);
		panel.add(txtCalle);
		
		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(199, 172, 207, 20);
		panel.add(txtAltura);
		verificarNumero(txtAltura);
		
		txtPiso = new JTextField();
		txtPiso.setBounds(199, 213, 207, 20);
		panel.add(txtPiso);
		txtPiso.setColumns(10);
		verificarNumero(txtPiso);
		
		txtDpto = new JTextField();
		txtDpto.setBounds(199, 254, 207, 20);
		panel.add(txtDpto);
		txtDpto.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(199, 295, 207, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtCumpleaños = new JFormattedTextField(df);
		txtCumpleaños.setBounds(199, 336, 207, 20);
		panel.add(txtCumpleaños);
		txtCumpleaños.setColumns(10);
		esFecha(txtCumpleaños);
		
		comboBoxCategoriaContacto = new JComboBox<String>();
		comboBoxCategoriaContacto.setBounds(199, 377, 207, 20);
		panel.add(comboBoxCategoriaContacto);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(293, 509, 113, 23);
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
	
	public JComboBox<String> getComboBoxLocalidad() {
		return comboBoxLocalidad;
	}

	public JComboBox<String> getComboBoxCategoriaContacto() {
		return comboBoxCategoriaContacto;
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
	
	private void verificarNumero(JTextField campo) {
		campo.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE)
						&& (caracter != '-' || campo.getText().contains("-"))
						&& (caracter != '.' || campo.getText().contains("."))) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se admiten numeros en este campo.");
				}
			}
		});
	}
	
	private void esFecha(JFormattedTextField campo)
	{
		campo.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_SLASH)))        
				{
					JOptionPane.showMessageDialog(null, "Ingrese una fecha con el formato dd/mm");
					e.consume();
				}
			}
		});
	}
}

