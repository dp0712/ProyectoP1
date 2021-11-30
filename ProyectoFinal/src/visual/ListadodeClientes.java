package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logical.Cliente;
import logical.Usuario;
import logical.Empresa;


import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class ListadodeClientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnBuscar;
	private JTextField txtBusqueda;
	private JTable table;
	public static DefaultTableModel modelo;
	public static Object[] fila;
	private static Cliente aux = null;
	private JButton btnCrear;
	private JButton btnSeleccionar;
	private int boton = 1;
	public static int cantidad=0;
	private int mode = -1;
	private JButton btnPagar;
	/**
	 * Launch the application.
	 */
	
	

	/**
	 * Create the dialog.
	 */
	public ListadodeClientes(int b ) {
		this.mode=b;
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setTitle("Listado de Clientes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 622, 413);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(184, 134, 11)));
			panel.setBackground(Color.DARK_GRAY);
			panel.setForeground(UIManager.getColor("Button.focus"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new LineBorder(new Color(184, 134, 11)));
				panel_1.setForeground(UIManager.getColor("Button.focus"));
				panel_1.setBackground(Color.DARK_GRAY);
				panel_1.setBounds(0, 0, 594, 47);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					btnBuscar = new JButton("Buscar");
					btnBuscar.setForeground(Color.BLACK);
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(boton==1) {
								boton=0;
								txtBusqueda.setVisible(true);
								btnBuscar.setText("");							
							}else {
								boton=1;
								txtBusqueda.setVisible(false);
								txtBusqueda.setText("");
								btnBuscar.setText("Buscar");
							}
						}
					});
					btnBuscar.setBackground(UIManager.getColor("Button.focus"));
					btnBuscar.setBounds(396, 4, 65, 32);
					panel_1.add(btnBuscar);
				}
				{
					txtBusqueda = new JTextField();
					txtBusqueda.setForeground(UIManager.getColor("Button.focus"));
					txtBusqueda.setBackground(Color.WHITE);
					txtBusqueda.addKeyListener(new KeyAdapter() {
						@Override
						public void keyPressed(KeyEvent e) {
							DefaultTableModel mode = (DefaultTableModel)table.getModel();
							TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
							table.setRowSorter(tr);
							tr.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText().trim()));
						}
					});
					txtBusqueda.setBounds(10, 5, 368, 30);
					panel_1.add(txtBusqueda);
					txtBusqueda.setColumns(10);
					txtBusqueda.setVisible(false);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 49, 594, 259);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						modelo = new DefaultTableModel();
						String[] columns = {"Cedula","Nombre","Telefono","Direccion","Deuda"}; 
						modelo.setColumnIdentifiers(columns);
						table = new JTable();
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int seleccion = table.getSelectedRow();
								int modelrow = table.convertRowIndexToModel(seleccion);
								if(mode==0) {
								if(seleccion!=-1){
									btnSeleccionar.setEnabled(true);
									btnCrear.setEnabled(false);
									btnPagar.setEnabled(true);
									aux = Empresa.getInstance().buscarcliente((String)modelo.getValueAt(modelrow, 0));
									
									
								}else{	
									btnSeleccionar.setEnabled(false);
									btnPagar.setEnabled(false);
									btnCrear.setEnabled(true);
									}
								}else {
									btnSeleccionar.setEnabled(false);
									btnCrear.setEnabled(false);
									btnPagar.setEnabled(true);
								}
							}
						});
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						table.setModel(modelo);
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCrear = new JButton("Cliente Nuevo");
				if(mode==0) {
					btnCrear.setVisible(true);
				
				}else {
					btnCrear.setVisible(false);
					
				}
				btnCrear.setBackground(UIManager.getColor("Button.focus"));
				btnCrear.setForeground(Color.BLACK);
				btnCrear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						RegisCliente a = new RegisCliente();
						a.setVisible(true);
						
					}
				});
				{
					btnPagar = new JButton("Pagar Deuda");
					btnPagar.setEnabled(false);
					if(mode==0) {
						btnPagar.setVisible(false);
					
					}else {
						btnPagar.setVisible(true);
						
					}
					btnPagar.setForeground(Color.BLACK);
					btnPagar.setBackground(UIManager.getColor("Button.focus"));
					btnPagar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea realizar el pago total de sus facturas");
							if(opcion==JOptionPane.OK_OPTION) {
								Empresa.getInstance().PagarDeudaCliente(aux);
								JOptionPane.showMessageDialog(null, "Pago realizado");
								CargarTabla();
							}else {
								CargarTabla();
							}
							
						}
					});
					buttonPane.add(btnPagar);
				}
				buttonPane.add(btnCrear);
			}
			{
				btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.setBackground(UIManager.getColor("Button.focus"));
				btnSeleccionar.setForeground(Color.BLACK);
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Facturar.CargarCliente(aux);
						dispose();
					}
				});
				btnSeleccionar.setEnabled(false);
				btnSeleccionar.setActionCommand("OK");
				buttonPane.add(btnSeleccionar);
				getRootPane().setDefaultButton(btnSeleccionar);
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
		CargarTabla();
	}






	private void CargarTabla() {
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];
		for(Cliente p : Empresa.getInstance().getMisclientes()){
			if(p instanceof Cliente) {
			Cliente c = (Cliente)p;	
			fila[0]=c.getCedula();
			fila[1]=c.getNombre();
			fila[2]=c.getTelefono();
			fila[3]=c.getDireccion();
			fila[4]=c.getCredito()-Empresa.getInstance().CreditCliente(c);
			modelo.addRow(fila);
		}
		
	}
	}

}
