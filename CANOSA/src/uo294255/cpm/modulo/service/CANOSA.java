package uo294255.cpm.modulo.service;

import uo294255.cpm.modulo.game.GhostBusters;
import uo294255.cpm.modulo.model.*;

public class CANOSA {
	Catalogo catalogo = new Catalogo();
	Reserva reserva = new Reserva(); 
	GhostBusters gb = new GhostBusters();
	ArchivoDescuentos ad = new ArchivoDescuentos();
	
	public CANOSA() {
	}

	//--------CATALOGO---------------------------------------------------------------------------------

	public Castillo[] getCatalogo() {
			return catalogo.getArticulos();
	}
	
   public Castillo getCastilloPos(int i) {
	   return catalogo.getListaArticulos().get(i);
   }

	public int getNumeroItemsCatalogo() {
		return catalogo.getNumeroItemsCatalogo();
	}
	
	public String getImagenCastillo(int i) {
		return catalogo.getImagenArticulo(i);
	}

	public void aplicarFiltro(String filtro) {
		catalogo.aplicarFiltro(filtro);
	}

	public void quitarFiltro(String string,float precio) {
		catalogo.quitarFiltro(string, precio);
	}

	public String getEncantamiento(int i) {
		return catalogo.getEncantamiento(i);
	}

	public void resetCatalogo() {
		catalogo.reset();
		
	}

	public Castillo getCastillo(int i) {
		return catalogo.getCastillo(i);
	}
	
	public void setIdioma(String idioma) {
		catalogo.setIdioma(idioma);
	}

	
	//--------REGISTRO-------------------------------------------------------------------------------
	
	public void inicializarPedido() {
		reserva.inicializar();
	}
 
	public void grabarPedido() {
		reserva.grabarPedido();
	}
	
	public Reserva getPedido() {
		return reserva;
	}
	
	public String getTextoPedido() {
		return reserva.toString();
	}
	
	public void registrarCastillo(Castillo castillo) {
		reserva.registrarCastillo(castillo);

	}
	public void registrarHabitaciones(int p, int h) {
		reserva.registrarHabitaciones(p, h);
	}
	
	public float calcularPrecioFinal() {
		return reserva.calcularPrecioReserva();
	}
	
	public void registrarFecha(String fechaString, int dias) {
		reserva.registrarFecha(fechaString,dias);
	}
	
	public void registrarDatosUsuario(String nombre, String email, String dni, String comentarios) {
		reserva.registrarUsuario(nombre,email,dni,comentarios);
	}
	
	public String getFecha() {
		return reserva.getFechaReserva();
	}
	
	public int getDias() {
		return reserva.getDiasReservados();
	}
	
	public void resetReserva() {
		reserva.reset();
	}
	
	public void confirmarReserva() {
		reserva.grabarPedido();
	}
	
	public void aplicarDescuento(int dSC) {
		reserva.aplicarDescuento(dSC); 
	}
	
	//--------JUEGO-----------------------------------------------------------------------------------

	public void iniciarJuego() {
		gb.iniciarJuego();
	}

	public int getGameX() {
		return gb.getX();
	}

	public int getGameY() {
		return gb.getY();
	}

	public String getImagenCasilla(int x, int y) {
		return gb.getImagenCasilla(x,y); 
	}

	public String getCasilla(int x, int y) {
		return gb.getCasilla(x,y);
	}

	public void dadoLanzado(int resultado) {
		 gb.almacenarDado(resultado);
	}

	public boolean mover(int x, int y) {
		return gb.mover(x,y);
	}

	public boolean revisarFinalizar() {
		return gb.revisarFinalizar();
	}

	public int revisarDescuento() {
		return gb.revisarDescuento();
	}

	
	//--------DESCUENTOS------------------------------------------------------------------------------

	public int buscarDescuento(String dni) {
		return ad.buscarDescuento(dni);
	}
	
	public void registrarDescuento(String dni, int cantidad) {
		ad.registrarDescuento(dni, cantidad);
	}

	public void borrarDescuento(String dni) {
		ad.borrarDescuento(dni);
	}

	
	

	

	

	

	

}
