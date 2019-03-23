package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaMensajeError extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static VentanaMensajeError INSTANCE;
	
	public static VentanaMensajeError getInstance()
	{
		if(INSTANCE == null)
			return new VentanaMensajeError();
		else
			return INSTANCE;
	}

	private VentanaMensajeError() 
	{
		super();
		setTitle("ERROR!!!");
		
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
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 14, 361, 76);
		panel.add(lblError);
		
		this.setVisible(false);
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}

}

