package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAMLocalidad extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLocalidad;
	private JButton btnConfirmar;
	private static VentanaAMLocalidad INSTANCE;
	
	public static VentanaAMLocalidad getInstance()
	{
		if(INSTANCE == null)
			return new VentanaAMLocalidad();
		else
			return INSTANCE;
	}

	private VentanaAMLocalidad() 
	{
		super();
		setTitle("Localidad");
		
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
		
		JLabel lblNombreLocalidad = new JLabel("Nombre de la localidad");
		lblNombreLocalidad.setBounds(10, 14, 113, 14);
		panel.add(lblNombreLocalidad);
		
		txtLocalidad = new JTextField();
		txtLocalidad.setBounds(143, 11, 228, 20);
		panel.add(txtLocalidad);
		txtLocalidad.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(282, 67, 89, 23);
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
}

