package logical;

public class Cliente {

private String nombre;
private String direccion;
private String telefono;
private String rnc;
private String cedula;
private float LimitCredi;
private float cuentascobra;
public Cliente(String nombre, String direccion, String telefono, String rnc, String cedula, float limitCredi,
		float cuentascobra) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.rnc = rnc;
	this.cedula = cedula;
	LimitCredi = limitCredi;
	this.cuentascobra = cuentascobra;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getRnc() {
	return rnc;
}
public void setRnc(String rnc) {
	this.rnc = rnc;
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public float getLimitCredi() {
	return LimitCredi;
}
public void setLimitCredi(float limitCredi) {
	LimitCredi = limitCredi;
}
public float getCuentascobra() {
	return cuentascobra;
}
public void setCuentascobra(float cuentascobra) {
	this.cuentascobra = cuentascobra;
}


}
