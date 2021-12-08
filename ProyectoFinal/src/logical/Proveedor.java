package logical;

import java.io.Serializable;
import java.util.ArrayList;



public class Proveedor implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -2616534400308281274L;
private String nombre;
private String rnc;
private String telefono;
private String direccion;
private float cuentapagar;
private ArrayList<Componente>miscomponentes;

public Proveedor(String nombre, String rnc, String telefono, String direccion, float f) {
	super();
	this.nombre = nombre;
	this.rnc = rnc;
	this.telefono = telefono;
	this.direccion = direccion;
	this.cuentapagar = f;
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
public float getCuentapagar() {
	return cuentapagar;
}
public void setCuentapagar(float cuentapagar) {
	this.cuentapagar = cuentapagar;
}
public void insertarcomponentes(Componente c) {
	miscomponentes.add(c);
}

}
