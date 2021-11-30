package logical;

public abstract class Componente {
protected float precio;
protected int cantdispo;
protected int numserie;
protected int cantmin;
public Componente(float precio, int cantdispo, int numserie, int cantmin) {
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
public int getNumserie() {
	return numserie;
}
public void setNumserie(int numserie) {
	this.numserie = numserie;
}
public int getCantmin() {
	return cantmin;
}
public void setCantmin(int cantmin) {
	this.cantmin = cantmin;
}
public static Componente componente = null;
public static Componente getInstance() {
	if(componente == null) {
		componente = new Componente(); //no entiendo por que da error
	}
	return componente;
}
}
