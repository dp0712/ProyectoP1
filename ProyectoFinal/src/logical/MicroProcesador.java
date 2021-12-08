package logical;

public class MicroProcesador extends Componente {
/**
	 * 
	 */
	private static final long serialVersionUID = -1243300301321247577L;
private String marca;
private String modelo;
private String tipoconector;
private float veloprocesamiento;
public MicroProcesador(float precio, int cantdispo, String numserie, int cantmin, String marca, String modelo,
		String tipoconector, float veloprocesamiento) {
	super(precio, cantdispo, numserie, cantmin);
	this.marca = marca;
	this.modelo = modelo;
	this.tipoconector = tipoconector;
	this.veloprocesamiento = veloprocesamiento;
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
public float getVeloprocesamiento() {
	return veloprocesamiento;
}
public void setVeloprocesamiento(float veloprocesamiento) {
	this.veloprocesamiento = veloprocesamiento;
}
}
