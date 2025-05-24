package uo294255.cpm.modulo.model;

public class Castillo {

	private String codigo; 
	private String denominacion;
	private String descripcion;
	private String pais;
	private float precio;
	private String encantamientos;

	public Castillo(String codigo, String denominacion, String descripcion, String pais, float precioHabitacion, String encantamientos) {
		this.codigo = codigo;
		this.pais = pais;
		this.denominacion = denominacion;
		this.precio = precioHabitacion;
		setDescripcion(descripcion);
		setEncantamientos(encantamientos);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Castillos [denominacion=" + denominacion + "]";
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getEncantamientos() {
		return encantamientos;
	}

	public void setEncantamientos(String encantamientos) {	
		this.encantamientos = encantamientos;
	} 
	
	public String toStringEncantamientosES() {
		String toStringEncantamientos = "";
		String[] listEnc = encantamientos.split("-");
		for (String s : listEnc) {
			switch (s) {
			case "Ap":
				toStringEncantamientos += "Apariciones Fantasmales.\n";
				break;
			case "En":
				toStringEncantamientos += "Encendido de Luces.\n";
				break;
			case "Ob":
				toStringEncantamientos += "Objetos que se mueven.\n";
				break;
			case "Ol":
				toStringEncantamientos += "Olores Fetidos.\n";
				break;
			case "De":
				toStringEncantamientos += "Descenso Temperatura.\n";
				break;
			case "Ru":
				toStringEncantamientos += "Ruidos Extraños.\n";
				break;
			}
		}
		return toStringEncantamientos;
	}
	
	public String toStringEncantamientosEN() {
	    String toStringEncantamientos = "";
	    String[] listEnc = encantamientos.split("-");
	    for (String s : listEnc) {
	        switch (s) {
	            case "Ap":
	                toStringEncantamientos += "Ghost Appearances.\n";
	                break;
	            case "En":
	                toStringEncantamientos += "Lighting up Lights.\n";
	                break;
	            case "Ob":
	                toStringEncantamientos += "Moving Objects.\n";
	                break;
	            case "Ol":
	                toStringEncantamientos += "Foul Smells.\n";
	                break;
	            case "De":
	                toStringEncantamientos += "Temperature Drop.\n";
	                break;
	            case "Ru":
	                toStringEncantamientos += "Strange Noises.\n";
	                break;
	        }
	    }
	    return toStringEncantamientos;
	}
}
