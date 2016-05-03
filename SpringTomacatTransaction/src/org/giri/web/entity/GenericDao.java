package org.giri.web.entity;

public interface GenericDao<T>
{
		void create(T entity);
		
		void update(T entity);
		
		void delete(T entity);
		
		T load(Class<T> entityClass, Object entityId );
		
		T load(Class<T> entityClass, long entityId);
}
