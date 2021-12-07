package logical;

import java.util.ArrayList;

public class Combos {

	private String nombre;
	private String codigo;
	private float descuento;
	private ArrayList<Componente>miscomponentes= new ArrayList<Componente>();
	public Combos(String nombre, String codigo) {
		super();
		this.miscomponentes= new ArrayList<Componente>();
		this.nombre=nombre;
		this.codigo=codigo;
		this.descuento=descuento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public ArrayList<Componente> getMiscomponentes() {
		return miscomponentes;
	}
	public void setMiscomponentes(ArrayList<Componente> miscomponentes) {
		this.miscomponentes = miscomponentes;
	}

	public void insertcomponentes(Componente c) {
		miscomponentes.add(c);
	}
	public float calcuprecio() {
		float resultado=0.0f;
		for (Componente c:miscomponentes) {
			resultado+=c.getPrecio();
		}
		return resultado;
	}
	

}
