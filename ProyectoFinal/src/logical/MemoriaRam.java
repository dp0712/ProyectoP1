package logical;

public class MemoriaRam extends Componente{

	private String marca;
	private String modelo;
	private float cantialmac;
	private String tipocone;
	public MemoriaRam(float precio, int cantdispo, String numserie, int cantmin, String marca, String modelo,
			float cantialmac, String tipocone) {
		super(precio, cantdispo, numserie, cantmin);
		this.marca = marca;
		this.modelo = modelo;
		this.cantialmac = cantialmac;
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
	public float getCantialmac() {
		return cantialmac;
	}
	public void setCantialmac(float cantialmac) {
		this.cantialmac = cantialmac;
	}
	public String getTipocone() {
		return tipocone;
	}
	public void setTipocone(String tipocone) {
		this.tipocone = tipocone;
	}

}
