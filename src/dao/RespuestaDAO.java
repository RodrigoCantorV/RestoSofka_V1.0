package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import clases.Respuesta;
import conexionBD.ConexionMySQL;
import interfaces.IRespuestaDAO;

public class RespuestaDAO implements IRespuestaDAO {
	static Respuesta[] miRespuesta;

	@Override
	public void crearRespuesta(Respuesta objRespuesta) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("INSERT INTO respuesta(solucion,respuesta,id_pregunta) VALUES(?,?,?)");
			pstm.setString(1, objRespuesta.getSolucion());
			pstm.setInt(2, objRespuesta.getRespuesta_correcta());
			pstm.setInt(3, objRespuesta.getId_pregunta());

			pstm.execute();
			System.out.println("Registros insertados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public void modificarRespuesta(Respuesta objRespuesta) {

		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(
					"UPDATE respuesta SET solucion =? WHERE id_respuesta=? && respuesta.id_pregunta = ?");
			pstm.setString(1, objRespuesta.getSolucion());
			pstm.setInt(2, objRespuesta.getRespuesta_id());
			pstm.setInt(3, objRespuesta.getId_pregunta());
			pstm.execute();
			System.out.println("Registro modificado correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public void eliminarRespuesta(Respuesta objRespuesta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarRespuestaPorID(int id) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(
					"SELECT respuesta.id_pregunta,interrogante,id_respuesta,solucion,respuesta FROM respuesta,pregunta where pregunta.id_pregunta = respuesta.id_pregunta and pregunta.id_pregunta ="
							+ id);
			ResultSet rs = (ResultSet) pstm.executeQuery();
			rs.next();

			System.out.println("\n\tPregunta: ");
			System.out.println();
			System.out.println(rs.getString("interrogante"));
			System.out.println();
			System.out.println("Lista de respuestas: \n");
			System.out.println("N° pregunta" + "\tRespuesta");
			System.out.println("------------------------------------------------");

			do {
				System.out.println("\t" + rs.getInt("id_respuesta") + " \t" + rs.getString("solucion") + " "
						+ rs.getInt("respuesta"));
			} while (rs.next());

			pstm.execute();
			System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public Respuesta[] ObtenerRespuestaPorID(int id) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(
					"SELECT respuesta.id_pregunta,interrogante,id_respuesta,solucion,respuesta FROM respuesta,pregunta where pregunta.id_pregunta = respuesta.id_pregunta and pregunta.id_pregunta = "
							+ id);
			ResultSet rs = (ResultSet) pstm.executeQuery();
			miRespuesta = new Respuesta[4];
			for (int i = 0; i < miRespuesta.length; i++) {
				rs.next();
				miRespuesta[i] = new Respuesta(rs.getInt("id_respuesta"), rs.getString("solucion"),
						rs.getInt("respuesta"), rs.getInt("respuesta.id_pregunta"));
			}

			pstm.execute();
			// System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
		return miRespuesta;
	}
}
