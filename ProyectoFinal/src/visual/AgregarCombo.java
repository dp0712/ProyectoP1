package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logical.Combos;
import logical.Componente;
import logical.DiscoDuro;
import logical.MemoriaRam;
import logical.MicroProcesador;
import logical.TarjetaMadre;
import logical.Empresa;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;

public class AgregarCombo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	public static DefaultTableModel modelo;
	public static DefaultTableModel modelo_1;
	public static Object[] fila;
	//private int [] saber = new int[4];
	private Componente q = null;
	private int cont = 0;
	private int contador = 0;
	private JTable table;
	private JTable table_1;
	private JButton btnQuitar;
	private JButton btnAgregar;
	
	private ArrayList<Componente>agregados = new ArrayList<Componente>();
	private JButton registrarButton;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JComboBox cbxFiltro;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public AgregarCombo() {
		setBackground(Color.DARK_GRAY);
		setForeground(new Color(70, 130, 180));
		setModal(true);
		setResizable(false);
		setTitle("Registro de combo");
		setBounds(100, 100, 631, 446);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(new Color(0, 128, 128));
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setForeground(Color.WHITE);
			panel.setBackground(Color.DARK_GRAY);
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registrar Combo", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.DARK_GRAY);
			panel_1.setForeground(new Color(0, 128, 128));
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Disponibles", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			panel_1.setBounds(10, 96, 248, 234);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			modelo = new DefaultTableModel();
			String columns[] = {"Serie","Marca","Modelo","Precio"};
			modelo.setColumnIdentifiers(columns);
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					table_1.clearSelection();
					int seleccion = table.getSelectedRow();
					int modelrow = table.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						btnAgregar.setEnabled(true);
						btnQuitar.setEnabled(false);
						
						q = Empresa.getInstance().buscarelomponente((String)modelo.getValueAt(modelrow, 0));

					}else{
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(false);
						q = null;
					}
				}			
			});
			
			table.setModel(modelo);
			scrollPane.setViewportView(table);
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(new Color(0, 128, 128));
			panel_2.setBackground(Color.DARK_GRAY);
			panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agregados", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			panel_2.setBounds(336, 96, 248, 234);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_2.add(scrollPane_1, BorderLayout.CENTER);
			
			modelo_1 = new DefaultTableModel();
			String []columns2 = {"Serie","Marca","Modelo","Precio"};
			modelo_1.setColumnIdentifiers(columns2);
			table_1 = new JTable();
			table_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					table.clearSelection();
					int seleccion = table_1.getSelectedRow();
					int modelrow = table_1.convertRowIndexToModel(seleccion);
					if(seleccion!=-1){
						btnAgregar.setEnabled(false);
						btnQuitar.setEnabled(true);
						
						q = Empresa.getInstance().buscarelomponente((String)modelo.getValueAt(modelrow, 0));
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
			
			btnAgregar = new JButton("Add");
			btnAgregar.setBackground(UIManager.getColor("Button.focus"));
			btnAgregar.setForeground(Color.WHITE);
			btnAgregar.setEnabled(false);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					agregados.add(q);
					cont++;
					/*
					if(q instanceof Disco) {
						saber[0] = 1;
					}
					if(q instanceof MotherBoard) {
						saber[1] = 1;
					}
					if(q instanceof Microprocesadores) {
						saber[2] = 1;
					}
					if(q instanceof MemoriaRam){
						//Memoria ram
						saber[3] = 1;
					}
					*/
					CargarTablaAgregados();
					//cargarTablaExceptuando();
					btnAgregar.setEnabled(false);
					if(cont>=2) {
						registrarButton.setEnabled(true);
					}else {
						registrarButton.setEnabled(false);
					}
					q = null;
					
				}



				
			});
			btnAgregar.setBounds(268, 147, 58, 23);
			panel.add(btnAgregar);
			
			btnQuitar = new JButton("Del");
			btnQuitar.setForeground(Color.WHITE);
			btnQuitar.setBackground(UIManager.getColor("Button.focus"));
			btnQuitar.setEnabled(false);
			btnQuitar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					cont--;
					agregados.remove(q);
					/*
					if(q instanceof Disco) {
						saber[0] = 0;
					}
					if(q instanceof MotherBoard) {
						saber[1]= 0;
					}
					if(q instanceof Microprocesadores) {
						saber[2]= 0;
					}
					if(q instanceof MemoriaRam){
						//Memoria ram
						saber[3]= 0;
					}
					*/
					//cargarTablaExceptuando();
					CargarTablaAgregados();
					
					btnQuitar.setEnabled(false);
					if(cont>=2) {
						registrarButton.setEnabled(true);
					}else {
						registrarButton.setEnabled(false);
					}
					q = null;
				}
			});
			btnQuitar.setBounds(268, 249, 58, 23);
			panel.add(btnQuitar);
			
			JLabel lblNewLabel = new JLabel("Filtro");
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(10, 71, 88, 14);
			panel.add(lblNewLabel);
			
			cbxFiltro = new JComboBox();
			cbxFiltro.setModel(new DefaultComboBoxModel(new String[] {"<Todos>", "Disco Duro", "Memoria Ram", "Microprocesadores", "Motherboard"}));
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					loadTable(cbxFiltro.getSelectedIndex());
				}

				private void loadTable(int seleccionado) {
					
					
					modelo.setRowCount(0);
					
					fila = new Object[modelo.getColumnCount()];
					
					if(seleccionado == 0) {
						cargarTabla();
					}
					
					if(seleccionado == 1) {
						for (Componente comp : Empresa.getInstance().getMiscomponentes()) {
							
							if(comp instanceof DiscoDuro) {
							
								fila[0] = comp.getNumserie();	
								fila[1] = ((DiscoDuro) comp).getMarca();
								fila[2] = ((DiscoDuro) comp).getModelo();
								fila[3] = comp.getPrecio();
							/*	
							fila[0] = comp.getSerie();
							fila[1] = "Disco Duro";
							fila[2] = comp.getCantReal();
							fila[3] = comp.getPrecioVenta();
							fila[4] = comp.getModelo();
							fila[5] = comp.getMarca();
							*/
							modelo.addRow(fila);
						}
						}
					}else if(seleccionado == 2) {
						for (Componente comp : Empresa.getInstance().getMiscomponentes()) {
							if(comp instanceof MemoriaRam) {
								
								fila[0] = comp.getNumserie();	
								fila[1] = ((MemoriaRam) comp).getMarca();
								fila[2] = ((MemoriaRam) comp).getModelo();
								fila[3] = comp.getPrecio();
								/*
								fila[0] = comp.getSerie();
								fila[1] = "Memoria Ram";	
								fila[2] = comp.getCantReal();
								fila[3] = comp.getPrecioVenta();
								fila[4] = comp.getModelo();
								fila[5] = comp.getMarca();
								*/
								modelo.addRow(fila);
								
							}
						}
					}
					else if(seleccionado == 3) {
						for (Componente comp : Empresa.getInstance().getMiscomponentes()) {
							if(comp instanceof MicroProcesador){
								fila[0] = comp.getNumserie();	
								fila[1] = ((MicroProcesador) comp).getMarca();
								fila[2] = ((MicroProcesador) comp).getModelo();
								fila[3] = comp.getPrecio();
								/*
							fila[0] = comp.getSerie();							
							fila[1] = "Microprocesador";							
							fila[2] = comp.getCantReal();
							fila[3] = comp.getPrecioVenta();
							fila[4] = comp.getModelo();
							fila[5] = comp.getMarca();
							*/
							modelo.addRow(fila);
							}
						}
					}
					else if(seleccionado == 4) {
						for (Componente comp : Empresa.getInstance().getMiscomponentes()) {
							if(comp instanceof TarjetaMadre) {
								
								fila[0] = comp.getNumserie();	
								fila[1] = ((TarjetaMadre) comp).getMarca();
								fila[2] = ((TarjetaMadre) comp).getModelo();
								fila[3] = comp.getPrecio();
								/*
								fila[0] = comp.getSerie();
								
								fila[1] = "MotherBoard";
								
								fila[2] = comp.getCantReal();
								fila[3] = comp.getPrecioVenta();
								fila[4] = comp.getModelo();
								fila[5] = comp.getMarca();
								*/
								modelo.addRow(fila);
							}
						}
					}
					/*
					else if(seleccionado == 5 ) {
						for(Combo c : Prodacom.getInstance().getCombos()) {
							fila[0] = c.getCod();
							fila[1] = "Combo";
							fila[2] = "Hasta Agotar Existencias";
							fila[3] = c.calcularprecio();
							fila[4] = c.getNombre();
							fila[5] = "Unbranded";
							modelo.addRow(fila);
						}
					}
					*/
				}
			});
			cbxFiltro.setForeground(Color.BLACK);
			cbxFiltro.setBackground(UIManager.getColor("Button.focus"));
			cbxFiltro.setBounds(108, 68, 150, 20);
			panel.add(cbxFiltro);
			
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBackground(UIManager.getColor("Button.focus"));
			lblNombre.setForeground(Color.WHITE);
			lblNombre.setBounds(10, 21, 90, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setForeground(new Color(0, 0, 255));
			txtNombre.setBackground(Color.LIGHT_GRAY);
			txtNombre.setBounds(108, 18, 150, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblCod = new JLabel("C\u00F3digo:");
			lblCod.setForeground(Color.WHITE);
			lblCod.setBackground(UIManager.getColor("Button.focus"));
			lblCod.setBounds(336, 21, 90, 14);
			panel.add(lblCod);
			
			txtCodigo = new JTextField();
			txtCodigo.setBackground(Color.LIGHT_GRAY);
			txtCodigo.setForeground(Color.WHITE);
			txtCodigo.setEditable(false);
			txtCodigo.setColumns(10);
			txtCodigo.setText("C-"+Empresa.getInstance().getMiscombos()+1);
			txtCodigo.setBounds(436, 18, 141, 20);
			panel.add(txtCodigo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(new Color(0, 128, 128));
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				registrarButton = new JButton("Registrar");
				registrarButton.setBackground(UIManager.getColor("Button.focus"));
				registrarButton.setForeground(Color.BLACK);
				registrarButton.setEnabled(false);
				registrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(!txtNombre.getText().isEmpty()) {
						Combos aux  =  new Combos(txtNombre.getText(), txtCodigo.getText());
						
						for(Componente c : agregados) {
							aux.insertcomponentes(c);
						}
						Empresa.getInstance().addcombo(aux);
						clear();
						registrarButton.setEnabled(false);
						//saber = new int[4];
						contador  =0;
						JOptionPane.showMessageDialog(null, "El combo ha sido registrado exitosamente.");
						
					}else {
						JOptionPane.showMessageDialog(null, "Debe ponerle un nombre al combo","Error",JOptionPane.ERROR_MESSAGE);
					}
					}
				});
				registrarButton.setActionCommand("OK");
				buttonPane.add(registrarButton);
				getRootPane().setDefaultButton(registrarButton);
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

		if(contador==0) {
		cargarTabla();
		}
		contador++;
	}
	
	private void CargarTablaAgregados() {
		modelo_1.setRowCount(0);
		fila = new Object[modelo_1.getColumnCount()];
		for(Componente comp:agregados ) {
			fila[0] = comp.getNumserie();
			fila[1] = comp.getCantdispo();
			fila[3] = comp.getPrecio();
			modelo_1.addRow(fila);
		}
		
	}
	
	private void cargarTabla() {
		modelo.setRowCount(0); 
		fila = new Object [modelo.getColumnCount()];
		
		for(Componente comp : Empresa.getInstance().getMiscomponentes()){
			fila[0] = comp.getNumserie();
			fila[1] = comp.getCantdispo();
			fila[3] = comp.getPrecio();
			
			modelo.addRow(fila);
		
	}
}
	private void clear() {
		txtCodigo.setText("C-"+Empresa.getInstance().getMiscombos());
		txtNombre.setText("");
		
		agregados.removeAll(agregados);
		cargarTabla();
		modelo_1.setRowCount(0);
		
	}

}