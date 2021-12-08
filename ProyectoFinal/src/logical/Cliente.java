package logical;

import java.io.Serializable;

public class Cliente implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5085673782232108609L;
private String nombre;
private String direccion;
private String telefono;
private String rnc;
private String cedula;
private float cuentascobra;
public Cliente(String nombre, String direccion, String telefono, String cedula) {
	super();
	this.nombre = nombre;
	this.direccion = direccion;
	this.telefono = telefono;
	this.cedula= cedula;
	this.cuentascobra =0;
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

public float getCuentascobra() {
	return cuentascobra;
}
public void setCuentascobra(float cuentascobra) {
	this.cuentascobra = cuentascobra;
}


}
