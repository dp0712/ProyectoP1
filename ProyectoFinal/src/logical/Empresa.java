package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;



public class Empresa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7627963457177787952L;
	private ArrayList<Combos>miscombos;
	private ArrayList<Facturacion>misfacturas;
	private ArrayList<Cliente>misclientes;
	private ArrayList<Componente>miscomponentes;
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
			empresa = new Empresa(); //no entiendo por que da error
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
	/*
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
		*/
		
	}
	public int getCodifact() {
		return codifact;
	}
	public void setCodifact(int codifact) {
		this.codifact = codifact;
	}
	public void insertarCliente(Cliente Cliente) {
		this.misclientes.add(Cliente);
	}
	public Cliente buscarcliente(String cedula) {
		Cliente cliente = null;
		int i = 0;
		boolean encontrado = false;
		while (i<misclientes.size() && !encontrado) {
			if(misclientes.get(i).getCedula().equalsIgnoreCase(cedula) && misclientes.get(i) instanceof Cliente) {
				encontrado = true;
				cliente =(Cliente) misclientes.get(i);
			}
			i++;
		}
		return cliente;
	}
	public float creditodelcliente(Cliente c) {
		float res = 0;
		for(Facturacion f : misfacturas) {
			if(f.getCliente().cedula.equalsIgnoreCase(c.cedula) && f.isEstado()) {
				res+=f.getTotal();
			}
		}
		
		return c.getCredito()-res;
	}
	public Componente buscarelomponente(String Numserie) {
		Componente componente = null;
		int i = 0;
		boolean encontrado=false;
		while (i<miscomponentes.size() && !encontrado) {
			if(miscomponentes.get(i).getNumserie(){
				encontrado = true;
				componente = miscomponentes.get(i);
			}
			i++;
		}
		return componente;
	}
	




}
