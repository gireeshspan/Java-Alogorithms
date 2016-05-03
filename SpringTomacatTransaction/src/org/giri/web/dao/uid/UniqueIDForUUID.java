package org.giri.web.dao.uid;

/**
 * Each table primary key identifiers used as part of primary key UUID
 * generation.
 * 
 * <pre>
 * File : UniqueIDForUUID.java
 * User : venkatesha_kc
 * Date : May 15, 2014
 * Time : 11:07:20 AM
 * </pre>
 * 
 * @author Venkatesha K C
 */
public enum UniqueIDForUUID
{
	HEALTH_CENTER(10),

	DEPARTMENT(11),

	USER(12),

	APPOINTMENT(13),

	APPOINTMENTS_TYPE(14),

	DEMOGRAPHICS(15),

	ACTIVE_PROBLEM(16),

	ALLERGIES(17),

	MEDICATION(18),

	DIAGNOSIS(19),

	ENCOUNTER_HISTORY(20),

	PROCEDURES(21),

	USER_TYPE(22),

	VITALS(23),
	
	WEIGHT(24),
	
	HEIGHT(25),
	
	BLOOD_PRESSURE(26),
	
	TEMPERATURE(27),
	
	COMPANYA(28);
	
	

	private int value;

	private UniqueIDForUUID(int i)
	{
		value = i;
	}

	public int getValue()
	{
		return value;
	}
}
