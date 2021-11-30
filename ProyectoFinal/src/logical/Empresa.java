package logical;

import java.io.Serializable;
import java.util.ArrayList;


public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7627963457177787952L;
	private ArrayList<Combos>miscombos;
	private ArrayList<Facturacion>misfacturas;
	private ArrayList<Cliente>misclientes;
	private int codifact=1;
	public Empresa(ArrayList<Combos> miscombos, ArrayList<Facturacion> misfacturas, ArrayList<Cliente> misclientes) {
		super();
		this.miscombos = new ArrayList<Combos>();
		this.misfacturas = new ArrayList<Facturacion>();
		this.misclientes = new ArrayList<Cliente>();

	}
	public ArrayList<Combos> getMiscombos() {
		return miscombos;
	}
	public void setMiscombos(ArrayList<Combos> miscombos) {
		this.miscombos = miscombos;
	}
	public ArrayList<Facturacion> getMisfacturas() {
		return misfacturas;
	}
	public void setMisfacturas(ArrayList<Facturacion> misfacturas) {
		this.misfacturas = misfacturas;
	}
	public ArrayList<Cliente> getMisclientes() {
		return misclientes;
	}
	public void setMisclientes(ArrayList<Cliente> misclientes) {
		this.misclientes = misclientes;
	}
	public static Empresa empresa = null;
	public static Empresa getInstance() {
		if(empresa == null) {
			empresa = new Empresa();
		}
		return empresa;
	}
	public Combos buscarelcombo(String codigo) {
		Combos combo= null;
		int i= 0;
		boolean encontrado = false;
		while (i<miscombos.size() && !encontrado) {
			if(miscombos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				encontrado= true;
				combo= miscombos.get(i);
			}
			i++;
		}
		return combo;
	}
	public void retornarelcombo(Combos c) {
		for(Componente a : c.getMiscomponentes() ) {
			a.setCantdispo(a.getCantdispo()+1);
			
			if( a instanceof DiscoDuro) {
				setTotDisco(getTotDisco()-1);
			}
			
			if( a instanceof MotherBoard) {
				setTotMotherboard(getTotMotherboard()-1);
			}
			if( a instanceof Microprocesadores) {
				setTotMicroprocesadores(getTotMicroprocesadores()-1);
			}
			
			if( a instanceof MemoriaRam) {
				setTotMemoriaRam(getTotMemoriaRam()-1);
			}
			
		}
		
	}
	public int getCodifact() {
		return codifact;
	}
	public void setCodifact(int codifact) {
		this.codifact = codifact;
	}


}
