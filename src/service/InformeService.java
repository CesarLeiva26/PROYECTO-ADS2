package service;

import java.util.List;

import beans.InformeDTO;
import dao.DAOFactory;
import interfaces.InformeDAO;
import utils.Constantes;

public class InformeService {
	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
    InformeDAO objPro = fabrica.getInforme();

    public List<InformeDTO> listarInforme() {
        return objPro.listarInforme();
    }

    public int registraInforme(InformeDTO obj) {
        return objPro.registrarInforme(obj);
    }
}
