package dominio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controle.util.JpaDAO;
import dominio.Aluno;

public class AlunoDAO extends JpaDAO<Aluno> {

	public AlunoDAO() {
		super();
	}
	
	public AlunoDAO(EntityManager manager) {
		super(manager);
	}

	public Aluno lerPorLogin(String email) {
		Aluno resultado;

		Query query = this.getEntityManager().createQuery(
				"FROM Aluno a WHERE a.email = :email");

		query.setParameter("email", email);

		try {
			resultado = (Aluno) query.getSingleResult();
		} catch (NoResultException e) {
			resultado = null;
		}
		return resultado;
	}

}
