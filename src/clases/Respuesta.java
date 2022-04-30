package clases;

public class Respuesta {

	private int respuesta_id;
	private String solucion;
	private int respuesta_correcta;
	private int id_pregunta;

	public Respuesta() {

	}

	public Respuesta(int respuesta_id, String solucion, int respuesta_correcta, int id_pregunta) {
		this.respuesta_id = respuesta_id;
		this.solucion = solucion;
		this.respuesta_correcta = respuesta_correcta;
		this.id_pregunta = id_pregunta;
	}

	public Respuesta(String solucion, int respuesta_correcta, int id_pregunta) {
		this.solucion = solucion;
		this.respuesta_correcta = respuesta_correcta;
		this.id_pregunta = id_pregunta;
	}

	public Respuesta(String solucion, int respuesta_correcta) {
		this.solucion = solucion;
		this.respuesta_correcta = respuesta_correcta;

	}

	public int getRespuesta_id() {
		return respuesta_id;
	}

	public void setRespuesta_id(int respuesta_id) {
		this.respuesta_id = respuesta_id;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public int getRespuesta_correcta() {
		return respuesta_correcta;
	}

	public void setRespuesta_correcta(int respuesta_correcta) {
		this.respuesta_correcta = respuesta_correcta;
	}

	public int getId_pregunta() {
		return id_pregunta;
	}

	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
}
