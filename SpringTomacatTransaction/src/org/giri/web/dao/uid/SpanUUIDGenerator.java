package org.giri.web.dao.uid;

import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.lang.reflect.Method;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class SpanUUIDGenerator implements IdentifierGenerator
{
	/**
	 * IDGenrator object
	 */
	
	private static IDGenerator uuidGen;

	/**
	 * Set the generator Id object.
	 * 
	 * @param generator
	 */
	@Autowired
	public void setUUIDGenerator(IDGenerator generator)
	{
		initializeUUIDGenerator(generator);
	}

	/**
	 * Method to set the static IDGenrator object
	 * 
	 * @param generator
	 *            - IDGenrator Object
	 */
	private static void initializeUUIDGenerator(IDGenerator generator)
	{
		uuidGen = generator;
	}

	/**
	 * Generate the serialized id.
	 * 
	 * @param session
	 * @param object
	 *            .
	 */
	public Serializable generate(SessionImplementor session, Object object)
	{
		try
		{
			Class<?>[] parameterType = null;
			Object[] params = null;
			Method method = object.getClass().getMethod("getIdentifierID", parameterType);
			String id = (String) method.invoke(object, params);
			return uuidGen.getUniqueID(id);
		}
		catch (Exception e)
		{
			throw new HibernateException("Unable to get UUID identifier key from entity object " + object
					+ ", make sure it implements org.giri.web.dao.uid.BaseEntity", e);
		}
	}

}
