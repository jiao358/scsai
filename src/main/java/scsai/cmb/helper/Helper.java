package scsai.cmb.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import scsai.cmb.control.KillSystem;

public class Helper {
	private static final String ENCODING="UTF-8";
	private static final Logger logger = Logger.getLogger(Helper.class);
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
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "1");
		map.put("code", "");
		map.put("message", "");
		return map;
	}
	public static void processError(HttpServletResponse  response){
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "2");
		map.put("code", "");
		map.put("message", "sometings error");
	}
}
