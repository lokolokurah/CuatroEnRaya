package org.iesalandalus.programacion.cuatroenraya.vista;


import org.iesalandalus.programacion.cuatroenraya.modelo.Ficha;
import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;
import org.iesalandalus.programacion.utilidades.Entrada;



public class Consola {

	private static int numeroJugador = 1;
	
	private Consola()
	{
		
	}
	
	public static String leerNombre()
	{
		String nombre;
		boolean trigger = false;
		System.out.print("Introduce tu nombre: ");
		do 
		{
			if (trigger)
			{
				System.out.print("El nombre no puede estar vacío, introduce de nuevo el nombre: ");
			}
			else
			{
				trigger = true;
			}
			nombre = Entrada.cadena();
		} while (nombre.trim().isEmpty());
		return nombre;
	}
	
	public static Ficha elegirColorFichas()
	{
		Ficha ficha = Ficha.AZUL;
		int color;
		boolean trigger = false;
		System.out.print("Introduce el color de la ficha: (0->Azul | 1->Verde) ");
		do
		{
			if (trigger)
			{
				System.out.print("Introduce un color correcto, [0->Azul] o [1->Verde]: ");
			}
			else
			{
				trigger = true;
			}
			color = Entrada.entero();
		} while (color<0 || color>1);
		if (color==0)
		{
			ficha = Ficha.AZUL;
		}
		if (color==1)
		{
			ficha = Ficha.VERDE;
		}
		return ficha;
	}
	
	public static Jugador leerJugador()
	{
		System.out.println("[DATOS JUGADOR "+numeroJugador+"]");
		String nombre = leerNombre();
		Ficha ficha = elegirColorFichas();
		numeroJugador++;
		return new Jugador (nombre, ficha);
	}
	
	public static Jugador leerJugadorFicha(Ficha ficha)
	{
		String nombre = leerNombre();
		return new Jugador(nombre, ficha);
	}
	
	public static int leerColumna(Jugador jugador)
	{
		int columna;
		boolean trigger = false;
		System.out.print(jugador.getNombre()+" introduce la columna donde deseas introducir la ficha (0-6): ");
		do
		{
			if (trigger)
			{
				System.out.print(jugador.getNombre()+" introduce una columna correcta, desde 0 hasta 6: ");
			}
			else
			{
				trigger = true;
			}
			columna = Entrada.entero();
		} while (columna<0 || columna>=Tablero.COLUMNAS);
		return columna;
	}
	
}
