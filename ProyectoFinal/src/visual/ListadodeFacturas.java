package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


import logical.Facturacion;
import logical.Empresa;
import logical.Proveedor;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ListadodeFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private int seleccion = -1;
	private int modelrow = -1;
	public static DefaultTableModel modelo;
	public static Object [] fila;
	private JTextField txtFiltro;
	private Facturacion auxiliar = null;
	private JButton informacionButton;
	private JComboBox cbxFiltro;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param aux 
	 */
	public ListadodeFacturas(ListadodeFacturas aux) {
		setForeground(new Color(0, 100, 0));
		setBackground(UIManager.getColor("Button.focus"));
		setTitle("Listado de Facturas");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 854, 466);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(UIManager.getColor("Button.focus"));
			panel.setBackground(Color.DARK_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 39, 812, 338);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					
					modelo = new DefaultTableModel();
					String columns[] = {"Código","Cliente","Vendedor","Total","Fecha","Cant.Artículos"};
					modelo.setColumnIdentifiers(columns);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							
							seleccion = table.getSelectedRow();
							modelrow = table.convertRowIndexToModel(seleccion);
							if(seleccion!=-1) {
							
								informacionButton.setEnabled(true);
								auxiliar = Empresa.getInstance().enontrarfactura((String)modelo.getValueAt(modelrow, 0));
								
							}else {
								informacionButton.setEnabled(false);
								
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
			{
				JLabel lblNewLabel = new JLabel("Buscador:");
				lblNewLabel.setForeground(Color.WHITE);
				lblNewLabel.setBackground(Color.DARK_GRAY);
				lblNewLabel.setBounds(10, 14, 93, 14);
				panel.add(lblNewLabel);
			}
			{
				txtFiltro = new JTextField();
				txtFiltro.setBackground(Color.WHITE);
				txtFiltro.setForeground(Color.BLACK);
				txtFiltro.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						DefaultTableModel mode = (DefaultTableModel)table.getModel();
						TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
						table.setRowSorter(tr);
						tr.setRowFilter(RowFilter.regexFilter(txtFiltro.getText().trim()));
					}
				});
				txtFiltro.setBounds(115, 11, 176, 20);
				panel.add(txtFiltro);
				txtFiltro.setColumns(10);
			}
			
			JLabel lblNewLabel_1 = new JLabel("Filtro:");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(378, 13, 56, 16);
			panel.add(lblNewLabel_1);
			
			cbxFiltro = new JComboBox();
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarTabla();
					
				}
			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todas>", "Pagadas", "Por Cobrar", "Vencidas"}));
			cbxFiltro.setBounds(446, 10, 117, 21);
			panel.add(cbxFiltro);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				informacionButton = new JButton("Informacion");
				informacionButton.setForeground(Color.BLACK);
				informacionButton.setBackground(UIManager.getColor("Button.focus"));
				informacionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Facturar a = new Facturar(auxiliar);
						a.setVisible(true);
						
					}
				});
				informacionButton.setEnabled(false);
				informacionButton.setActionCommand("OK");
				buttonPane.add(informacionButton);
				getRootPane().setDefaultButton(informacionButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(Color.BLACK);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarTabla();
	}

	private void cargarTabla() {
		
		Object aux=null;
		switch(cbxFiltro.getSelectedIndex()) {
		case 0:
			modelo.setRowCount(0); 
			fila = new Object [modelo.getColumnCount()];
			
			for(Facturacion fact : Empresa.getInstance().getMisfacturas()){
				
					fila[0] = fact.getCodigo();
					fila[1] = fact.getCliente().getNombre();
					fila[2] = fact.getVendedor().getNombre();
					fila[3] = fact.getPrecioTotal();
				//	fila[5] = fact.getComponentes().size()+fact.getCombo().size();
					modelo.addRow(fila);
				}
			break;
		case 1:
			modelo.setRowCount(0); 
			fila = new Object [modelo.getColumnCount()];
			
			for(Facturacion fact : Empresa.getInstance().getMisfacturas()){
			
					fila[0] = fact.getCodigo();
					fila[1] = fact.getCliente().getNombre();
					fila[2] = fact.getVendedor().getNombre();
					fila[3] = fact.getPrecioTotal();
				//	fila[5] = fact.getComponentes().size()+fact.getCombo().size();
					modelo.addRow(fila);
				
			}
			break;
		case 2:
			modelo.setRowCount(0); 
			fila = new Object [modelo.getColumnCount()];
			
			for(Facturacion fact : Empresa.getInstance().getMisfacturas()){
			
					fila[0] = fact.getCodigo();
					fila[1] = fact.getCliente().getNombre();
					fila[2] = fact.getVendedor().getNombre();
					fila[3] = fact.getPrecioTotal();
				//	fila[5] = fact.getComponentes().size()+fact.getCombo().size();
					modelo.addRow(fila);
				
			}
			break;
		case 3:
			
			modelo.setRowCount(0); 
			fila = new Object [modelo.getColumnCount()];
			
			for(Facturacion fact : Empresa.getInstance().getMisfacturas()){
			
					fila[0] = fact.getCodigo();
					fila[1] = fact.getCliente().getNombre();
					fila[2] = fact.getVendedor().getNombre();
					fila[3] = fact.getPrecioTotal();
				//	fila[5] = fact.getComponentes().size()+fact.getCombo().size();
					modelo.addRow(fila);
				
			}
			break;
			
}
	}
}
