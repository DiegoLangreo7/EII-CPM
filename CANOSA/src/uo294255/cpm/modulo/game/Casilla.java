package uo294255.cpm.modulo.game;

public class Casilla {

	private String tipo;
	private String Imagen;

	public Casilla(String tipoF, String ImagenF) {
		setTipo(tipoF);
		setImagen(ImagenF);
	}

	public String getTipo() {
		return tipo;
	}

	private void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagen() {
		return Imagen;
	}

	private void setImagen(String imagen) {
		Imagen = imagen;
	}
}
