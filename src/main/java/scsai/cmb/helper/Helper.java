package scsai.cmb.helper;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

public class Helper {
	private static final String ENCODING="UTF-8";
	public static void restful(HttpServletResponse  response , Object bean) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		response.setHeader("Context-Type", "application/json;charset=UTF-8");
		PrintWriter pw  = response.getWriter();
		String json = mapper.writeValueAsString(bean);
		pw.println(json);
		pw.flush();
	}
	
	public static Map initResponse(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("state", "1");
		map.put("code", "");
		map.put("message", "");
		return map;
	}
}
