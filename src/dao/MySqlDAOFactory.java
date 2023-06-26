package dao;

import interfaces.InformeDAO;
import interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuario() {
		return new MySqlUsuarioDAO();
	}
	@Override
	public InformeDAO getInforme() {
		return new MySqlInformeDAO();
	}

}
