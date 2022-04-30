package clases;

public class ResumenPartida {
	private int id_partida;
	private String nom_jugador;
	private int ronda_maxima;
	private int cumulado_final;

	public ResumenPartida(int id_partida, String nom_jugador, int ronda_maxima, int cumulado_final) {
		this.id_partida = id_partida;
		this.nom_jugador = nom_jugador;
		this.ronda_maxima = ronda_maxima;
		this.cumulado_final = cumulado_final;
	}

	public ResumenPartida() {
		this.id_partida = id_partida;
		this.nom_jugador = nom_jugador;
		this.ronda_maxima = ronda_maxima;
		this.cumulado_final = cumulado_final;
	}

	public int getId_partida() {
		return id_partida;
	}

	public void setId_partida(int id_partida) {
		this.id_partida = id_partida;
	}

	public String getNom_jugador() {
		return nom_jugador;
	}

	public void setNom_jugador(String nom_jugador) {
		this.nom_jugador = nom_jugador;
	}

	public int getRonda_maxima() {
		return ronda_maxima;
	}

	public void setRonda_maxima(int ronda_maxima) {
		this.ronda_maxima = ronda_maxima;
	}

	public int getCumulado_final() {
		return cumulado_final;
	}

	public void setCumulado_final(int cumulado_final) {
		this.cumulado_final = cumulado_final;
	}

}
