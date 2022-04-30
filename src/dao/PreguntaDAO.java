package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import clases.Pregunta;
import conexionBD.ConexionMySQL;
import interfaces.IPreguntaDAO;

public class PreguntaDAO implements IPreguntaDAO {

	static int ultimapregunta;
	static Pregunta[] miPregunta;

	@Override
	public void crearPregunta(Pregunta objPregunta) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("INSERT INTO pregunta(id_categoria,interrogante) VALUES(?,?)");
			pstm.setInt(1, objPregunta.getPre_id_cate());
			pstm.setString(2, objPregunta.getInterrogante());
			pstm.execute();
			System.out.println("Registros insertados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
	}

	@Override
	public void modificarPregunta(Pregunta objPregunta) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("UPDATE pregunta SET id_categoria =?,interrogante=? WHERE id_pregunta=?");
			pstm.setInt(1, objPregunta.getPre_id_cate());
			pstm.setString(2, objPregunta.getInterrogante());
			pstm.setInt(3, objPregunta.getPre_id());

			pstm.execute();
			System.out.println("Registro modificado correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public void eliminarPregunta(Pregunta objPregunta) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("DELETE from pregunta WHERE id_pregunta =?");
			pstm.setInt(1, objPregunta.getPre_id());
			pstm.execute();
			System.out.println("Registro Eliminado correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public void listarPregunta() {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT * FROM pregunta");
			ResultSet rs = (ResultSet) pstm.executeQuery();
			System.out.println("Lista de preguntas: \n");
			System.out.println("N° pregunta" + "\tcategoria" + "\tInterrogante");
			System.out.println("------------------------------------------------");
			while (rs.next()) {
				System.out.println("\t" + rs.getInt("id_pregunta") + " \t" + rs.getInt("id_categoria") + "\t\t "
						+ rs.getString("interrogante"));
			}

			pstm.execute();
			System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public int obtenerultimaPregunta() {

		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("SELECT count(*)  as cantidad FROM pregunta");
			ResultSet rs = (ResultSet) pstm.executeQuery();
			rs.next();
			ultimapregunta = rs.getInt("cantidad");

			pstm.execute();
			System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}

		con.desconectar();
		return ultimapregunta;
	}

	@Override
	public Pregunta[] listarPreguntaAletoriaCategoria(int cate) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(
					"SELECT id_pregunta,id_categoria,interrogante FROM pregunta WHERE id_categoria = " + cate);
			ResultSet rs = (ResultSet) pstm.executeQuery();

			miPregunta = new Pregunta[5];
			for (int i = 0; i < miPregunta.length; i++) {
				rs.next();
				// miPregunta[i] = new Pregunta(cate, rs.getString("interrogante"));
				miPregunta[i] = new Pregunta(rs.getInt("id_pregunta"), rs.getInt("id_categoria"),
						rs.getString("interrogante"));
			}

			pstm.execute();
			// System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
		return miPregunta;
	}
}
