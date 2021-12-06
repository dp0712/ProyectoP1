package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Cliente;
import logical.Combos;
import logical.Componente;
import logical.DiscoDuro;
import logical.Facturacion;
import logical.MemoriaRam;
import logical.MicroProcesador;
import logical.TarjetaMadre;
import logical.Usuario;
import logical.Empresa;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.DecimalFormat;

public class Facturar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnListarComponentes;
	private Dimension din;
	private static JButton btnSeleccionarCliente;
	private static JLabel lblNombre;
	private static JLabel lblCedula;
	private static JLabel lblTelefono;
	private static JLabel lblDireccion;
	private static JLabel lblLimiteCredito;
	private static JLabel lblCreditoDisponible;
	private static JLabel lblCodigo;
	private static JComboBox cbxVendedores;
	private static Combos combo = null;
	private static Componente componente = null;
	private static ArrayList<Combos>miscombos = new ArrayList<Combos>(); 
	private static ArrayList<Componente>miscomponentes = new ArrayList<Componente>(); 
	private static int cantidad = 0;
	public static DefaultTableModel modelo;
	public static Object[] fila =new Object [5];
	private int seleccion = -1;
	private static JLabel lblSubTotal;
	private static JLabel lblImpuestos;
	private static JLabel lblTotal;
	private static float subtotal = 0;
	private static Cliente cliente = null;
	private static JButton btnPagar;

	private static Facturacion auxiliar = null;

	
	public Facturar(Facturacion q) {
		setTitle("Factura");
		this.auxiliar=q;
		
		this.addWindowListener(new WindowListener() {
		
			@Override
			public void windowClosed(WindowEvent e) {
			
			}

			@Override
			public void windowOpened(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				if(auxiliar==null) {
				for(int i=0;i<modelo.getRowCount();i++) {
					if('C'==((String)modelo.getValueAt(i, 0)).charAt(0)) {
						Combos c = Empresa.getInstance().buscarelcombo((String)modelo.getValueAt(i, 0));
						Empresa.getInstance().devolverelCombo(c);
					}
				}
				}
				clear();
				cliente = null;
				dispose();
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
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 1057, 716);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setForeground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		din = getToolkit().getScreenSize();  
		//super.setSize(1054,din.height-45);
		setLocationRelativeTo(null);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(new Color(0, 128, 128));
			panel.setBackground(Color.WHITE);
			panel.setBorder(new LineBorder(Color.DARK_GRAY));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(Color.RED);
			panel_2.setBackground(Color.WHITE);
			panel_2.setBorder(new LineBorder(Color.DARK_GRAY));
			panel_2.setBounds(12, 6, 1002, 239);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			lblNombre = new JLabel("");
			lblNombre.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblNombre.setBounds(12, 23, 345, 31);
			panel_2.add(lblNombre);
			
			lblCedula = new JLabel("");
			lblCedula.setBackground(UIManager.getColor("Button.focus"));
			lblCedula.setForeground(new Color(0, 0, 128));
			lblCedula.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblCedula.setBounds(12, 77, 345, 31);
			panel_2.add(lblCedula);
			
			lblTelefono = new JLabel("");
			lblTelefono.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20));
			lblTelefono.setBounds(12, 131, 345, 31);
			panel_2.add(lblTelefono);
			
			lblDireccion = new JLabel("");
			lblDireccion.setBackground(UIManager.getColor("Button.focus"));
			lblDireccion.setForeground(SystemColor.textHighlight);
			lblDireccion.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblDireccion.setBounds(12, 185, 501, 31);
			panel_2.add(lblDireccion);
			
			lblLimiteCredito = new JLabel("");
			lblLimiteCredito.setBackground(UIManager.getColor("Button.focus"));
			lblLimiteCredito.setForeground(SystemColor.textHighlight);
			lblLimiteCredito.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblLimiteCredito.setBounds(422, 23, 285, 31);
			panel_2.add(lblLimiteCredito);
			
			lblCreditoDisponible = new JLabel("");
			lblCreditoDisponible.setBackground(UIManager.getColor("Button.focus"));
			lblCreditoDisponible.setForeground(SystemColor.textHighlight);
			lblCreditoDisponible.setFont(new java.awt.Font("Times New Roman", java.awt.Font.PLAIN, 21));
			lblCreditoDisponible.setBounds(423, 115, 272, 31);
			panel_2.add(lblCreditoDisponible);
			
			lblCodigo = new JLabel("Factura #"+Empresa.getInstance().getCodifact());
			lblCodigo.setBackground(UIManager.getColor("Button.focus"));
			lblCodigo.setForeground(Color.BLACK);
			lblCodigo.setFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 22));
			lblCodigo.setBounds(752, 23, 155, 31);
			panel_2.add(lblCodigo);
			Calendar inicio=new GregorianCalendar();
			inicio.setTime(new Date());
			
		
			
			btnSeleccionarCliente = new JButton("Seleccionar Cliente");
			if(auxiliar!=null) {
				btnSeleccionarCliente.setVisible(false);
			}else {
				btnSeleccionarCliente.setVisible(true);
			}
			btnSeleccionarCliente.setBackground(UIManager.getColor("Button.focus"));
			btnSeleccionarCliente.setForeground(Color.BLACK);
			btnSeleccionarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					RegisCliente a = new RegisCliente();
					a.setVisible(true);
				}
			});
			btnSeleccionarCliente.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			btnSeleccionarCliente.setBounds(22, 23, 446, 180);
			panel_2.add(btnSeleccionarCliente);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(Color.RED);
			panel_1.setBackground(Color.WHITE);
			panel_1.setBorder(new LineBorder(new Color(128, 0, 0)));
			panel_1.setBounds(12, 244, 1002, 211);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.WEST);
			
			modelo = new DefaultTableModel();
			String[] columns = {"Codigo","Articulo","Cantidad","Precio","Importe"}; 
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			if(auxiliar!=null) {
				table.setRowSelectionAllowed(false);
			}else {
				table.setRowSelectionAllowed(true);
			}
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					botones();
					if(seleccion!=-1){
						if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
							btnListarComponentes.setEnabled(true);
							btnEliminar.setEnabled(true);
						
							componente = null;
							combo = Empresa.getInstance().buscarelcombo((String)modelo.getValueAt(modelrow, 0));
							cantidad = (int)modelo.getValueAt(modelrow, 2);
						}else {
							btnListarComponentes.setEnabled(false);
							btnEliminar.setEnabled(true);
						
							componente = Empresa.getInstance().buscarelomponente((String)modelo.getValueAt(modelrow, 0));
							
							cantidad = (int)modelo.getValueAt(seleccion, 2);
							combo = null;
						}
						
					}else{	
						btnListarComponentes.setEnabled(false);
						btnEliminar.setEnabled(false);
						
						}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JPanel panel_3 = new JPanel();
			panel_3.setForeground(Color.RED);
			panel_3.setBackground(Color.DARK_GRAY);
			panel_3.setBounds(12, 459, 1002, 157);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			btnAgregar = new JButton("Agregar Articulo");
			if(auxiliar!=null) {
				btnAgregar.setVisible(false);
			}else {
				btnAgregar.setVisible(true);
			}
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadodeComponentes a = new ListadodeComponentes();
					a.setVisible(true);
				}
			});
			btnAgregar.setForeground(Color.BLACK);
			btnAgregar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 22));
			btnAgregar.setBackground(Color.WHITE);
			btnAgregar.setBounds(385, 13, 271, 124);
			panel_3.add(btnAgregar);
		
			
			btnEliminar = new JButton("Eliminar");
			if(auxiliar!=null) {
				btnEliminar.setVisible(false);
			}else {
				btnEliminar.setVisible(true);
			}
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(combo!=null) {
						miscombos.remove(combo);
						combo = null;
					}else {
						miscomponentes.remove(componente);
						Empresa.getInstance().sumarloscomponentes(componente,cantidad);
						componente = null;
					}
					modelo.removeRow(seleccion);
					btnEliminar.setEnabled(false);
					botones();
					CargarTotal();
					seleccion = -1;
				}

			});
			btnEliminar.setEnabled(false);
			btnEliminar.setForeground(Color.BLACK);
			btnEliminar.setBackground(Color.WHITE);
			btnEliminar.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnEliminar.setBounds(12, 15, 344, 52);
			panel_3.add(btnEliminar);
			
			btnListarComponentes = new JButton("Listar Componentes Combo");
			if(auxiliar!=null) {
				btnListarComponentes.setVisible(false);
			}else {
				btnListarComponentes.setVisible(true);
			}
			btnListarComponentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ListadodeComponentes a = new ListadodeComponentes();
					a.setVisible(true);
					
				}
			});
			btnListarComponentes.setEnabled(false);
			btnListarComponentes.setBackground(Color.WHITE);
			btnListarComponentes.setForeground(Color.BLACK);
			btnListarComponentes.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 18));
			btnListarComponentes.setBounds(12, 85, 344, 52);
			panel_3.add(btnListarComponentes);
			
			lblSubTotal = new JLabel("SubTotal:");
			lblSubTotal.setForeground(Color.WHITE);
			lblSubTotal.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			lblSubTotal.setBounds(666, 13, 322, 33);
			panel_3.add(lblSubTotal);
			
			lblImpuestos = new JLabel("ITBIS (18%):");
			lblImpuestos.setForeground(Color.WHITE);
			lblImpuestos.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			lblImpuestos.setBounds(668, 61, 322, 33);
			panel_3.add(lblImpuestos);
			
			lblTotal = new JLabel("Total:");
			lblTotal.setForeground(Color.WHITE);
			lblTotal.setFont(new java.awt.Font("Times New Roman", java.awt.Font.BOLD, 26));
			lblTotal.setBounds(668, 108, 322, 33);
			panel_3.add(lblTotal);

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnPagar = new JButton("Pagar");
				btnPagar.setEnabled(false);
				btnPagar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int ok = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar la factura");
						
						if(cliente !=null && ok==JOptionPane.OK_OPTION) {
							float pago = Float.parseFloat(JOptionPane.showInputDialog("Digite el monto del pago"));
							if(pago>=(subtotal+(subtotal*0.18f))) {
								Facturacion f = new Facturacion("F-"+Empresa.getInstance().getCodifact(), subtotal+(subtotal*0.18f),null, null, rootPaneCheckingEnabled);
										//("F-"+Empresa.getInstance().getCodifact(), subtotal+(subtotal*0.18f), cliente, false,modelo.getRowCount());
								
								for(int i= 0;i<modelo.getRowCount();i++) {
									fila[0]=modelo.getValueAt(i, 0).toString();
									fila[1]=modelo.getValueAt(i, 1).toString();
									fila[2]=Integer.parseInt(modelo.getValueAt(i, 2).toString());
									fila[3]=Float.parseFloat(modelo.getValueAt(i, 3).toString());
									fila[4]=Float.parseFloat(modelo.getValueAt(i, 4).toString());
									
									f.agregarfila(i,fila);
								
								}
								
								for(Combos c : miscombos) {
									f.agregarcombo(c);
									
								}
								for(Componente c : miscomponentes) {
									f.agregarcomponente(c);
									
								}
								
								try {
									GenerarFactura(f);
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								Empresa.getInstance().agregarfactura(f);
								JOptionPane.showMessageDialog(null, "Su devuelta es: "+(pago-(subtotal+(subtotal*0.18f))));
								btnPagar.setEnabled(false);
								
								clear();
							}else {
								JOptionPane.showMessageDialog(null, "Ha ingresado una cantidad inferior a la requerida, procure que pase de: "+(subtotal+(subtotal*0.18f)));
								btnPagar.setEnabled(true);
							}
						}
					}

			
				});
				btnPagar.setBackground(UIManager.getColor("Button.focus"));
				btnPagar.setForeground(Color.BLACK);
				btnPagar.setActionCommand("OK");
				buttonPane.add(btnPagar);
				getRootPane().setDefaultButton(btnPagar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<modelo.getRowCount();i++) {
							if('C'==((String)modelo.getValueAt(i, 0)).charAt(0)) {
								Combos c = Empresa.getInstance().buscarelcombo((String)modelo.getValueAt(i, 0));
								Empresa.getInstance().devolverelCombo(c);
							}else {
								Componente c = Empresa.getInstance().buscarelomponente((String)modelo.getValueAt(i, 0));
								Empresa.getInstance().sumarloscomponentes(c, (int)modelo.getValueAt(i, 2));
							}
						}
						cliente = null;
						
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(auxiliar!=null) {
		
			cargarfactura();
		}
	}

	
	private void clear() {
		btnSeleccionarCliente.setVisible(true);
		lblNombre.setText("");
		lblCedula.setText("");
		lblDireccion.setText("");
		lblTelefono.setText("");
		lblCreditoDisponible.setText("");
		lblLimiteCredito.setText("");
		modelo.setRowCount(0);
		cliente=null;
		miscombos.clear();//
		btnPagar.setEnabled(false);
		miscomponentes.clear();//
		componente=null;
		combo=null;
		lblCodigo.setText("Factura #"+Empresa.getInstance().getCodifact());	
		Calendar inicio=new GregorianCalendar();
		inicio.setTime(new Date());
		lblSubTotal.setText("Sub-Total: 0.0");
		lblImpuestos.setText("ITBIS (18%): 0.0");
		lblTotal.setText("Total: 0.0");
		
	}		
	
	
	
	public static void CargarCliente(Cliente c) {
		cliente  = c;
		lblNombre.setText(c.getNombre());
		lblCedula.setText(c.getCedula());
		lblDireccion.setText(c.getDireccion());
		lblTelefono.setText(c.getTelefono());
		lblLimiteCredito.setText("Limite de Credito: "+c.getLimitCredi());
		btnSeleccionarCliente.setVisible(false);
		botones();
		
	}
	
	public static void CargarTabla(Object[] fila) {
		
		if('C'==fila[0].toString().charAt(0)) {
			for(int i = 0;i<(int)fila[2];i++) {
				Combos c = Empresa.getInstance().buscarelcombo(fila[0].toString());
				miscombos.add(c);
			}
		
		}else {
			for(int i = 0;i<(int)fila[2];i++) {
				Componente c = Empresa.getInstance().buscarelomponente(fila[0].toString());
				miscomponentes.add(c);
			}
		}
		
		
		modelo.addRow(fila);
		botones();
		
		CargarTotal();
	}

	private static void CargarTotal() {
		subtotal = 0;
		for(int i = 0;i<table.getRowCount();i++) {
			subtotal+=(float)modelo.getValueAt(i, 4);
		}
		DecimalFormat formato1 = new DecimalFormat("#.00");
		lblSubTotal.setText("Sub-Total: "+formato1.format(subtotal));
		lblImpuestos.setText("ITBIS (18%): "+formato1.format((subtotal*0.18f)));
		lblTotal.setText("Total: "+formato1.format((subtotal+(subtotal*0.18f))));
		botones();
	
	}

	
	private static void botones() {
		if(modelo.getRowCount()>0 && cliente!=null) {
			btnPagar.setEnabled(true);
			}else {
				btnPagar.setEnabled(false);
			}
	}

