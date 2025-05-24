package uo294255.cpm.modulo.model;

import java.util.ArrayList;
import java.util.List;

import uo294255.cpm.modulo.util.FileUtil;

public class ArchivoDescuentos {
	
	private static final String FICHERO_DESCUENTOS = "files/descuentos.dat";
	private List<Descuento> listaDescuentos = new ArrayList<Descuento>();
	
	public ArchivoDescuentos() {
		FileUtil.loadFileDescuentos(FICHERO_DESCUENTOS, listaDescuentos);
	}
	
	public int buscarDescuento(String dni) {
		for(Descuento dsc : listaDescuentos) {
			if(dsc.getDni().equals(dni)) {
				return dsc.getDescuento();
			}
		}
		return 0;
	}
	
	public void borrarDescuento(String dni) {
		Descuento buscado = null;
		FileUtil.removeData(FICHERO_DESCUENTOS);
		for(Descuento dsc : listaDescuentos) {
			if(!dsc.getDni().equals(dni)) {
				dsc.grabar(FICHERO_DESCUENTOS);
			}
			else {
				buscado = dsc;
			}
		}
		if(buscado!=null) {
			listaDescuentos.remove(buscado);
		}
	}
	
	public void registrarDescuento(String dni, int cantidad) {
		Descuento nuevoDescuento = new Descuento(dni,cantidad);
		nuevoDescuento.grabar(FICHERO_DESCUENTOS);
		listaDescuentos.add(nuevoDescuento);
	}
}
