package org.giri.web.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.giri.web.entity.GenericDao;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractGenericDao<T> implements GenericDao<T>
{
	
	@PersistenceContext(unitName="PersistenceUnitA")
	private EntityManager entityManager;
	
	@Override
	public void create(T entity)
	{
		entityManager.persist(entity);
	}

	@Override
	public void update(T entity)
	{
		entityManager.merge(entity);
	}

	@Override
	public void delete(T entity)
	{
		entityManager.remove(entity);
	}

	@Override
	public T load(Class<T> entityClass, Object entityId)
	{
		return entityManager.find(entityClass, entityId);
	}

	@Override
	public T load(Class<T> entityClass, long entityId)
	{
		return entityManager.find(entityClass, entityId);
	}

}
