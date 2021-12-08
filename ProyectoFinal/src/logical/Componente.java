package logical;

import java.io.Serializable;

public abstract class Componente implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = -3315547514223460540L;
protected float precio;
protected int cantdispo;
protected String numserie;
protected int cantmin;
public Componente(float precio, int cantdispo, String numserie, int cantmin) {
	super();
	this.precio = precio;
	this.cantdispo = cantdispo;
	this.numserie = numserie;
	this.cantmin = cantmin;
}
public float getPrecio() {
	return precio;
}
public void setPrecio(float precio) {
	this.precio = precio;
}
public int getCantdispo() {
	return cantdispo;
}
public void setCantdispo(int cantdispo) {
	this.cantdispo = cantdispo;
}
public String getNumserie() {
	return numserie;
}
public void setNumserie(String numserie) {
	this.numserie = numserie;
}
public int getCantmin() {
	return cantmin;
}
public void setCantmin(int cantmin) {
	this.cantmin = cantmin;
}
/*
public static Componente componente = null;
public static Componente getInstance() {
	if(componente == null) {
		componente = new Componente(); //no entiendo por que da error
	}
	return componente;
}
*/
public static Componente getInstance() {
	// TODO Auto-generated method stub
	return null;
}
}

