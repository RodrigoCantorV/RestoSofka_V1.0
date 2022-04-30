package clases;

public class Jugador {
	private int jugador_id;
	private String jugador_nom;

	public Jugador() {
		// this.jugador_id = jugador_id;
		this.jugador_nom = jugador_nom;
	}

	public Jugador(int jugador_id, String jugador_nom) {
		// this.jugador_id = jugador_id;
		this.jugador_nom = jugador_nom;
	}

	public int getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(int jugador_id) {
		this.jugador_id = jugador_id;
	}

	public String getJugador_nom() {
		return jugador_nom;
	}

	public void setJugador_nom(String jugador_nom) {
		this.jugador_nom = jugador_nom;
	}

}
