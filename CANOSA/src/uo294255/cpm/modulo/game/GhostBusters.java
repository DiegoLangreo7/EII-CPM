package uo294255.cpm.modulo.game;

import java.util.Random;

public class GhostBusters {

	public static final int maxTiradas = 7;
	private int numTiradas = maxTiradas;
	private boolean cuadrillaA = false;
	private boolean cuadrillaB = false;
	private boolean cuadrillaC = false;
	private boolean cuadrillaD = false;
	private boolean cuadrillaE = false;
	private boolean lider = false;
	private int A = 3;
	private int B = 3;
	private int C = 3;
	private int D = 3;
	private int E = 3;
	private int ejeX = 7;
	private int ejeY = 5;
	private int tiradaDado;
	private Casilla[][] tablero;
	public GhostBusters() {}

	private void generarTablero() {
		tablero = new Casilla[ejeX][ejeY];
		for (int y = 0; y < ejeY; y++) {
			for (int x = 0; x < ejeX; x++) {
				if(x == 3 && y == 0) {
					tablero[x][y] = new Casilla("Lider","/img/FantasmaTipoLider.png");
				}
				else if (y == 0 && (x < 3 || x >3)) {
					tablero[x][y] = new Casilla("Vacio","");

				}
				else if (y == 1 && (x < 2 || x > 4)) {
					tablero[x][y] = new Casilla("Vacio","");

				}
				else if (y == 2 && (x < 1 || x >5)) {
					tablero[x][y] = new Casilla("Vacio","");

				}
				else if(y==ejeY-1) {
					tablero[x][y] = new Casilla("Cazafantasmas","/img/Cazafantasmas.png");
				}
				else {
					Casilla c = fantasmaRandom();
					tablero[x][y] = c;
				}
				
			}
		}
	}

	private Casilla fantasmaRandom() {
		Random random = new Random();
		int n = random.nextInt(5) + 1;
		switch (n) {
		case 1:
			if(A == 0) {return fantasmaRandom();}
			A--; return new Casilla("A","/img/FantasmaTipoA.png");
		case 2:
			if(B == 0) {return fantasmaRandom();}
			B--; return new Casilla("B","/img/FantasmaTipoB.png");
		case 3:
			if(C == 0) {return fantasmaRandom();}
			C--; return new Casilla("C","/img/FantasmaTipoC.png");
		case 4:
			if(D == 0) {return fantasmaRandom();}
			D--; return new Casilla("D","/img/FantasmaTipoD.png");
		default:
			if(E == 0) {return fantasmaRandom();}
			E--; return new Casilla("E","/img/FantasmaTipoE.png");
		}
	}

	public void iniciarJuego() {
		cuadrillaA = false;
		cuadrillaB = false;
		cuadrillaC = false;
		cuadrillaD = false;
		cuadrillaE = false;
		lider = false;
		A = 3;
		B = 3;
		C = 3;
		D = 3;
		E = 3;
		numTiradas = maxTiradas;
		generarTablero();
		
	}

	public int getX() {
		return ejeX;
	}

	public int getY() {
		return ejeY;
	}

	public String getImagenCasilla(int x, int y) {
		return tablero[x][y].getImagen();
	}

	public boolean revisarFinalizar() {
		if(numTiradas<1) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getCasilla(int x, int y) {
		return tablero[x][y].getTipo();
	}

	public void almacenarDado(int resultado) {
		this.tiradaDado = resultado;
		numTiradas --;
	}

	public boolean mover(int x, int y) {
		if(tablero[x][y].getTipo().equals("Cazafantasmas")) {
			if(y-tiradaDado <0 || tablero[x][y-tiradaDado].getTipo().equals("Vacio")) {
				return false;
			}
			else {
				anotarFantasma(tablero[x][y-tiradaDado].getTipo());
				tablero[x][y-tiradaDado] = tablero[x][y];
				tablero[x][y] = new Casilla("Vacio","");
				tiradaDado = 0;
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	private void anotarFantasma(String tipo) {
		switch (tipo) {
		case "A":
			this.cuadrillaA = true;
			break;
		case "B":
			this.cuadrillaB = true;
			break;
		case "C":
			this.cuadrillaC = true;
			break;
		case "D":
			this.cuadrillaD = true;
			break;
		case "E":
			this.cuadrillaE = true;
			break;
		case "Lider":
			this.lider = true;
			break;
		}
	}

	public int revisarDescuento() {
		int condicion = 0;
		if(cuadrillaA == true) condicion ++;
		if(cuadrillaB == true) condicion ++;
		if(cuadrillaC == true) condicion ++;
		if(cuadrillaD == true) condicion ++;
		if(cuadrillaE == true) condicion ++;
		if(condicion == 5) {
			if(lider == true) return 25;
			else return 10;
		}
		else {
			return 0;
		}
	}
}
