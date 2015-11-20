package dominio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controle.util.JpaDAO;
import dominio.Professor;

public class ProfessorDAO extends JpaDAO<Professor> {

	public ProfessorDAO() {
		super();
	}

	public ProfessorDAO(EntityManager manager) {
		super(manager);
	}

	public Professor lerPorLogin(String email) {
		Professor resultado;

		Query query = this.getEntityManager().createQuery(
				"FROM Professor p WHERE p.email = :email");

		query.setParameter("email", email);

		try {
			resultado = (Professor) query.getSingleResult();
		} catch (NoResultException e) {
			resultado = null;
		}
		return resultado;
	}
}
