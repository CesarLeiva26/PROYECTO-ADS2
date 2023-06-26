package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MysqlDBConexion;

public class MySqlUsuarioDAO implements UsuarioDAO{

	@Override
	public UsuarioDTO loginUsuario(String login, String password) {
		UsuarioDTO usu = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String sql = "select * from usuario where usuario=? and contra=?";
			cn = MysqlDBConexion.getConexion();
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, login);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            if(rs.next()) {
            	usu = new UsuarioDTO();
            	usu.setCodigo(rs.getInt(1));
            	usu.setUsuario(rs.getString(2));
            	usu.setContraseña(rs.getString(3));
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstm != null)
                    pstm.close();
                if (cn != null)
                    cn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		return usu;
	}
 }