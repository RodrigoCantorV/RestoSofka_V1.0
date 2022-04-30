package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import clases.Jugador;
import conexionBD.ConexionMySQL;
import interfaces.IJugadorDAO;

public class JugadorDAO implements IJugadorDAO {
	private static int id_jugador;

	@Override
	public void crearJugador(Jugador objJugador) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("INSERT INTO jugador(nom_jugador) VALUES(?)");
			pstm.setString(1, objJugador.getJugador_nom());
			pstm.execute();
			System.out.println("Registros insertados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public void listarJugador() {
		// TODO Auto-generated method stub

	}

	@Override
	public int obtenerUltimoJugador() {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("SELECT count(id_jugador) as id_jugador FROM jugador");
			ResultSet rs = (ResultSet) pstm.executeQuery();
			rs.next();
			id_jugador = rs.getInt("id_jugador");
			pstm.execute();
			// System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
		return id_jugador;
	}
}
