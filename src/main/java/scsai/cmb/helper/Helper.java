package scsai.cmb.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import scsai.cmb.control.KillSystem;

public class Helper {
	private static final String ENCODING="UTF-8";
	private static final Logger logger = Logger.getLogger(Helper.class);
	private static String IP=null;
	
	
	private static void ipinit(){
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements())
			{
			NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
			if(!netInterface.getName().equals("eth0")){
				continue;
			}
			Enumeration addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements())
			{
			ip = (InetAddress) addresses.nextElement();
			if (ip != null && ip instanceof Inet4Address)
			{
				IP=ip.getHostAddress();
			} 
			}
			}	
		} catch (SocketException e) {
			logger.error("IP initError!");
		}
		
	}
	
	
	
	public static void restful(HttpServletResponse  response , Object bean) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		response.setHeader("Context-Type", "application/json;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter pw  = response.getWriter();
		String json = mapper.writeValueAsString(bean);
		pw.println(json);
		pw.flush();
		
		logger.info("Response:"+json);
		
	}
	
	public static Map initResponse(){
		if(IP==null)
			ipinit();
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "1");
		map.put("code", "");
		map.put("message", "");
		map.put("ip", IP);
		return map;
	}
	public static void processError(HttpServletResponse  response){
		if(IP==null)
			ipinit();
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "2");
		map.put("code", "");
		map.put("message", "sometings error");
		map.put("ip", IP);
	}
}
