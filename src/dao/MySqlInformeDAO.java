package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.InformeDTO;
import interfaces.InformeDAO;
import utils.MysqlDBConexion;

public class MySqlInformeDAO implements InformeDAO {

	@Override
	public List<InformeDTO> listarInforme() {
		InformeDTO info = null;
		List<InformeDTO> data = new ArrayList<InformeDTO>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select  i.codigoinforme ,s.nombre, u.distrito ,i.fechaSolicitud, i.numeroInforme, e.Descripcion, e.Impacto, e.estado, i.recomendaciones from informe i inner join solicitante s on s.codigoSolicitante = i.codigoSolicitante inner join ubicacion u on i.codigoUbicacion = u.codigoUbicacion inner join incidente e on e.codigoincidente = i.codigoincidente order by codigoinforme asc";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				info = new InformeDTO(0, sql, sql, sql, sql, sql, sql, sql, sql);
				info.setCodigoInforme(rs.getInt(1));
				info.setNombreSolicitante(rs.getString(2));
				info.setNombreUbicacion(rs.getString(3));
				info.setFechaSolicitud(rs.getString(4));
				info.setNumeroIncidente(rs.getString(5));
				info.setDescripcion(rs.getString(6));
				info.setImpacto(rs.getString(7));
				info.setEstado(rs.getString(8));
				info.setRecomendaciones(rs.getString(9));
				data.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	public int registrarInforme(InformeDTO obj) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "insert into informe values(null,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, obj.getCodigoSolicitante());
			pstm.setInt(2, obj.getCodigoUbicacion());
			pstm.setString(3, obj.getFechaSolicitud());
			pstm.setString(4, obj.getNumeroIncidente());
			pstm.setInt(5,obj.getCodigoIncidente());
			pstm.setString(6, obj.getRecomendaciones());
			estado = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
}
