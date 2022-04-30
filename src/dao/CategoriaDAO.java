package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import conexionBD.ConexionMySQL;
import interfaces.ICategoriaDAO;

public class CategoriaDAO implements ICategoriaDAO {

	private int puntajeCategoria;

	@Override
	public void listarCategoria() {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("SELECT * FROM categoria");
			ResultSet rs = (ResultSet) pstm.executeQuery();
			System.out.println("Lista de categorias: \n");
			System.out.println("   Id categoria" + "   id dificultad" + "\t   id ronda" + "\tNombre categoria");
			System.out.println("-----------------------------------------------------------------------");
			while (rs.next()) {
				System.out.println("\t" + rs.getInt("id_categoria") + "\t\t" + rs.getInt("id_dificultad") + "\t\t "
						+ rs.getString("id_ronda") + "\t\t " + rs.getString("nom_categoria"));
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
	public int obtenerPuntaje(int categoria) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(
					"SELECT premio FROM categoria,ronda WHERE categoria.id_ronda = ronda.id_ronda and categoria.id_categoria ="
							+ categoria);
			ResultSet rs = (ResultSet) pstm.executeQuery();
			rs.next();
			puntajeCategoria = rs.getInt("premio");
			pstm.execute();
			// System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
		return puntajeCategoria;
	}

}
