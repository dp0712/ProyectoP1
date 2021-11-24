package logical;

import java.util.Date;

public class OrdenCompra {

	private String codigo;
	private Date fecha;
	private String estado;
	private int cantidad;
	private Componente compo;
	private float preciouni;
	private Proveedor proveedor;
	private String tipopago;
	public OrdenCompra(String codigo, Date fecha, String estado, int cantidad, Componente compo, float preciouni,
			Proveedor proveedor, String tipopago) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.estado = estado;
		this.cantidad = cantidad;
		this.compo = compo;
		this.preciouni = preciouni;
		this.proveedor = proveedor;
		this.tipopago = tipopago;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Componente getCompo() {
		return compo;
	}
	public void setCompo(Componente compo) {
		this.compo = compo;
	}
	public float getPreciouni() {
		return preciouni;
	}
	public void setPreciouni(float preciouni) {
		this.preciouni = preciouni;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public String getTipopago() {
		return tipopago;
	}
	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

}
