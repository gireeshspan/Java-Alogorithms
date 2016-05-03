package org.giri.web.utils;

import java.util.StringTokenizer;

public final class Utils
{
	/**
	 * Logger object for StateChangeListenerImpl
	 * 
	 * private static final Logger LOG = LoggerFactory.getLogger(Utils.class);
	 */

	/**
	 * Private constructor to prevent creating duplicate object.
	 */
	private Utils()
	{
	}

	/**
	 * Checks whether give input string is empty.
	 * 
	 * @param str
	 *            input string to check for empty
	 * @return true if not empty else false
	 */
	public static boolean isNotEmpty(String str)
	{
		return (str == null ? false : true) && (str.trim().length() == 0 ? false : true);
	}

	/**
	 * Method to check the given object is null or not
	 * 
	 * @param object
	 *            - Object to check null or not
	 * @return - Returns TRUE if the object is not null, FALSE otherwise
	 */
	public static boolean isNotNull(Object object)
	{
		return object == null ? false : true;
	}

	/**
	 * Method to check the given object is null or not
	 * 
	 * @param object
	 *            - Object to check null or not
	 * @return - Returns TRUE if the object is null, FALSE otherwise
	 */
	public static boolean isNull(Object object)
	{
		return object == null ? true : false;
	}

	/**
	 * Constructs a string tokenizer for the specified string
	 * 
	 * @param str
	 *            - String value
	 * @param delim
	 *            - Delimitor value
	 * @return - Returns array of tokens
	 */
	public static String[] tokenize(String str, String delim)
	{
		String[] token = null;

		if (str != null && delim != null)
		{
			StringTokenizer tokens = new StringTokenizer(str, delim);
			int size = tokens.countTokens();
			token = new String[size];

			for (int i = 0; i < size; i++)
			{
				token[i] = tokens.nextToken();
			}
		}

		return token;
	}
}
