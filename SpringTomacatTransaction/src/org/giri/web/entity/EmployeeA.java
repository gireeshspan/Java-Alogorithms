package org.giri.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.giri.web.dao.uid.BaseEntity;
import org.giri.web.dao.uid.UniqueIDForUUID;
import org.hibernate.annotations.GenericGenerator;



@Entity
@Table(name = "EmployeeA")
public class EmployeeA implements BaseEntity, Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2967097059160593954L;

	@Id
	@GenericGenerator(name = "wsc-uuid", strategy = "org.giri.web.dao.uid.SpanUUIDGenerator")
	@GeneratedValue(generator = "wsc-uuid")
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private long age;

	public EmployeeA(String id, String name, long age)
	{
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public EmployeeA(String name, long age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	public EmployeeA()
	{

	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getAge()
	{
		return age;
	}

	public void setAge(long age)
	{
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "EmployeeA [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public String getIdentifierID()
	{
		return Integer.toString(UniqueIDForUUID.COMPANYA.getValue());
	}
}
