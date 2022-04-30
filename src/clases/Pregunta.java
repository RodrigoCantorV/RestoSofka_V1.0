package clases;

public class Pregunta {

	private int pre_id;
	private int pre_id_cate;
	private String interrogante;
	private static int idSiguiente = 26;

	public Pregunta(int pre_id, int pre_id_cate, String interrogante) {

		this.pre_id = pre_id;
		this.pre_id_cate = pre_id_cate;
		this.interrogante = interrogante;
	}

	public Pregunta(int pre_id_cate, String interrogante) {
		pre_id = idSiguiente;
		idSiguiente++;
		this.pre_id_cate = pre_id_cate;
		this.interrogante = interrogante;
	}

	public Pregunta() {
		// TODO Auto-generated constructor stub
	}

	public int getPre_id() {
		return pre_id;
	}

	public void setPre_id(int pre_id) {
		this.pre_id = pre_id;
	}

	public int getPre_id_cate() {
		return pre_id_cate;
	}

	public void setPre_id_cate(int pre_id_cate) {
		this.pre_id_cate = pre_id_cate;
	}

	public String getInterrogante() {
		return interrogante;
	}

	public void setInterrogante(String interrogante) {
		this.interrogante = interrogante;
	}

}
