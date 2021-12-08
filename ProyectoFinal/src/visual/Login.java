package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logical.Usuario;
import logical.Cliente;
import logical.Empresa;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				File f = new File("empresa.dat");
				FileInputStream fileIn;
				FileOutputStream fileOut;
				ObjectInputStream objectIn;
				ObjectOutputStream objectOut;
				try {
					fileIn = new FileInputStream(f);
					objectIn = new ObjectInputStream(fileIn);
					Empresa.empresa=(Empresa)objectIn.readObject();
					fileIn.close();
					objectIn.close();
				}catch(FileNotFoundException e) {
					try {
						fileOut = new FileOutputStream(f);
						objectOut = new ObjectOutputStream(fileOut);
						Usuario a = new Usuario("Admin", "0", "1", "2", "Admin", "1234", 1);
						Empresa.getInstance().addusuario(a);
						objectOut.writeObject(Empresa.getInstance());
						fileOut.close();
						objectOut.close();
					
					}catch(FileNotFoundException ex) {
						
					}catch(IOException ex) {
						
					}
					
				}catch(IOException e) {
					
				}catch(ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Reinicie el programa, un error ha succedido");
				}
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(149, 177, 300, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtUser.getText().equalsIgnoreCase("Usuario")) {
					txtUser.setText("");
				}else {
					txtUser.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUser.getText().equalsIgnoreCase("")) {
					txtUser.setText("Usuario");
				}
			}
		});
		txtUser.setBorder(null);
		txtUser.setText("Usuario");
		txtUser.setBounds(12, 9, 236, 22);
		panel.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(260, 0, 40, 40);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(149, 246, 300, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtPass = new JPasswordField();
		txtPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPass.getText().equalsIgnoreCase("Contraseña")) {
				txtPass.setEchoChar('●');
				txtPass.setText("") ;
				}else {
					txtPass.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPass.getText().equalsIgnoreCase("")) {
					txtPass.setText("Contraseña");
					txtPass.setEchoChar((char)0);
				}
			}
		});
		txtPass.setEchoChar((char)0);
		txtPass.setBorder(null);
		txtPass.setText("Contrase\u00F1a");
		txtPass.setBounds(12, 9, 240, 22);
		panel_1.add(txtPass);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(264, 0, 36, 40);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Empresa.getInstance().logeo(txtUser.getText(),txtPass.getText())) {
					
					Principal frame = new Principal();
					dispose();
					frame.setVisible(true);
					
				}else if(txtUser.getText().equalsIgnoreCase("Usuario") || txtUser.getText().equalsIgnoreCase("")
						|| txtPass.getText().equalsIgnoreCase("") || txtPass.getText().equalsIgnoreCase("Contraseña")){
					lblMensaje.setText("Llene toda la informacion");
				}else {
					lblMensaje.setText("Algo esta incorrecto, intente nuevamente");
				}
			}
		});
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(149, 328, 300, 59);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingresar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(99, 13, 158, 33);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(73, 6, 46, 46);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
			
		});
		lblX.setForeground(new Color(240, 255, 240));
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setBounds(559, 6, 41, 16);
		contentPane.add(lblX);
		
		lblMensaje = new JLabel("");
		lblMensaje.setForeground(Color.RED);
		lblMensaje.setFont(new Font("Arial", Font.BOLD, 12));
		lblMensaje.setBounds(149, 299, 300, 16);
		contentPane.add(lblMensaje);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(198, 35, 198, 114);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);
	}
}
