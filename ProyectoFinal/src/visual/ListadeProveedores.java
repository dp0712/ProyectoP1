package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import logical.Combos;
import logical.Componente;
import logical.DiscoDuro;
import logical.TarjetaMadre;
import logical.Empresa;
import logical.Proveedor;
import logical.MemoriaRam;
import logical.MicroProcesador;


import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class ListadeProveedores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private int seleccion = -1;
	private int modelrow = -1;
	public static DefaultTableModel modelo;
	public static Object [] fila; 
	private JButton informacionButton;
	private JTextField txtFiltro;
	private Proveedor p  = null; 
	private JButton btnPagar;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public ListadeProveedores() {
		setBackground(UIManager.getColor("Button.focus"));
		setForeground(UIManager.getColor("Button.focus"));
		setModal(true);
		setResizable(false);
		setTitle("Listado de  Proveedores");
		setBounds(100, 100, 854, 466);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(218, 165, 32)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(UIManager.getColor("Button.focus"));
			panel.setBackground(UIManager.getColor("Button.focus"));
			panel.setBorder(new LineBorder(new Color(50, 205, 50)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 38, 812, 339);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				{
					
					modelo = new DefaultTableModel();
					String columns [] = {"Código","Nombre","Teléfono","Dirección","Lim.Crédito"};
					modelo.setColumnIdentifiers(columns);
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							seleccion = table.getSelectedRow();
							modelrow = table.convertRowIndexToModel(seleccion);
							if(seleccion!=-1) {
								
								informacionButton.setEnabled(true);
								btnPagar.setEnabled(true);
								p = Empresa.getInstance().listproveedor((String)modelo.getValueAt(modelrow, 0));
								
							}else {
								informacionButton.setEnabled(false);
								btnPagar.setEnabled(false);
								
							}
						}
					});
					
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(modelo);
					scrollPane.setViewportView(table);
				}
			}
			
			JLabel lblNewLabel = new JLabel("Filtro:");
			lblNewLabel.setForeground(SystemColor.textHighlight);
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setBounds(10, 13, 56, 14);
			panel.add(lblNewLabel);
			
			txtFiltro = new JTextField();
			txtFiltro.setForeground(new Color(0, 0, 255));
			txtFiltro.setBackground(UIManager.getColor("Button.focus"));
			txtFiltro.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent arg0) {
					DefaultTableModel mode = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtFiltro.getText().trim()));
				}
			});
			txtFiltro.setBounds(76, 11, 117, 20);
			panel.add(txtFiltro);
			txtFiltro.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setForeground(UIManager.getColor("Button.focus"));
			buttonPane.setBackground(UIManager.getColor("Button.focus"));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				informacionButton = new JButton("Informaci\u00F3n");
				informacionButton.setBackground(UIManager.getColor("Button.focus"));
				informacionButton.setForeground(new Color(0, 0, 255));
				informacionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Combos c = new Combos("Componentes que trae: "+p.getNombre(), "aux");
						for(Componente a : p.getComponentes()) { // no se este error
							c.insertcomponentes(a);
						}
						ListadodeComponentes a = new ListadodeComponentes();
						a.setVisible(true);
						
		
					}
				});
				{
					btnPagar = new JButton("Pagar Deuda");
					btnPagar.setForeground(new Color(127, 255, 0));
					btnPagar.setBackground(UIManager.getColor("Button.focus"));
					btnPagar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							int opcion = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar el pago a este proveedor: "+p.getNombre());
							if(opcion==JOptionPane.OK_OPTION) {
								JOptionPane.showMessageDialog(null, "Pago realizado, gracias.");
							}
						}
					});
					btnPagar.setEnabled(false);
					buttonPane.add(btnPagar);
				}
				informacionButton.setEnabled(false);
				informacionButton.setActionCommand("OK");
				buttonPane.add(informacionButton);
				getRootPane().setDefaultButton(informacionButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(128, 0, 0));
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
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		
		for(Proveedor proveedor : Empresa.getInstance().getMisproveedores()){
			
				fila[0] = proveedor.getRnc();
				fila[1] = proveedor.getNombre();
				fila[2] = proveedor.getTelefono();
				fila[3] = proveedor.getDireccion();
				modelo.addRow(fila);
			}
		
	}
}