private void GenerarFactura(Facturacion f) throws IOException {
		
		DecimalFormat formato1 = new DecimalFormat("#.00");
		Calendar inicio=new GregorianCalendar();
		try {
			File carpeta = new File("facturas");
			if(!carpeta.isDirectory()) {
				carpeta.mkdir();
			}
			
			File fichero = new File("facturas","Factura-"+Empresa.getInstance().getCodifact()+".txt");
			FileOutputStream fos = new FileOutputStream(fichero);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("--------------------------------------------------------------------------------------");
			bw.newLine();
			bw.write(String.format("%-50s %-50s",("Cliente: "+f.getCliente().getNombre()),f.getCodigo()));
			bw.newLine();
			bw.write(String.format("%-50s %-50s",("Cedula: "+f.getCliente().getCedula()),"Fecha: "+inicio.get(Calendar
					.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR)));
			bw.newLine();
			
			bw.write(String.format("%-50s %-50s",("Telefono: "+f.getCliente().getTelefono()),"Vendedor: "+f.getVendedor().getNombre()));
			bw.newLine();
			bw.newLine();
			bw.write("--------------------------------------------------------------------------------------");
			bw.newLine();
			bw.write(String.format("%-20s %-20s %-20s %-20s %-20s","Codigo","Articulo","Cantidad","Precio","Importe"));//10,7,7,
			bw.newLine();
			for(int i = 0;i<modelo.getRowCount();i++) {
				String codigo = (String)modelo.getValueAt(i, 0); 
				String nombre =(String)modelo.getValueAt(i, 1); 
				int cantidad = (int)modelo.getValueAt(i, 2); 
				float precio = (float)modelo.getValueAt(i, 3);
				float importe = (float)modelo.getValueAt(i, 4); 
				if(nombre.length()<=20) {
				bw.write(String.format("%-20s %-20s %-20s %-20s %-20s",codigo,nombre,cantidad,precio,importe));
				
				bw.newLine();
				}else {
					bw.write(String.format("%-20s %-20s %-20s %-20s %-20s",codigo, nombre.substring(0, 20),cantidad,precio,importe));
					bw.newLine();
				}
			}
			bw.write("Sub-Total: "+formato1.format((f.getPrecioTotal()/1.18f)));
			bw.newLine();
			bw.write("ITBIS 18%: "+formato1.format((f.getPrecioTotal()/1.18f)*0.18));
			bw.newLine();
			bw.write("Total: "+formato1.format(f.getPrecioTotal()));
			bw.newLine();
			bw.write("--------------------------------------------------------------------------------------");
			bw.newLine();
			bw.write("Gracias por preferirnos, recuerde que no aceptamos devoluciones");
			bw.newLine();
			bw.close();
			fos.close();
}catch (IOException e) {
	JOptionPane.showMessageDialog(null, "Ha ocurrido un error por favor compruebe que la carpeta -facturas- se encuentra creada en la ruta del programa");
}
		
	}


