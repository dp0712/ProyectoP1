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
	}


}
