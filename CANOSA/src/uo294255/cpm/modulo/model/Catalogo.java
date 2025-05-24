package uo294255.cpm.modulo.model;

import java.util.*;

import uo294255.cpm.modulo.util.FileUtil;

public class Catalogo {

	private String FICHERO_CATALOGO = "files/castillosES.dat";
	private List<Castillo> catalogoCastillos = new ArrayList<Castillo>();
	private List<Castillo> catalogoOriginal = new ArrayList<Castillo>();
	private List<String> encantamientos = new ArrayList<String>();

	public Catalogo() {
		cargarArticulos();
	}

	private void guardarEncantamientos() {
		for(Castillo c : catalogoOriginal) {
			String enc = c.getEncantamientos();
			String[] listEnc = enc.split("-");
			for(String s : listEnc) {
				if(!encantamientos.contains(s)) {
					encantamientos.add(s);
				}
			}
		}
		
	}

	private void cargarArticulos() {
		FileUtil.loadFileCatalogo(FICHERO_CATALOGO, catalogoCastillos);
		FileUtil.loadFileCatalogo(FICHERO_CATALOGO, catalogoOriginal);
		guardarEncantamientos();
	}

	public Castillo[] getArticulos() {
		Castillo[] castillos = catalogoCastillos.toArray(new Castillo[catalogoCastillos.size()]);
		return castillos;
	}

	public List<Castillo> getListaArticulos() {
		return catalogoCastillos;
	}

	public int getNumeroItemsCatalogo() {
		return catalogoCastillos.size();
	}

	public String getImagenArticulo(int i) {
		return "/img/"+catalogoCastillos.get(i).getCodigo()+".png";
	}

	public boolean aplicarFiltro(String filtro) {
		try {
			float precio = Float.parseFloat(filtro);
			catalogoCastillos.clear();
			catalogoCastillos.addAll(catalogoOriginal);
			for(Castillo c : catalogoOriginal) {
				if(c.getPrecio()>precio) {
					catalogoCastillos.remove(c);
				}
			}
			return true;
		}
		catch(NumberFormatException e) {
			List<Castillo> aux = new ArrayList<Castillo>();
			for(Castillo c : catalogoCastillos) {
				String enc = c.getEncantamientos();
				String[] listEnc = enc.split("-");
				for(String s : listEnc) {
					if(filtro.equals(s)) {
						aux.add(c);
					}
				}
			}
			catalogoCastillos.clear();
			catalogoCastillos.addAll(aux);
		}
		return true;
	}

	public boolean quitarFiltro(String filtro, float precio) {
			for(Castillo c : catalogoOriginal) {
				String enc = c.getEncantamientos();
				String[] listEnc = enc.split("-");
				for(String s : listEnc) {
					if(c.getPrecio() <= precio&& filtro.equals(s)) {
						if(!catalogoCastillos.contains(c)) {
							catalogoCastillos.add(c);
						}
					}
				}
			}
			return true;
	}

	public String getEncantamiento(int i) {
		return encantamientos.get(i);
	}

	public void reset() {
		catalogoCastillos.clear();
		catalogoCastillos.addAll(catalogoOriginal);
	}

	public Castillo getCastillo(int i) {
		return catalogoCastillos.get(i);
	}

	public void setIdioma(String idioma) {
		this.FICHERO_CATALOGO = "files/castillos"+idioma+".dat";
		catalogoCastillos = new ArrayList<Castillo>();
		catalogoOriginal = new ArrayList<Castillo>();
		cargarArticulos();
	}
	
	
}
