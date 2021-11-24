package logical;

public class DiscoDuro extends Componente {
private String marca;
private String modelo;
private float cantalmacenamiento;
private String tipocone;
public DiscoDuro(float precio, int cantdispo, int numserie, int cantmin, String marca, String modelo,
		float cantalmacenamiento, String tipocone) {
	super(precio, cantdispo, numserie, cantmin);
	this.marca = marca;
	this.modelo = modelo;
	this.cantalmacenamiento = cantalmacenamiento;
	this.tipocone = tipocone;
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
public float getCantalmacenamiento() {
	return cantalmacenamiento;
}
public void setCantalmacenamiento(float cantalmacenamiento) {
	this.cantalmacenamiento = cantalmacenamiento;
}
public String getTipocone() {
	return tipocone;
}
public void setTipocone(String tipocone) {
	this.tipocone = tipocone;
}
	

}
