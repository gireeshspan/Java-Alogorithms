package org.giri.web.dao.uid;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Timestamp;

import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.giri.web.dao.uid.IDGenerator;
import org.giri.web.utils.Utils;
@Component
public class JUGIDGenerator implements IDGenerator
{
	private static final Logger LOG = LoggerFactory.getLogger(JUGIDGenerator.class);
	private static UUIDGenerator idGenerator;
	private static String hostIP;
	private static final int MAX_TIMESTAMP_LEN = 22;
	private static final int CONST_INT = 3;
	private static final int SUB_SEQUENCE_INT_MIN = 6;
	private static final int SUB_SEQUENCE_INT_MAX = 8;
	private static final int RAND_INT = 8;

	/**
	 * 
	 */
	static
	{
		idGenerator = UUIDGenerator.getInstance();
		getHostIP();
	}

	/**
	 * Get uniqueID.
	 * 
	 * @param sequenceID
	 *            .
	 */
	public String getUniqueID(String sequenceID) throws Exception
	{
		System.out.println("JUGIDGenerator - getUniqueID()");
		UUID a = idGenerator.generateTimeBasedUUID();
		String id = a.toString();
		String timestamp = getTimestampString();

		int end = MAX_TIMESTAMP_LEN - timestamp.length();
		int index = id.indexOf('-');
		if (index < end)
		{
			end = index;
		}
		if (end < RAND_INT)
		{
			end--;
		}
		StringBuilder sb = new StringBuilder(hostIP + '-' + sequenceID + '-' + timestamp + '-' + id.substring(0, end));
		sb.append("-").append(id.substring(sb.length() + 1));
		return sb.toString();
	}

	/**
	 * Get Host IP address.
	 */
	private static void getHostIP()
	{
		String ip = "127.0.0.1";
		try
		{
			ip = InetAddress.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e)
		{
			LOG.debug("Exception while geting local host address.", e);
		}
		String[] ips = Utils.tokenize(ip, ".");
		StringBuilder sb = new StringBuilder();
		for (String s : ips)
		{
			String element = Integer.toHexString(Integer.valueOf(s));
			sb.append(element.length() < 2 ? '0' + element : element);
		}
		hostIP = sb.toString();
	}

	/**
	 * Get time stamp as string.
	 * 
	 * @return
	 */
	private String getTimestampString()
	{
		return Long.toHexString(System.currentTimeMillis());
	}

	/**
	 * Decode the given id.
	 * 
	 * @param id
	 * @return
	 */
	public String decode(String id)
	{
		String[] parts = Utils.tokenize(id, "-");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < CONST_INT; i++)
		{
			sb.append(Integer.decode("0X" + parts[0].substring(2 * i, 2 * i + 2))).append(".");
		}
		sb.append(Integer.decode("0X" + parts[0].subSequence(SUB_SEQUENCE_INT_MIN, SUB_SEQUENCE_INT_MAX)));
		String ip = sb.toString();

		Timestamp timestamp = new Timestamp(Long.decode("0X" + parts[2]));
		return "IP: " + ip + "\nTime: " + timestamp.toString();
	}

	// public static void main(String[] args) throws Exception
	// {
	// JUGIDGenerator iGenerator = new JUGIDGenerator();
	//
	// for (String arg : args)
	// {
	// System.out.println(iGenerator.decode(arg));
	// }
	//
	// }
}
