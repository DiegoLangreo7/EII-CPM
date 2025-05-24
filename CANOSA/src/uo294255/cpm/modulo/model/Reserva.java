package uo294255.cpm.modulo.model;

import uo294255.cpm.modulo.util.FileUtil;

public class Reserva {

	private static final String FICHERO_RESERVAS = "files/reservas.dat";
	private Castillo reserva;
	private String dni;
	private String nombreYApellidos;
	private String email;
	private String codigoCastillo;
	private String fechaReserva;
	private int diasReservados;
	private int numeroHabitacionesReservadas;
	private float precio;
	private String comentarios;
	private int nPersonas;
	private double descuento;

	public Reserva() {
		inicializar();
	}

	public void inicializar() {
		reserva = null;
		dni = "";
		nombreYApellidos = "";
		email = "";
		codigoCastillo = "";
		fechaReserva = "";
		diasReservados = 0;
		numeroHabitacionesReservadas = 1;
		precio = 0;
		comentarios = "";
		descuento = 0;
	}

	public boolean isVacio() {
		return reserva == null;
	}

	public float calcularPrecioReserva() {
		this.precio = this.diasReservados * this.numeroHabitacionesReservadas * reserva.getPrecio();
		descontar();
		return precio;
	}

	public void registrarCastillo(Castillo castillo) {
		this.reserva = castillo;
		this.codigoCastillo = castillo.getCodigo();
	}

	public void registrarHabitaciones(int personas, int numeroHabitaciones) {
		this.nPersonas = personas;
		this.numeroHabitacionesReservadas = numeroHabitaciones;
	}

	public void registrarFecha(String fechaString, int dias) {
		this.fechaReserva = fechaString;
		this.diasReservados = dias;
	}

	public void registrarUsuario(String nombre, String email, String id, String comentarios) {
		this.nombreYApellidos = nombre;
		this.email = email;
		this.dni = id;
		this.comentarios = comentarios;
	}

	public void grabarPedido() {
		FileUtil.saveToFile(this.toString(),FICHERO_RESERVAS);
		inicializar();
	}

	public String toString() {
		StringBuilder sbReserva = new StringBuilder();
		sbReserva.append(this.dni);
		sbReserva.append(";");
		sbReserva.append(this.nombreYApellidos);
		sbReserva.append(";");
		sbReserva.append(this.email);
		sbReserva.append(";");
		sbReserva.append(this.codigoCastillo);
		sbReserva.append(";");
		sbReserva.append(this.fechaReserva);
		sbReserva.append(";");
		sbReserva.append(this.diasReservados);
		sbReserva.append(";");
		sbReserva.append(this.numeroHabitacionesReservadas);
		sbReserva.append(";");
		sbReserva.append(this.precio);
		sbReserva.append(";");
		sbReserva.append(this.comentarios);
		return sbReserva.toString();
	}

	public int getnPersonas() {
		return nPersonas;
	}

	public void reset() {
		this.diasReservados = 0;
		this.numeroHabitacionesReservadas = 1;
		this.nPersonas = 1;
		this.descuento = 0;
	}
	
	public String getFechaReserva() {
		return fechaReserva;
	}

	public int getDiasReservados() {
		return diasReservados;
	}


	public void aplicarDescuento(int dSC) {
		this.descuento = dSC /100.00;
	}
	

	private void descontar() {
		this.precio = precio -(float) (precio *descuento);		
	}

}