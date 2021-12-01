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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

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
		
		setTitle("");
		
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
				ListadodeFacturas aux = new ListadodeFacturas();
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
				RegisProveedores aux = new RegisProveedores();
				aux.setVisible(true);
			}
		});
		mnProveedor.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Listado de Proveedores");
		mntmNewMenuItem_8.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_8.setBackground(UIManager.getColor("Button.focus"));
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListadodeProveedores aux = new ListadodeProveedores();
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
		panel_3.setLayout(new BorderLayout(0, 0));
		contentPane.add(panel_3);
		setLocationRelativeTo(null);
		
		cargargraficos();
		CargarMenu();
		
	}
	
	private void CargarMenu() {
		if(Empresa.getInstance().getMisclientes() != null ) {
			mnComponente.setEnabled(false);
			mnCliente.setEnabled(false);
			mnCombos.setEnabled(false);
			mnProveedor.setEnabled(false);
			mnFactura.setEnabled(true);

		}
		
		
	}
	
	
	public static void cargargraficos() {
	
		panel_3.doLayout();

	}
	
	/*
	private static ChartPanel crear() {
		float total[] = new float [4];
		total = Empresa.getInstance().CalcBeneficios_T();
	
		DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Disco Duro", total[0]);
        dataset.setValue("MotherBoard", total[1]);
        dataset.setValue("Microprocesadores", total[2]);
        dataset.setValue("MemoriaRam", total[3]);
 
        
        JFreeChart chart = ChartFactory.createPieChart(// char t
                
                "Porciento de ganancias por tipo.",// title                                                                     
                dataset, // data
                true, // include legend
                true, false);
        
        
        ChartPanel panel= new ChartPanel(chart);
        panel.setForeground(UIManager.getColor("Button.focus"));
        panel.setBackground(UIManager.getColor("Button.focus"));
		
		return panel;
	}
private static ChartPanel Barras3d() {
		
		String A = "Disco Duro";
        String B = "Motherboard";
        String C = "MemoriaRam";
        String D = "Microprocesador";
        
        String vel = "Ventas";
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /*
        dataset.addValue(0.0d, A, vel);
        dataset.addValue(0.0d, B, vel);
        dataset.addValue(0.0d, C, vel);
        dataset.addValue(0.0d, D, vel);
        
        
        dataset.addValue(5.0, B, vel);
        dataset.addValue(6.0, B, vel);
        dataset.addValue(10.0, B, vel);
 
        dataset.addValue(4.0, C, vel);
        dataset.addValue(2.0, C, vel);
        dataset.addValue(3.0, C, vel);
      
        dataset.addValue(Empresa.getInstance().getTotDisco(), A, vel);
        dataset.addValue(Empresa.getInstance().getTotMotherboard(), B, vel);
        dataset.addValue(Empresa.getInstance().getTotMemoriaRam(), C, vel);
        dataset.addValue(Empresa.getInstance().getTotMicroprocesadores(), D, vel);
 	
        
        JFreeChart barChart = ChartFactory.createBarChart3D(
                "Grafica ventas componentes", 
                "Categoria", 
                "Vendidos", 
                dataset,
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false);
 
        ChartPanel panel = new ChartPanel(barChart);
        panel.setForeground(UIManager.getColor("Button.focus"));
        panel.setBackground(UIManager.getColor("Button.focus"));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
       // panel.setlocati;
        return panel;
	}
	*/

}

