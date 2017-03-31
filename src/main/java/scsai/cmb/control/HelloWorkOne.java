package scsai.cmb.control;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scsai.cmb.datasource.inf.BookTypeMapper;

@Controller
public class HelloWorkOne {

	 @Autowired  
	 private BookTypeMapper btm;
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public void sayHello(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		Map map  = new HashMap<String,String>();
		map.put("name", "pino");
		System.out.println(btm);
		long x=btm.countByExample(null);
		System.out.println("get the long "+ x);
//		Helper.restful(response, map);
		String msg = "{msg:"+x+"}";
		response.addHeader("Context-Type","application/json");
		PrintWriter pw = response.getWriter();
		pw.println(msg);
		pw.flush();
		
		
	}
}
