package dominio.dao;

import javax.persistence.EntityManager;

import controle.util.JpaDAO;
import dominio.Disciplina;

public class DisciplinaDAO extends JpaDAO<Disciplina> {

	public DisciplinaDAO() {
		super();
	}

	public DisciplinaDAO(EntityManager manager) {
		super(manager);
	}

}