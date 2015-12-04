package dominio.dao;

import javax.persistence.EntityManager;

import controle.util.JpaDAO;
import dominio.Edital;

public class EditalDAO extends JpaDAO<Edital> {

	public EditalDAO() {
		super();
	}

	public EditalDAO(EntityManager manager) {
		super(manager);
	}

}