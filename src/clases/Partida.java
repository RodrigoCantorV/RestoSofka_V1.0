package clases;

public class Partida {
	private int partida_id;
	private int jugador_id;
	private int acumulado_partida;

	public Partida() {
		this.partida_id = partida_id;
		this.jugador_id = jugador_id;
		this.acumulado_partida = acumulado_partida;
	}

	public Partida(int partida_id, int jugador_id, int acumulado_partida) {
		this.partida_id = partida_id;
		this.jugador_id = jugador_id;
		this.acumulado_partida = acumulado_partida;
	}

	public Partida(int jugador_id, int acumulado_partida) {
		this.jugador_id = jugador_id;
		this.acumulado_partida = acumulado_partida;
	}

	public int getPartida_id() {
		return partida_id;
	}

	public void setPartida_id(int partida_id) {
		this.partida_id = partida_id;
	}

	public int getJugador_id() {
		return jugador_id;
	}

	public void setJugador_id(int jugador_id) {
		this.jugador_id = jugador_id;
	}

	public int getAcumulado_partida() {
		return acumulado_partida;
	}

	public void setAcumulado_partida(int acumulado_partida) {
		this.acumulado_partida = acumulado_partida;
	}
}
