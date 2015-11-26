package dominio.dao;

import javax.persistence.EntityManager;

import controle.util.JpaDAO;
import dominio.AtividadePlanejada;

public class AtividadePlanejadaDAO extends JpaDAO<AtividadePlanejada> {

	public AtividadePlanejadaDAO() {
		super();
	}
	
	public AtividadePlanejadaDAO(EntityManager manager) {
		super(manager);
	}


}
