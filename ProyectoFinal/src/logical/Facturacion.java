package logical;

import java.util.ArrayList;


public class Facturacion {
	private static final long serialVersionUID = -4585348282443559002L;
	private String codigo;
	private float precioTotal;
	private Usuario vendedor;
	private ArrayList<Componente>miscomponentes;
	private ArrayList<Combos>miscombos;
	private Cliente cliente;
	private String tipopago;
	private boolean pagado;
	private Object[][]filas;
	private int cant;
	public Facturacion(String codigo, float precioTotal, Usuario vendedor, 
			 Cliente cliente, boolean pagado) {
		super();
		this.codigo = codigo;
		this.precioTotal = precioTotal;
		this.vendedor = vendedor;
		this.miscomponentes = miscomponentes;
		this.miscombos = miscombos;
		this.cliente = cliente;
		this.tipopago = tipopago;
		this.pagado = pagado;
		this.filas = new Object [100][5];
		this.cant=-1;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getTipopago() {
		return tipopago;
	}
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Usuario getVendedor() {
		return vendedor;
	}
	public void setVendedor(Usuario vendedor) {
		this.vendedor = vendedor;
	}
	public Object[][] getFilas() {
		return filas;
	}
	public void setFilas(Object[][] filas) {
		this.filas = filas;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}

	
	public void agregarfila(int pos,Object[] o) {
		for(int i = 0; i<5;i++) {
			filas[pos][i]=o[i];
		}
		
	}
	public void agregarcombo(Combos c) {
		miscombos.add(c);
	}
	public void agregarcomponente(Componente c) {
		miscomponentes.add(c);
	}


	
	

}
