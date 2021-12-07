package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import logical.Componente;
import logical.DiscoDuro;
import logical.MemoriaRam;
import logical.MicroProcesador;
import logical.TarjetaMadre;
import logical.Empresa;
import logical.Proveedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtCredito;
	private JTextField txtDireccion;
	private JTable table;
	private JTable table_1;
	private JButton btnAgregar;
	private static JComboBox cbxFiltro;
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo_1;
	public static Object[] fila;
	private JButton btnQuitar;
	private Componente q = null;
	private static ArrayList<Componente>agregados = new ArrayList<Componente>();
	private static ArrayList<Componente>disponibles = new ArrayList<Componente>();
	private int cont = 0;
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public RegisProveedor() {
		setForeground(Color.DARK_GRAY);
		setBackground(Color.BLACK);
		setModal(true);
		setResizable(false);
		setTitle("Registro Proveedor");
		setBounds(100, 100, 730, 606);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(UIManager.getColor("Button.focus"));
		contentPanel.setBackground(UIManager.getColor("Button.focus"));
		contentPanel.setBorder(new LineBorder(new Color(184, 134, 11)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		for(Componente c: Empresa.getInstance().getMiscomponentes()){
			disponibles.add(c);
		}
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.BLACK);
			panel.setForeground(Color.DARK_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblCodigo = new JLabel("Codigo: ");
			lblCodigo.setForeground(new Color(250, 250, 210));
			lblCodigo.setBounds(12, 13, 116, 16);
			panel.add(lblCodigo);
			
			txtCodigo = new JTextField();
			txtCodigo.setForeground(new Color(0, 0, 255));
			txtCodigo.setBackground(UIManager.getColor("Button.focus"));
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(12, 42, 116, 26);
			panel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre Empresa:");
			lblNombre.setForeground(new Color(250, 250, 210));
			lblNombre.setBackground(UIManager.getColor("Button.focus"));
			lblNombre.setBounds(220, 13, 156, 16);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setForeground(new Color(0, 0, 255));
			txtNombre.setBackground(UIManager.getColor("Button.focus"));
			txtNombre.setBounds(220, 42, 474, 26);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBackground(UIManager.getColor("Button.focus"));
			lblTelefono.setForeground(new Color(250, 250, 210));
			lblTelefono.setBounds(220, 77, 102, 16);
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
			txtTelefono.setBackground(UIManager.getColor("Button.focus"));
			txtTelefono.setForeground(new Color(0, 0, 255));
			txtTelefono.setBounds(220, 114, 474, 26);
			panel.add(txtTelefono);
			txtTelefono.setColumns(10);
			
			JLabel lblCredito = new JLabel("Credito Disponible:");
			lblCredito.setForeground(new Color(250, 250, 210));
			lblCredito.setBackground(UIManager.getColor("Button.focus"));
			lblCredito.setBounds(12, 77, 136, 16);
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
			txtCredito.setBackground(UIManager.getColor("Button.focus"));
			txtCredito.setForeground(new Color(0, 0, 255));
			txtCredito.setBounds(12, 114, 116, 26);
			panel.add(txtCredito);
			txtCredito.setColumns(10);
			
			JLabel lblDireccion = new JLabel("Direccion:");
			lblDireccion.setForeground(new Color(250, 250, 210));
			lblDireccion.setBackground(UIManager.getColor("Button.focus"));
			lblDireccion.setBounds(12, 149, 116, 16);
			panel.add(lblDireccion);
			
			txtDireccion = new JTextField();
			txtDireccion.setForeground(new Color(0, 0, 255));
			txtDireccion.setBackground(UIManager.getColor("Button.focus"));
			txtDireccion.setBounds(12, 178, 682, 26);
			panel.add(txtDireccion);
			txtDireccion.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setForeground(new Color(128, 0, 0));
			panel_1.setBackground(UIManager.getColor("Button.focus"));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Disponibles", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_1.setBounds(12, 296, 297, 197);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String []columns = {"Codigo","Tipo","Marca","Modelo"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					table_1.clearSelection();
					int seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						btnAgregar.setEnabled(true);
						btnQuitar.setEnabled(false);
						
						q = disponibles.get(seleccion);
					}else{
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(false);
						q = null;
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			btnAgregar = new JButton("");
			btnAgregar.setForeground(UIManager.getColor("Button.focus"));
			btnAgregar.setBackground(UIManager.getColor("Button.focus"));
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cont++;
					disponibles.remove(q);
					agregados.add(q);
					CargarTabla();
					CargarTablaVendidos();
					btnAgregar.setEnabled(false);
					q=null;
					if(cont>0) {
						okButton.setEnabled(true);
					}else {
						okButton.setEnabled(false);
					}
				}
			});
			btnAgregar.setEnabled(false);
			btnAgregar.setBounds(319, 329, 68, 25);
			panel.add(btnAgregar);
			
			btnQuitar = new JButton("");
			btnQuitar.setBackground(UIManager.getColor("Button.focus"));
			btnQuitar.setForeground(UIManager.getColor("Button.focus"));
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cont--;
					agregados.remove(q);
					disponibles.add(q);
					CargarTabla();
					CargarTablaVendidos();
					q=null;
					if(cont>0) {
						okButton.setEnabled(true);
					}else {
						okButton.setEnabled(false);
					}
				}			
			});
			btnQuitar.setEnabled(false);
			btnQuitar.setBounds(319, 435, 68, 25);
			panel.add(btnQuitar);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(UIManager.getColor("Button.focus"));
			panel_2.setForeground(new Color(128, 0, 0));
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregados", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(184, 134, 11)));
			panel_2.setBounds(397, 296, 297, 197);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			modelo_1 = new DefaultTableModel();
			String []columns2 = {"Codigo","Tipo","Marca","Modelo"};
			modelo_1.setColumnIdentifiers(columns2);
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					table.clearSelection();
					int seleccion = table_1.getSelectedRow();
					int modelrow = table_1.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(true);
						
						q = agregados.get(seleccion);
					}else{
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(false);
						q = null;
					}
				}
			});
			table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table_1.setModel(modelo_1);
			scrollPane_1.setViewportView(table_1);
			
			JLabel lblFiltro = new JLabel("Filtro:");
			lblFiltro.setBackground(UIManager.getColor("Button.focus"));
			lblFiltro.setForeground(new Color(250, 250, 210));
			lblFiltro.setBounds(12, 220, 83, 16);
			panel.add(lblFiltro);
			
			cbxFiltro = new JComboBox();
			cbxFiltro.setBackground(UIManager.getColor("Button.focus"));
			cbxFiltro.setForeground(new Color(0, 0, 255));
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CargarTabla();
					CargarTablaVendidos();
				}
			});
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Discos Duros", "Memorias Ram", "TarjetaMadre", "MicroProcesador"}));
			cbxFiltro.setBounds(12, 249, 212, 26);
			panel.add(cbxFiltro);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setBorder(new LineBorder(new Color(184, 134, 11)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("Registrar");
				okButton.setForeground(new Color(0, 255, 0));
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//if(!(txtNombre.getText().isEmpty()) && ) {
						Proveedor p = new Proveedor(txtNombre.getText(),txtCodigo.getText()
								,txtTelefono.getText(),txtDireccion.getText(),
								Float.parseFloat(txtCredito.getText()));
					
						for(Componente c : agregados) {
							p.insertarcomponentes(c);
						}
						JOptionPane.showMessageDialog(null, "Se ha registrado correctamente el proveedor");
						clear();
					//}
					}

				});
				okButton.setEnabled(false);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(new Color(255, 0, 0));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						disponibles.removeAll(disponibles);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		CargarTabla();
		CargarTablaVendidos();
	}
	
	private void CargarTabla() {
		switch(cbxFiltro.getSelectedIndex()) {
		case 0:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				fila[0]=c.getNumserie();
				if(c instanceof DiscoDuro) {
					fila[1]="Disco Duro";
				}
				if(c instanceof MemoriaRam) {
					fila[1]="Memoria Ram";
				}
				if(c instanceof MicroProcesador) {
					fila[1]="Microprocesador";
				}
				if(c instanceof TarjetaMadre) {
					fila[1]="TarjetaMadre";
				}
				modelo.addRow(fila);
			}
			break;
		case 1:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof DiscoDuro) {
					fila[0]=c.getNumserie();
					fila[1]="Disco Duro";
					modelo.addRow(fila);
				}
			}
			break;
		case 2:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof MemoriaRam) {
					fila[0]=c.getNumserie();
					fila[1]="Memoria Ram";
					modelo.addRow(fila);
				}
			}
			break;
		case 3:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof MicroProcesador) {
					fila[0]=c.getNumserie();
					fila[1]="Microprocesador";
					modelo.addRow(fila);
				}
			}
			break;
		case 4:
			modelo.setRowCount(0);
			fila = new Object[modelo.getColumnCount()];
			for(Componente c: disponibles) {
				if(c instanceof TarjetaMadre) {
					fila[0]=c.getNumserie();
					fila[1]="TarjetaMadre";
					modelo.addRow(fila);
				}
			}
			break;
		}
		
	}
	
	
	private void CargarTablaVendidos() {
		switch(cbxFiltro.getSelectedIndex()) {
		case 0:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				fila[0]=c.getNumserie();
				if(c instanceof DiscoDuro) {
					fila[1]="Disco Duro";
				}
				if(c instanceof MemoriaRam) {
					fila[1]="Memoria Ram";
				}
				if(c instanceof MicroProcesador) {
					fila[1]="Microprocesador";
				}
				if(c instanceof TarjetaMadre) {
					fila[1]="TarjetaMadre";
				}
				modelo_1.addRow(fila);
			}
			break;
		case 1:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof DiscoDuro) {
					fila[0]=c.getNumserie();
					fila[1]="Disco Duro";
					modelo_1.addRow(fila);
				}
			}
			break;
		case 2:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof MemoriaRam) {
					fila[0]=c.getNumserie();
					fila[1]="Memoria Ram";
					modelo_1.addRow(fila);
				}
			}
			break;
		case 3:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof MicroProcesador) {
					fila[0]=c.getNumserie();
					fila[1]="Microprocesador";
					modelo_1.addRow(fila);
				}
			}
			break;
		case 4:
			modelo_1.setRowCount(0);
			fila = new Object[modelo_1.getColumnCount()];
			for(Componente c: agregados) {
				if(c instanceof TarjetaMadre) {
					fila[0]=c.getNumserie();
					fila[1]="TarjetaMadre";
					modelo_1.addRow(fila);
				}
			}
			break;
		}
		
	}
	
	private void clear() {
		txtNombre.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCredito.setText("");
		modelo.setRowCount(0);
		modelo_1.setRowCount(0);
		disponibles.removeAll(disponibles);
		for(Componente c : Empresa.getInstance().getMiscomponentes()) {
			disponibles.add(c);
		}
		agregados.removeAll(agregados);
		
		CargarTabla();
		CargarTablaVendidos();
	}
	
}
