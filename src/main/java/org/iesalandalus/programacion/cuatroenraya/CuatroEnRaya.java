package org.iesalandalus.programacion.cuatroenraya;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.cuatroenraya.modelo.Jugador;
import org.iesalandalus.programacion.cuatroenraya.modelo.Tablero;
import org.iesalandalus.programacion.cuatroenraya.vista.Consola;

public class CuatroEnRaya {

	private static final int NUMERO_JUGADORES = 2;
	private Jugador[] jugadores;
	public Tablero tablero;
	private int numeroJugador = 0;
	
	public CuatroEnRaya(Jugador jugador1, Jugador jugador2) {
		tablero = new Tablero();
		jugadores = new Jugador[NUMERO_JUGADORES];
		if (jugador1==null || jugador2==null)
		{
			throw new NullPointerException("Error: No puede haber ningun jugador nulo.");
		}
		jugadores[0] = jugador1;
		jugadores[1] = jugador2;
	}
	
	private boolean tirar(Jugador jugador)
	{
		boolean resultado = false;
		boolean trigger = false;
		do
		{
			int columna = Consola.leerColumna(jugador);
			try {
				if (tablero.introducirFicha(columna, jugador.getColorFichas()))
				{
					resultado = true;
				}
				trigger = true;
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		} while (!trigger);
		return resultado;
	}
	
	public void jugar()
	{
		if (tablero.estaLleno())
		{
			System.out.println("No hay más casillas libres.");
			System.exit(0);
		}
		else
		{
			System.out.println("Turno de "+jugadores[numeroJugador].getNombre());
			if(tirar(jugadores[numeroJugador]))
			{
				System.out.println("¡"+jugadores[numeroJugador].getNombre()+" has ganado!");
				System.exit(0);
			}
			else
			{
				System.out.println("[Tablero Actualizado]");
				System.out.println(tablero);
			}
		}
		if (numeroJugador == 0)
		{
			numeroJugador = 1;
		}
		else
		{
			numeroJugador = 0;
		}
		jugar();
	}
	
	
}
