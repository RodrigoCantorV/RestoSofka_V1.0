package clases;

public class Categoria {
	private int categoria_id;
	private int categoria_dif_id;
	private int categoria_id_ronda;
	private String categoria_nom;
	
	public Categoria(int categoria_id, int categoria_dif_id, int categoria_id_ronda, String categoria_nom) {
		this.categoria_id = categoria_id;
		this.categoria_dif_id = categoria_dif_id;
		this.categoria_id_ronda = categoria_id_ronda;
		this.categoria_nom = categoria_nom;
	}

	public int getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(int categoria_id) {
		this.categoria_id = categoria_id;
	}

	public int getCategoria_dif_id() {
		return categoria_dif_id;
	}

	public void setCategoria_dif_id(int categoria_dif_id) {
		this.categoria_dif_id = categoria_dif_id;
	}

	public int getCategoria_id_ronda() {
		return categoria_id_ronda;
	}

	public void setCategoria_id_ronda(int categoria_id_ronda) {
		this.categoria_id_ronda = categoria_id_ronda;
	}

	public String getCategoria_nom() {
		return categoria_nom;
	}

	public void setCategoria_nom(String categoria_nom) {
		this.categoria_nom = categoria_nom;
	}
	
}
