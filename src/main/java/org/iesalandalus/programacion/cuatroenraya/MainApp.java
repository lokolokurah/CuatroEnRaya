package org.iesalandalus.programacion.cuatroenraya;

import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

public class MainApp {

	public static void main(String[] args) {

		CuatroEnRaya cuatroEnRaya = new CuatroEnRaya(Consola.leerJugador(), Consola.leerJugador());

		cuatroEnRaya.jugar();

	}

}
