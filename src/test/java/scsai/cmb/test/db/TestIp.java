package scsai.cmb.test.db;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.junit.Test;

public class TestIp {
	@Test
	public void iptest() throws Exception{
		Enumeration allNetInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ip = null;
		while (allNetInterfaces.hasMoreElements())
		{
		NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
		System.out.println(netInterface.getName());
		Enumeration addresses = netInterface.getInetAddresses();
		while (addresses.hasMoreElements())
		{
		ip = (InetAddress) addresses.nextElement();
		if (ip != null && ip instanceof Inet4Address)
		{
		System.out.println("本机的IP = " + ip.getHostAddress());
		} 
		}
		}
	}
}
