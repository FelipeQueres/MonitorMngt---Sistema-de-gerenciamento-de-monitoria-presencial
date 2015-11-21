package dominio.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import controle.util.JpaDAO;
import dominio.Funcionario;

public class FuncionarioDAO extends JpaDAO<Funcionario> {

	public FuncionarioDAO() {
		super();
	}
	
	public FuncionarioDAO(EntityManager manager) {
		super(manager);
	}

	public Funcionario lerPorLogin(String email) {
		Funcionario resultado;

		Query query = this.getEntityManager().createQuery(
				"FROM Funcionario a WHERE a.email = :email");

		query.setParameter("email", email);

		try {
			resultado = (Funcionario) query.getSingleResult();
		} catch (NoResultException e) {
			resultado = null;
		}
		return resultado;
	}

}
