package br.eti.webstuff.iniciandoComJPA.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.eti.webstuff.iniciandoComJPA.util.JPAUtil;

public abstract class GenericDAO<T extends Serializable> {

	private Class<T> aClass;

	protected GenericDAO(Class<T> aClass) {
		this.aClass = aClass;
	}

	protected EntityManager getEntityManager() {
		return JPAUtil.getInstance().getEntityManager();
	}

	public void save(T entity) {

		EntityManager entityManager = getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void update(T entity) {

		EntityManager entityManager = getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();

	}

	public void delete(Long id) {

		EntityManager entityManager = getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.remove(entityManager.getReference(aClass, id));
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public T searchById(Long id) {

		EntityManager entityManager = getEntityManager();

		entityManager.getTransaction().begin();

		T entity = (T) entityManager.find(aClass, id);

		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	public long count() {

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
<<<<<<< HEAD
		
		Query query = entityManager.createQuery("select count(c) from " + aClass.getSimpleName() + " c");
		
=======

		Query query = entityManager.createQuery("select count(c) from " + aClass.getSimpleName() + " c");

>>>>>>> aula-10
		long count = (Long) query.getSingleResult();

		entityManager.getTransaction().commit();
		entityManager.close();

		return count;
	}

	@SuppressWarnings("unchecked")
	public T findOne(String jpql, Object... params) {

		EntityManager entityManager = getEntityManager();

		entityManager.getTransaction().begin();

		// Exemplo JPQL: "from Person p where p.name like ? and p.age = ?"
		Query query = entityManager.createQuery(jpql);

		for (int i = 0; i < params.length; i++) {
			query.setParameter(i + 1, params[i]);
		}

		T entity = (T) query.getSingleResult();

		entityManager.getTransaction().commit();
		entityManager.close();

		return entity;

	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String jpql, Object... params) {
		
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		Query query = manager.createQuery(jpql);
		
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		
		List<T> entities = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		
		return entities;
	}
	

	@SuppressWarnings("unchecked")
	public List<T> findT(String jpql, String param) {
		
		EntityManager manager = getEntityManager();
		manager.getTransaction().begin();
		
		//FIXME: BANCO -> select * from jpabd.persons p where p.last_name like "Oliveira";
		Query query = manager.createQuery(jpql);
		
		query.setParameter(1, param);
			
		List<T> entities = query.getResultList();
		
		manager.getTransaction().commit();
		manager.close();
		
		return entities;
	}

	
	@SuppressWarnings("unchecked")
	public List<T> findAllByJPQL() {

		EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();

		Query query = entityManager.createQuery("from " + aClass.getSimpleName());

		List<T> list = query.getResultList();

		entityManager.close();
		return list;
	}

<<<<<<< HEAD
	
=======
>>>>>>> aula-10
	public List<T> findAllByCriteria() {

		EntityManager entityManager = getEntityManager();

		entityManager.getTransaction().begin();

		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(aClass);
		query.select(query.from(aClass));

		List<T> list = entityManager.createQuery(query).getResultList();

		entityManager.close();
		return list;
	}

}
