package interfaces;

import clases.Respuesta;

public interface IRespuestaDAO {
	public void crearRespuesta(Respuesta objRespuesta);

	public void modificarRespuesta(Respuesta objRespuesta);

	public void eliminarRespuesta(Respuesta objRespuesta);

	public void listarRespuestaPorID(int id);

	public Respuesta[] ObtenerRespuestaPorID(int id);
}
