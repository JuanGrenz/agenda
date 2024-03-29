package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAgregarLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalidad;
	private JButton btnConfirmar;
	private static VentanaAgregarLocalidad INSTANCE;
	
	public static VentanaAgregarLocalidad getInstance()
	{
		if(INSTANCE == null)
			return new VentanaAgregarLocalidad();
		else
			return INSTANCE;
	}

	private VentanaAgregarLocalidad() 
	{
		super();
		setResizable(false);
		setTitle("Agregar localidad");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 381, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreLocalidad = new JLabel("Nombre de la localidad:");
		lblNombreLocalidad.setBounds(10, 14, 228, 14);
		panel.add(lblNombreLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(10, 39, 228, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(245, 67, 126, 23);
		panel.add(btnConfirmar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtLocalidad() 
	{
		return txtLocalidad;
	}

	public JButton getBtnConfirmar() 
	{
		return btnConfirmar;
	}

	public void cerrar()
	{
		this.txtLocalidad.setText(null);
		this.dispose();
	}
	
	public boolean verificarCampo() {
		if (txtLocalidad.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio.");
			return false;
		}
		return true;
	}
}

