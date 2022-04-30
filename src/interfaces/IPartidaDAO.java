package interfaces;

import clases.Partida;

public interface IPartidaDAO {
	public void crearPartida(Partida objPartida);

	public void listarPartida();

	public int obtenerPartida(); // esta accion me va a retornar al ultima partida creada
}
