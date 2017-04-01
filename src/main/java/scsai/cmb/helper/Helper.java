package scsai.cmb.helper;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

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
}
