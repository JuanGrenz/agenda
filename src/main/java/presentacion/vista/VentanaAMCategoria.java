package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaAMCategoria extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCategoria;
	private JButton btnConfirmar;
	private static VentanaAMCategoria INSTANCE;
	
	public static VentanaAMCategoria getInstance()
	{
		if(INSTANCE == null)
			return new VentanaAMCategoria();
		else
			return INSTANCE;
	}

	private VentanaAMCategoria() 
	{
		super();
		setTitle("Categoria de contacto");
		
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
		
		JLabel lblCategoriaContacto = new JLabel("Categoria de contacto");
		lblCategoriaContacto.setBounds(10, 14, 113, 14);
		panel.add(lblCategoriaContacto);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(143, 11, 228, 20);
		panel.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setBounds(282, 67, 89, 23);
		panel.add(btnConfirmar);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtCategoria() 
	{
		return txtCategoria;
	}

	public JButton getBtnConfirmar() 
	{
		return btnConfirmar;
	}

	public void cerrar()
	{
		this.txtCategoria.setText(null);
		this.dispose();
	}
}

