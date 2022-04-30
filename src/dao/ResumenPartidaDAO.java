package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.PreparedStatement;
import clases.ResumenPartida;
import conexionBD.ConexionMySQL;
import interfaces.IResumenPartidaDAO;

public class ResumenPartidaDAO implements IResumenPartidaDAO {
	ArrayList<ResumenPartida> miResumen = new ArrayList<ResumenPartida>();

	@Override
	public ArrayList<ResumenPartida> resumen() {
		ConexionMySQL con = new ConexionMySQL();
		con.conectarse();
		try {
			PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(
					"SELECT rondapartida.id_partida,nom_jugador,id_ronda as ronda_maxima,acumulado from rondapartida,partida,jugador WHERE rondapartida.id_partida = partida.id_partida and jugador.id_jugador = partida.id_jugador");
			ResultSet rs = (ResultSet) pstm.executeQuery();
			while (rs.next()) {
				miResumen.add(new ResumenPartida(rs.getInt("rondapartida.id_partida"), rs.getString("nom_jugador"),
						rs.getInt("ronda_maxima"), rs.getInt("acumulado")));
			}
			pstm.execute();
			// System.out.println("Registros listados correctamente");
			pstm.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		con.desconectar();
		return miResumen;

	}
}
