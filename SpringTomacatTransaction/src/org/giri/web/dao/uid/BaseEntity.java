package org.giri.web.dao.uid;

import javax.persistence.Transient;

public interface BaseEntity
{
	@Transient
	String getIdentifierID();
}
