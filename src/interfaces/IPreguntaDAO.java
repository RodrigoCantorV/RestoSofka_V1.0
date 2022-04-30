package interfaces;

import clases.Pregunta;

public interface IPreguntaDAO {

	public void crearPregunta(Pregunta objPregunta);

	public void modificarPregunta(Pregunta objPregunta);

	public void eliminarPregunta(Pregunta objPregunta);

	public void listarPregunta();

	public Pregunta[] listarPreguntaAletoriaCategoria(int cate);

	public int obtenerultimaPregunta();
}
