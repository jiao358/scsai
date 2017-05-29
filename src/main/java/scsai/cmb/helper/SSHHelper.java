package scsai.cmb.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHHelper {
	public static String exec(String host,String user,String psw,int port,String command){
		String result="";
		Session session =null;
		ChannelExec openChannel =null;
		try {
			JSch jsch=new JSch();
			session = jsch.getSession(user, host, port);
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.setPassword(psw);
			session.setTimeout(2000);
			session.connect();
			openChannel = (ChannelExec) session.openChannel("exec");
			openChannel.setCommand(command);
			int exitStatus = openChannel.getExitStatus();
			System.out.println(exitStatus);
			openChannel.connect();  
            InputStream in = openChannel.getInputStream();  
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));  
            String buf = null;
            while ((buf = reader.readLine()) != null) {
            	result+= new String(buf.getBytes("gbk"),"UTF-8")+"    <br>\r\n";  
            }  

		} catch (JSchException | IOException e) {
			result+=e.getMessage();
		}finally{
			if(openChannel!=null){
				openChannel.disconnect();
			}
			if(session!=null&&session.isConnected()){
				session.disconnect();
			}
		}
		return result;
	}
	
	
	
	public static void main(String args[]){
		String[] hosts= {"192.168.0.202","192.168.0.206","192.168.0.207","192.168.0.208","192.168.0.209",
		"192.168.0.210","192.168.0.211","192.168.0.212","192.168.0.130","192.168.0.140","192.168.0.141","192.168.0.142",
		"192.168.0.131"};
		for(String host:hosts){
			try{
				System.out.println("start shutdown host->"+host);
				String exec = exec(host, "root", "pino", 22, "shutdown -h now");
			}catch (Exception e) {
				System.out.println("Host:"+host+" is not open..");
			}
		}
	}
}
