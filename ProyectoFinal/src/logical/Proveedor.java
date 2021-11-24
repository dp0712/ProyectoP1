package logical;

public class Proveedor {
private String nombre;
private String rnc;
private String telefono;
private String direccion;
private String cuentapagar;
public Proveedor(String nombre, String rnc, String telefono, String direccion, String cuentapagar) {
	super();
	this.nombre = nombre;
	this.rnc = rnc;
	this.telefono = telefono;
	this.direccion = direccion;
	this.cuentapagar = cuentapagar;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getRnc() {
	return rnc;
}
public void setRnc(String rnc) {
	this.rnc = rnc;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getCuentapagar() {
	return cuentapagar;
}
public void setCuentapagar(String cuentapagar) {
	this.cuentapagar = cuentapagar;
}

}
