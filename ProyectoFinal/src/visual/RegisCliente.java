package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Cliente;
import logical.Usuario;
import logical.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCedula;
	private JButton btnSeleccionar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public RegisCliente() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setTitle("Registrar Cliente");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 476, 491);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setForeground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setForeground(Color.DARK_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblNombre = new JLabel("Nombre:");
				lblNombre.setBackground(UIManager.getColor("Button.focus"));
				lblNombre.setForeground(Color.BLACK);
				lblNombre.setBounds(12, 36, 89, 32);
				panel.add(lblNombre);
			}
			
			txtNombre = new JTextField();
			txtNombre.setForeground(Color.WHITE);
			txtNombre.setBackground(Color.DARK_GRAY);
			txtNombre.setBounds(111, 41, 333, 27);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCedula = new JLabel("Cedula:");
			lblCedula.setBackground(UIManager.getColor("Button.focus"));
			lblCedula.setForeground(Color.BLACK);
			lblCedula.setBounds(12, 100, 89, 32);
			panel.add(lblCedula);
			
			txtCedula = new JTextField();
			txtCedula.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char carac = e.getKeyChar();
					if(((carac<'0') || (carac>'9')) && ((carac!='-') && (carac!='\b'))) {
						e.consume();
					}
				}
			});
			txtCedula.setForeground(Color.WHITE);
			txtCedula.setBackground(Color.DARK_GRAY);
			txtCedula.setColumns(10);
			txtCedula.setBounds(111, 103, 333, 27);
			panel.add(txtCedula);
			
			
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBackground(UIManager.getColor("Button.focus"));
			lblTelefono.setForeground(Color.BLACK);
			lblTelefono.setBounds(12, 158, 89, 32);
			panel.add(lblTelefono);
			
			txtTelefono = new JTextField();
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char carac = e.getKeyChar();
					if(((carac<'0') || (carac>'9')) && ((carac!='(') && (carac!='\b') && (carac!=')') && (carac!='-') && (carac!='+'))) {
						e.consume();
					}
				}
			});
			txtTelefono.setForeground(Color.WHITE);
			txtTelefono.setBackground(Color.DARK_GRAY);
			txtTelefono.setColumns(10);
			txtTelefono.setBounds(111, 161, 333, 27);
			panel.add(txtTelefono);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setBackground(UIManager.getColor("Button.focus"));
			lblDireccion.setForeground(Color.BLACK);
			lblDireccion.setBounds(12, 217, 89, 32);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setBackground(Color.DARK_GRAY);
			txtDireccion.setForeground(Color.WHITE);
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(111, 220, 333, 27);
			panel.add(txtDireccion);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnSeleccionar = new JButton("Agregar a Cliente Creado\r\n");
			btnSeleccionar.setForeground(Color.BLACK);
			btnSeleccionar.setBackground(UIManager.getColor("Button.focus"));
			btnSeleccionar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadodeClientes a = new ListadodeClientes(0);
					dispose();
					a.setVisible(true);
					
				}
			});
			buttonPane.add(btnSeleccionar);
			{
				JButton okButton = new JButton("Registrar");
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.setForeground(Color.BLACK);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Cliente c = null;
							c = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText(), txtDireccion.getText(), 0.0, 0);
			
						Empresa.getInstance().insertarCliente(c);
						Facturar.CargarCliente((Cliente)c);
						JOptionPane.showMessageDialog(null, "Se ha registrado correctamente el cliente");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(Color.BLACK);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
