package logical;

import java.util.ArrayList;

public class TarjetaMadre extends Componente {
/**
	 * 
	 */
	private static final long serialVersionUID = -6815970787464307667L;
private String marca;
private String modelo;
private String tipoconector;
private String tipomemram;
private ArrayList<String>misconexiones;
public TarjetaMadre(float precio, int cantdispo, String numserie, int cantmin, String marca, String modelo,
		String tipoconector, String tipomemram, ArrayList<String> misconexiones) {
	super(precio, cantdispo, numserie, cantmin);
	this.marca = marca;
	this.modelo = modelo;
	this.tipoconector = tipoconector;
	this.tipomemram = tipomemram;
	this.misconexiones = misconexiones;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getTipoconector() {
	return tipoconector;
}
public void setTipoconector(String tipoconector) {
	this.tipoconector = tipoconector;
}
public String getTipomemram() {
	return tipomemram;
}
public void setTipomemram(String tipomemram) {
	this.tipomemram = tipomemram;
}
public ArrayList<String> getMisconexiones() {
	return misconexiones;
}
public void setMisconexiones(ArrayList<String> misconexiones) {
	this.misconexiones = misconexiones;
}



}
