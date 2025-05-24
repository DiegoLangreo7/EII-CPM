package uo294255.cpm.modulo.model;

import java.util.Objects;

import uo294255.cpm.modulo.util.FileUtil;

public class Descuento {

	private String dni;
	private int descuento;

	public Descuento(String dni, int cantidad) {
		this.dni = dni;
		this.descuento = cantidad;
	}

	public void grabar(String fichero) {
		FileUtil.saveToFile(this.toString(), fichero);
	}

	@Override
	public String toString() {
		return dni + ";EXTRA" + descuento;
	}

	public String getDni() {
		return dni;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Descuento other = (Descuento) obj;
		return Objects.equals(dni, other.dni);
	}

	public int getDescuento() {
		return descuento;
	}

}
