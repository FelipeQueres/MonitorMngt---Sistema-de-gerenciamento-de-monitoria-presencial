package controle.util;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class GenericDAO<T> {
	public abstract EntityManager getEntityManager();

	public abstract T lerPorId(Object id);

	public abstract List<T> lerTodos();

	public abstract T salvar(T objeto);

	public abstract void excluir(T objeto);

	public abstract void abrirTransacao();

	public abstract void gravarTransacao();

	public abstract void desfazerTransacao();

}