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
	private JLabel lblCredito;
	private JTextField txtCredito;
	private JLabel lblDias;
	private JSpinner spnDias;
	private JButton btnSeleccionar;
	private JRadioButton rdbtnSi;
	private JRadioButton rdbtnNo;

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
			
			spnDias = new JSpinner();
			spnDias.setForeground(new Color(0, 0, 255));
			spnDias.setBackground(UIManager.getColor("Button.focus"));
			spnDias.setModel(new SpinnerNumberModel(1, 1, 120, 1));
			spnDias.setBounds(363, 354, 68, 27);
			panel.add(spnDias);
			
			lblDias = new JLabel("Dias Para Pagar:");
			lblDias.setBackground(UIManager.getColor("Button.focus"));
			lblDias.setForeground(Color.BLACK);
			lblDias.setBounds(266, 359, 89, 16);
			panel.add(lblDias);
			
			lblCredito = new JLabel("Cantidad de Credito:");
			lblCredito.setBackground(UIManager.getColor("Button.focus"));
			lblCredito.setForeground(Color.BLACK);
			lblCredito.setBounds(12, 357, 125, 16);
			panel.add(lblCredito);
			
			txtCredito = new JTextField();
			txtCredito.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					char carac = e.getKeyChar();
					if(((carac<'0') || (carac>'9')) && ((carac!='.') && (carac!='\b'))) {
						e.consume();
					}
				}
			});
			txtCredito.setBackground(Color.DARK_GRAY);
			txtCredito.setForeground(Color.WHITE);
			txtCredito.setBounds(147, 354, 109, 27);
			panel.add(txtCredito);
			txtCredito.setColumns(10);
			
			rdbtnSi = new JRadioButton("Si");
			rdbtnSi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
						rdbtnNo.setSelected(false);
						lblCredito.setVisible(true);
						txtCredito.setVisible(true);
						spnDias.setVisible(true);
						lblDias.setVisible(true);
					
				}
			});
			rdbtnSi.setBounds(165, 296, 56, 25);
			panel.add(rdbtnSi);
			
			JLabel lblNewLabel = new JLabel("Desea tener Credito?\r\n");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setBounds(12, 300, 272, 16);
			panel.add(lblNewLabel);
			
			rdbtnNo = new JRadioButton("No");
			rdbtnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					rdbtnSi.setSelected(false);
					lblCredito.setVisible(false);
					txtCredito.setVisible(false);
					spnDias.setVisible(false);
					lblDias.setVisible(false);
					
				}
			});
			rdbtnNo.setBounds(304, 296, 68, 25);
			panel.add(rdbtnNo);
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
						if(rdbtnSi.isSelected()) {
							c = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText()
									, txtDireccion.getText( ), Float.parseFloat(txtCredito.getText())
									, Integer.parseInt(spnDias.getValue().toString()));
						}else {
							c = new Cliente(txtNombre.getText(), txtCedula.getText(), txtTelefono.getText()
									, txtDireccion.getText(), 0.0f
									, 0);
							
						}
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
