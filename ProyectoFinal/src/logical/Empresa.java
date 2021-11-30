package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import logico.Cliente;
import logico.Factura;
import logico.Movimientos;
import logico.Persona;
import logico.Prodacom;


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
	/*
	public void pagarfactura(Cliente aux) {
		double total=0;
		ArrayList<String>s=new ArrayList<String>();
		for(Facturacion f : misfacturas) {
			if(f.getCliente().equals(aux) && f.isEstado()) {
				s.add(f.getCod());
				f.setEstado(false);
				total+=f.calcualBenf();
			}
		}
		setBalance(getBalance()+total);
		Movimientos m = new Movimientos("Pago deuda cliente: "+aux.getNombre(), "D-"+getCod_mov(), "Facturas: "+s, new Date(), total, getUser().getNombre(), Prodacom.getInstance().balance);
		movimientos.add(m);
		setCod_mov(getCod_mov()+1);
		
	}
	
*/



}
