package uo294255.cpm.modulo.util;

import java.io.*;
import java.util.*;

import uo294255.cpm.modulo.model.Castillo;
import uo294255.cpm.modulo.model.Descuento;

public abstract class FileUtil {
	
	public static void loadFileCatalogo(String nombreFicheroEntrada, List<Castillo> listaCatalogo) {

		String linea;
		String[] datosCastillo = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosCastillo = linea.split(";");
				listaCatalogo.add(new Castillo(datosCastillo[0], datosCastillo[1], datosCastillo[2],datosCastillo[3],
						Float.parseFloat(datosCastillo[4]), datosCastillo[5]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}
	
	public static void loadFileDescuentos(String nombreFicheroEntrada, List<Descuento> listaDescuentos) {

		String linea;
		String[] datosDescuento = null;

		try {
			BufferedReader fichero = new BufferedReader(new FileReader(nombreFicheroEntrada));
			while (fichero.ready()) {
				linea = fichero.readLine();
				datosDescuento = linea.split(";");
				String descuentoS = datosDescuento[1].substring(datosDescuento[1].length() - 2);
				int descuentoN = Integer.parseInt(descuentoS);
				listaDescuentos.add(new Descuento(datosDescuento[0], descuentoN));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void saveToFile(String txtReserva, String dat) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter(dat,true));
			fichero.append(txtReserva + "\n");
			fichero.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}

	public static void removeData(String nombreFicheroEntrada) {
		try {
		 RandomAccessFile archivo = new RandomAccessFile(new File(nombreFicheroEntrada), "rw");
			archivo.setLength(0);
			archivo.close();
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha podido guardar");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida");
		}
	}
}
