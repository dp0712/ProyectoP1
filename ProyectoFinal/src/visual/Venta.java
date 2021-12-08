package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import logical.Combos;
import logical.Componente;
import logical.Empresa;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

public class Venta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private int disponibles = 1;
	private String nombre ="";
	private float precio = 0.0f;
	private JSpinner spnCantidad;
	private JSpinner spnDescuento;
	private float subtotal = 0.0f;
	private String codigo = "";
	public static Object[] fila = new Object [5];
	private JLabel lblPrecio;
	private JLabel lblSubTotal;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 * @param i 
	 * @param f 
	 */
	public Venta(String cod, float f, int i) {
		setForeground(UIManager.getColor("Button.focus"));
		setBackground(UIManager.getColor("Button.focus"));
		this.disponibles=i;
		this.nombre=toString();
		this.precio=f;
		this.codigo = cod;
		setTitle("Add Articulo");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 388, 388);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setForeground(Color.DARK_GRAY);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre:");
			lblNewLabel.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setBounds(12, 13, 59, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Precio:");
			lblNewLabel_2.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(12, 101, 73, 16);
			contentPanel.add(lblNewLabel_2);
		}
		{
			lblPrecio = new JLabel(""+precio);
			lblPrecio.setForeground(Color.WHITE);
			lblPrecio.setBackground(UIManager.getColor("Button.focus"));
			lblPrecio.setBounds(12, 130, 346, 31);
			contentPanel.add(lblPrecio);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Cantidad:");
			lblNewLabel_1.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(12, 174, 101, 16);
			contentPanel.add(lblNewLabel_1);
		}
		
		spnCantidad = new JSpinner();
		spnCantidad.setForeground(new Color(128, 0, 0));
		spnCantidad.setBackground(UIManager.getColor("Button.focus"));
		spnCantidad.addChangeListener(new ChangeListener() {
			  @Override
			  public void stateChanged(ChangeEvent e) {
			   subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
			   float desc = Integer.parseInt(spnDescuento.getValue().toString())/100.0f;
			   subtotal = subtotal-(subtotal*desc);
			   lblSubTotal.setText("SubTotal: "+subtotal);
			  }
			});
		spnCantidad.setModel(new SpinnerNumberModel(1, 1, disponibles, 1));
		spnCantidad.setBounds(12, 208, 101, 22);
		contentPanel.add(spnCantidad);
		{
			JLabel lblNewLabel_3 = new JLabel("Descuento:");
			lblNewLabel_3.setBackground(UIManager.getColor("Button.focus"));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(250, 174, 100, 16);
			contentPanel.add(lblNewLabel_3);
		}
		{
			spnDescuento = new JSpinner();
			spnDescuento.setBackground(UIManager.getColor("Button.focus"));
			spnDescuento.setForeground(new Color(128, 0, 0));
			spnDescuento.addChangeListener(new ChangeListener() {
				  @Override
				  public void stateChanged(ChangeEvent e) {
				   subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
				   float desc = Integer.parseInt(spnDescuento.getValue().toString())/100.0f;
				   subtotal = subtotal-(subtotal*desc);
				   lblSubTotal.setText("SubTotal: "+subtotal);
				  }
				});
			spnDescuento.setModel(new SpinnerNumberModel(0, 0, 10, 1));
			spnDescuento.setBounds(249, 208, 101, 22);
			contentPanel.add(spnDescuento);
		}
		{
			subtotal = (precio*Integer.parseInt(spnCantidad.getValue().toString()));
			lblSubTotal = new JLabel("SubTotal: "+(subtotal-(subtotal*(Integer.parseInt(spnDescuento.getValue().toString())/100.0f))));
			lblSubTotal.setForeground(Color.WHITE);
			lblSubTotal.setBackground(UIManager.getColor("Button.focus"));
			lblSubTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblSubTotal.setBounds(12, 254, 222, 31);
			contentPanel.add(lblSubTotal);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.DARK_GRAY);
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.setBackground(UIManager.getColor("Button.focus"));
				okButton.setForeground(Color.BLACK);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if('C'==codigo.charAt(0)) {
							Combos c = Empresa.getInstance().buscarelcombo(codigo);
							if(Empresa.getInstance().reviCombo(c)) {
								fila[0]=codigo;
								fila[1]=nombre;
								fila[2]=Integer.parseInt(spnCantidad.getValue().toString());
								fila[3]=precio;
								fila[4]=subtotal;
								Empresa.getInstance().clienteCombo(c);
								dispose();
								Facturar.CargarTabla(fila);
							}else {
								JOptionPane.showMessageDialog(null, "No hay suficientes componentes para vender este combo "+c.getNombre()
							, "Error", JOptionPane.WARNING_MESSAGE);
								dispose();
								ListadodeComponentes a = new ListadodeComponentes();
								a.setVisible(true);
							}
					
					}else {
						Componente c = Empresa.getInstance().buscarelomponente(codigo);
						fila[0]=codigo;
						fila[1]=nombre;
						fila[2]=Integer.parseInt(spnCantidad.getValue().toString());
						fila[3]=precio;
						fila[4]=subtotal;
						int cantidad = Integer.parseInt(spnCantidad.getValue().toString());
						for(int i = 0;i<cantidad;i++) {
		// error, no toma la instancia					Empresa.getInstance().clienteCombo(c);
						}
						dispose();
						Facturar.CargarTabla(fila);
					}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBackground(UIManager.getColor("Button.focus"));
				cancelButton.setForeground(Color.BLACK);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
