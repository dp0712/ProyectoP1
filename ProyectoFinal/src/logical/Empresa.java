package logical;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import logico.Proveedor;
import visual.Principal;


public class Empresa implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7627963457177787952L;
	private ArrayList<Combos>miscombos;
	private ArrayList<Facturacion>misfacturas;
	private ArrayList<Cliente>misclientes;
	private ArrayList<Componente>miscomponentes;
	private ArrayList<Usuario>misusuarios;
	private ArrayList<Proveedor>misproveedores;
	private int codifact=1;
	private int codicompo=1;
	public Empresa() {
		super();
		this.miscombos = new ArrayList<Combos>();
		this.misfacturas = new ArrayList<Facturacion>();
		this.misclientes = new ArrayList<Cliente>();
		this.miscomponentes= new ArrayList<Componente>();
		this.misusuarios = new ArrayList<Usuario>();

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
	public ArrayList<Componente> getMiscomponentes() {
		return miscomponentes;
	}
	public void setMiscomponentes(ArrayList<Componente> miscomponentes) {
		this.miscomponentes = miscomponentes;
	}
	public int getCodicompo() {
		return codicompo;
	}
	public void setCodicompo(int codicompo) {
		this.codicompo = codicompo;
	}
	public ArrayList<Usuario> getMisusuarios() {
		return misusuarios;
	}
	public void setMisusuarios(ArrayList<Usuario> misusuarios) {
		this.misusuarios = misusuarios;
	}
	public static Empresa empresa = null;
	public static Empresa getInstance() {
		if(empresa == null) {
			empresa = new Empresa(); //no entiendo por que da error
		}
		return empresa;
	}
	public void addcombo(Combos combos) {
		miscombos.add(combos);
		setMiscombos(getMiscombos());
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
	private int cantidadDiscoDuro = 0;
	private int cantidadmemram = 0;
	private int cantidadtarjetam = 0;
	private int cantidadmicro = 0;
	public int getCantidadDiscoDuro() {
		return cantidadDiscoDuro;
	}
	public void setCantidadDiscoDuro(int cantidadDiscoDuro) {
		this.cantidadDiscoDuro = cantidadDiscoDuro;
	}
	public int getCantidadmemram() {
		return cantidadmemram;
	}
	public void setCantidadmemram(int cantidadmemram) {
		this.cantidadmemram = cantidadmemram;
	}
	public int getCantidadtarjetam() {
		return cantidadtarjetam;
	}
	public void setCantidadtarjetam(int cantidadtarjetam) {
		this.cantidadtarjetam = cantidadtarjetam;
	}
	public int getCantidadmicro() {
		return cantidadmicro;
	}
	public void setCantidadmicro(int cantidadmicro) {
		this.cantidadmicro = cantidadmicro;
	}
	public void devolverelCombo(Combos c) {
		for(Componente a : c.getMiscomponentes() ) {
			a.setCantdispo(a.getCantdispo()+1);
			
			if( a instanceof DiscoDuro) {
				setCantidadDiscoDuro(getCantidadDiscoDuro()-1);
			}
			
			if( a instanceof TarjetaMadre) {
				setCantidadtarjetam(getCantidadtarjetam()-1);
			}
			if( a instanceof MemoriaRam) {
				setCantidadmemram(getCantidadmemram()-1);
			}
			if( a instanceof MicroProcesador) {
				setCantidadmicro(getCantidadmicro()-1);
			}
			
		}
		
	}
	public void darcombo(Combos c) {
		Combos a = buscarelcombo(c.getCodigo());
		for(Componente b : c.getMiscomponentes()) {
			clienteCompo(b);
		}
		
	}
	/*
	public void retornarelcombo(Combos c) {
		for(Componente a : c.getMiscomponentes() ) {
			a.setCantdispo(a.getCantdispo()+1);
			
			if( a instanceof DiscoDuroDuro) {
				setTotDiscoDuro(getTotDiscoDuro()-1);
			}
			
			if( a instanceof TarjetaMadre) {
				setTotTarjetaMadre(getTotTarjetaMadre()-1);
			}
			if( a instanceof Microprocesadores) {
				setTotMicroprocesadores(getTotMicroprocesadores()-1);
			}
			
			if( a instanceof MemoriaRam) {
				setTotMemoriaRam(getTotMemoriaRam()-1);
			}
			
		}
		
		
	}
	*/
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

	public void addcomponente(Componente componente) {
		this.miscomponentes.add(componente); 
		setCodicompo(getCodicompo()+1);
	}
	public Componente buscarelomponente(String string) {
		Componente componente = null;
		int i = 0;
		boolean encontrado=false;
		while (i<miscomponentes.size() && !encontrado) {
			if(miscomponentes.get(i).getNumserie()){
				encontrado = true;
				componente = miscomponentes.get(i);
			}
			i++;
		}
		return componente;
	}
	public boolean reviCombo(Combos c) {
		boolean res = true;
		int cantidad = 0;
		int i = 0;
		int j = 0;
		while(i<c.getMiscomponentes().size() && res) {
			j=i+1;
			cantidad = c.getMiscomponentes().get(i).getCantdispo()-1;
			if(cantidad>0) {
				while(j<c.getMiscomponentes().size() && res) {
					if(c.getMiscomponentes().get(i).equals(c.getMiscomponentes().get(j))) {
						cantidad--;
						if(cantidad==-1) {
							res = false;
						}
					}
					j++;
				}
			}else {
				res = false;
			}
			i++;
		}
		return res;
	}
	public void clienteCombo(Combos c) { //para vender
		Combos a = buscarelcombo(c.getCodigo());
		for(Componente b : c.getMiscomponentes()) {
			clienteCompo(b);
		}
		
	}
	public void clienteCompo(Componente c) { //para vender
		Componente a = buscarelomponente(c.numserie);
		a.setCantdispo(a.getCantdispo()-1);
		
		if( c instanceof DiscoDuro) {
			setCantidadDiscoDuro(getCantidadDiscoDuro()+1);
		}
		
		if( c instanceof TarjetaMadre) {
			setCantidadtarjetam(getCantidadtarjetam()+1);
		}
		if( c instanceof MicroProcesador) {
			setCantidadmicro(getCantidadmicro()+1);
		}
		
		if( c instanceof MemoriaRam) {
			setCantidadmemram(getCantidadmemram()+1);
		}
			
	}
	public void sumarloscomponentes(Componente componente, int cant) {
		for(Componente c : miscomponentes) {
			if(c.equals(componente)) {
				c.cantmin+=cant;
				
				if( c instanceof DiscoDuro) {
					setCantidadDiscoDuro(getCantidadDiscoDuro() - cant);
				}
				
				if( c instanceof TarjetaMadre) {
					setCantidadtarjetam(getCantidadtarjetam()- cant);
				}
				if( c instanceof MicroProcesador) {
					setCantidadmicro(getCantidadmicro() - cant);
				}
				if( c instanceof MemoriaRam) {
					setCantidadmemram(getCantidadmemram() -cant);
				}
				

			}			
		}
		

		
	}
	public void agregarfactura(Facturacion factura) {
		this.misfacturas.add(factura); 
		setCodifact(getCodifact()+1);
		
	}
	public void addusuario(Usuario usuario) {
		this.misusuarios.add(usuario);
	}
	private Usuario username= null;
	public Usuario getUsername() {
		return username;
	}

	public void setUsername(Usuario username) {
		this.username = username;
	}
	public boolean logeo(String text, String text2) {
		boolean res = false;
		int i = 0;
		while(i<misusuarios.size() && !res) {
			if(misusuarios.get(i) instanceof Usuario) {
				if(((Usuario)misusuarios.get(i)).getUsername().equalsIgnoreCase(text)
						&& ((Usuario)misusuarios.get(i)).getPassword().equalsIgnoreCase(text2)){
							res = true;
							Empresa.getInstance().setUsername(misusuarios.get(i));
						}
			}
			i++;
		}
		return res;
	}
	public ArrayList<Proveedor> getMisproveedores() {
		return misproveedores;
	}
	public void setMisproveedores(ArrayList<Proveedor> misproveedores) {
		this.misproveedores = misproveedores;
	}

	public Proveedor listproveedor(String valueAt) {
		int i = 0;
		boolean encontrado = false;
		Proveedor p = null;
		while(i<misproveedores.size() && !encontrado) {
			if(misproveedores.get(i).getRnc().equalsIgnoreCase(valueAt)) {
				p = misproveedores.get(i);
				encontrado = true;
			}
			i++;
		}
		return p;
	}



}
