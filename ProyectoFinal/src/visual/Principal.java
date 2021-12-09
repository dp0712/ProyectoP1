package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logical.Empresa;
import logical.Facturacion;


import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private static JPanel contentPane;
	private Dimension din;
	private static JPanel panel_3;
	private JMenu mnComponente;
	private JMenu mnFactura;
	private JMenu mnCliente;
	private JMenu mnCombos;
	private JMenu mnProveedor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Empresa temp = (Empresa)empresaRead.readObject();
					Empresa.setEmpresa(temp);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
						empresaWrite.writeObject(Empresa.getInstance());
						empresa2.close();
						empresaWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
						Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Imagenes/Pc-Gamer-Normal-Mode.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Empresa.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		this.addWindowListener(new WindowListener() {

			 @Override
			public void windowOpened(WindowEvent e) {
				 
				 
			}

			 @Override
			public void windowClosing(WindowEvent e) {
			try {
			File f = new File("empresa.dat");
			FileOutputStream fileOut = new FileOutputStream(f);
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(Empresa.getInstance());
			objectOut.close();
			
			} catch (Exception ex) {
			ex.printStackTrace();
			}

			}
			 
			 
			 
			 @Override
			public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			}
			});
		
		setTitle("Ventana Principal");
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 411);
		din = getToolkit().getScreenSize();  
		super.setSize(din.width,din.height-45);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.focus"));
		menuBar.setForeground(UIManager.getColor("Button.focus"));
		setJMenuBar(menuBar);
		
		mnFactura = new JMenu("Facturar");
		mnFactura.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnFactura.setForeground(Color.BLACK);
		mnFactura.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnFactura);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturaci\u00F3n");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			Facturar aux= new Facturar(null);
			aux.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_1.setForeground(Color.DARK_GRAY);	
		mnFactura.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Listado de Facturas");
		mntmNewMenuItem_2.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_2.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadodeFacturas aux=null;
				 aux = new ListadodeFacturas(aux);
			
				aux.setVisible(true);
			}
		});
		mnFactura.add(mntmNewMenuItem_2);
		
		mnComponente = new JMenu("Componentes");

		mnComponente.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnComponente.setBackground(UIManager.getColor("Button.focus"));
		mnComponente.setForeground(Color.BLACK);
		menuBar.add(mnComponente);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Agregar Componente");
		mntmNewMenuItem.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem.setBackground(UIManager.getColor("Button.focus"));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarComponente a = new AgregarComponente();
				a.setVisible(true);
			}
		});
		
		mnComponente.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado de Componentes");
		mntmNewMenuItem_4.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_4.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadodeComponentes aux = new ListadodeComponentes();
				aux.setVisible(true);
				
			}
		});
		mnComponente.add(mntmNewMenuItem_4);
		
		mnCliente = new JMenu("Cliente");
		mnCliente.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnCliente.setForeground(Color.BLACK);
		mnCliente.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnCliente);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listado de Clientes");
		mntmNewMenuItem_3.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_3.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ListadodeClientes aux = new ListadodeClientes(1);
				aux.setVisible(true);
			}
		});
		mnCliente.add(mntmNewMenuItem_3);
		
		mnCombos = new JMenu("Combos");
		mnCombos.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnCombos.setBackground(UIManager.getColor("Button.focus"));
		mnCombos.setForeground(Color.BLACK);
		menuBar.add(mnCombos);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Agregar Combo");
		mntmNewMenuItem_5.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_5.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisCombo aux = new RegisCombo();
				aux.setVisible(true);
			}
		});
		mnCombos.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Listado de  Combos");
		mntmNewMenuItem_6.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_6.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadodeComponentes aux = new ListadodeComponentes();
				aux.setVisible(true);
			}
		});
		mnCombos.add(mntmNewMenuItem_6);
		
		mnProveedor = new JMenu("Proveedor");
		mnProveedor.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		mnProveedor.setForeground(Color.BLACK);
		mnProveedor.setBackground(UIManager.getColor("Button.focus"));
		menuBar.add(mnProveedor);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Registrar Proveedor");
		mntmNewMenuItem_7.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_7.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisProveedor aux = new RegisProveedor();
				aux.setVisible(true);
			}
		});
		mnProveedor.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listado de Proveedores");
		mntmNewMenuItem_8.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_8.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadeProveedores aux = new ListadeProveedores();
				aux.setVisible(true);
				
			}
		});
		mnProveedor.add(mntmNewMenuItem_8);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("Button.focus"));
		contentPane.setBackground(UIManager.getColor("Button.focus"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("mainlabel");
		ImageIcon imagen =new ImageIcon(getClass().getResource("/Imagenes/equipos-de-computo-para-personas-de-escasos-recursos.jpg"));
		Icon icono= new ImageIcon(imagen.getImage().getScaledInstance((int)939,(int)900,Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		lblNewLabel.setBounds(169, 11, 942, 372);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenido a su Empresa!!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewLabel_1.setBounds(473, 438, 604, 118);
		panel_3.add(lblNewLabel_1);
		setLocationRelativeTo(null);
		
		cargargraficos();
		CargarMenu();
		
	}
	
	private void CargarMenu() {
		if(Empresa.getInstance().getMisclientes() != null ) {
			mnComponente.setEnabled(true);
			mnCliente.setEnabled(true);
			mnCombos.setEnabled(true);
			mnProveedor.setEnabled(true);
			mnFactura.setEnabled(true);

		}
		
		
	}
	
	
	public static void cargargraficos() {
	
		panel_3.doLayout();

	}
}

