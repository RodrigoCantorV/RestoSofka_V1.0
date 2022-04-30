package interfaces;

import clases.Jugador;

public interface IJugadorDAO {
	public void crearJugador(Jugador objJugador);

	public void listarJugador();

	public int obtenerUltimoJugador();
}
