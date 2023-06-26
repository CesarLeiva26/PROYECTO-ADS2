package service;

import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;
import utils.Constantes;

public class UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	UsuarioDAO objPro = fabrica.getUsuario();
	public UsuarioDTO loginusuario(String login, String password) {	
		return objPro.loginUsuario(login, password) ;
	}

}
