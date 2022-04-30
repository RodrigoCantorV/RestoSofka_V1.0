package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import clases.Partida;
import conexionBD.ConexionMySQL;
import interfaces.IPartidaDAO;

public class PartidaDAO implements IPartidaDAO {

	private static int ultimaPartida;

	@Override
	public void crearPartida(Partida objPartida) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("INSERT INTO partida (id_jugador,acumulado) VALUES(?,?)");
			pstm.setInt(1, objPartida.getJugador_id());
			pstm.setInt(2, objPartida.getAcumulado_partida());
			pstm.execute();
			System.out.println("Registros insertados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}

	@Override
	public void listarPartida() {
		// TODO Auto-generated method stub

	}

	@Override
	public int obtenerPartida() {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("SELECT count(id_partida) as ultimaPartida FROM partida ");
			ResultSet rs = (ResultSet) pstm.executeQuery();
			rs.next();
			ultimaPartida = rs.getInt("ultimaPartida");

			pstm.execute();
			// System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
		return ultimaPartida;

	}
}
