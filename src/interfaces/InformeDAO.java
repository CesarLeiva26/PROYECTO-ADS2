package interfaces;

import java.util.List;

import beans.InformeDTO;

public interface InformeDAO {
	
	public List<InformeDTO> listarInforme();

    public int registrarInforme(InformeDTO obj);
    
}
