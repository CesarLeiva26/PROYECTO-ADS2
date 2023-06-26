package interfaces;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	
	public UsuarioDTO loginUsuario(String login, String password);

}
