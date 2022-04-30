package clases;

public class Ronda_Partida {
	private int id_ronda;
	private int id_partida;

	public Ronda_Partida(int id_ronda, int id_partida) {
		this.id_ronda = id_ronda;
		this.id_partida = id_partida;
	}

	public Ronda_Partida() {
		this.id_ronda = id_ronda;
		this.id_partida = id_partida;
	}

	public int getId_ronda() {
		return id_ronda;
	}

	public void setId_ronda(int id_ronda) {
		this.id_ronda = id_ronda;
	}

	public int getId_partida() {
		return id_partida;
	}

	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}
}
