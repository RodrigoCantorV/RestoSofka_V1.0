package dao;

import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import clases.Ronda_Partida;
import conexionBD.ConexionMySQL;
import interfaces.IRonda_PartidaDAO;

public class Ronda_PartidaDAO implements IRonda_PartidaDAO {

	@Override
	public void crearRondaPartida(Ronda_Partida objetoRonda_Partida) {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection()
					.prepareStatement("INSERT INTO rondapartida(id_ronda,id_partida) VALUES(?,?)");
			pstm.setInt(1, objetoRonda_Partida.getId_ronda());
			pstm.setInt(2, objetoRonda_Partida.getId_partida());
			pstm.execute();
			System.out.println("Registros insertados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();

	}
}