private void cargarfactura() {
	if(auxiliar!=null) {
	btnSeleccionarCliente.setVisible(false);
	cbxVendedores.setVisible(false);
	btnPagar.setVisible(false);
	lblCedula.setText("Cedula: "+auxiliar.getCliente().getCedula());
	lblNombre.setText("Nombre: "+auxiliar.getCliente().getNombre());
	lblTelefono.setText("Telefono: "+auxiliar.getCliente().getTelefono());
	lblDireccion.setText("Direccion: "+auxiliar.getCliente().getDireccion());
	lblCodigo.setText("Factura #"+auxiliar.getCodigo().subSequence(2, auxiliar.getCodigo().length()));
	modelo.setRowCount(0);
	Object [][]filas=auxiliar.getFilas();
	for(int i = 0;i<auxiliar.getCant();i++) {
		int j =0;
		for(j=0;j<5;j++) {
			fila[j]=filas[i][j];
		}
		
		modelo.addRow(fila);
	}
	DecimalFormat formato1 = new DecimalFormat("#.00");
	lblSubTotal.setText("Sub-Total: "+formato1.format(auxiliar.getPrecioTotal()/1.18f));
	lblImpuestos.setText("ITBIS (18%): "+formato1.format((auxiliar.getPrecioTotal()/1.18f)*0.18f));
	lblTotal.setText("Total: "+formato1.format(auxiliar.getPrecioTotal()));
	}
}	
}
