package scsai.cmb.control;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scsai.cmb.datasource.inf.BookTypeMapper;
import scsai.cmb.helper.Helper;
import scsai.cmb.helper.TokenEntrypt;

@Controller
public class HelloWorkOne {
	private static final Logger logger = Logger.getLogger(HelloWorkOne.class);
	 @Autowired  
	 private BookTypeMapper btm;
	
	 @RequestMapping(value="/error.do",method=RequestMethod.GET)
	public void getError(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		 logger.error("Test error 500 page");
//		 response.sendRedirect("scsai/static/500.html");
		 request.getRequestDispatcher("/static/500.html").forward(request,response);
	}
	 @RequestMapping(value="/error2.do",method=RequestMethod.GET)
		public void getError2(HttpServletRequest request,HttpServletResponse response) throws Exception{
			
		 	throw  new Exception("eeror");
		}
	 
	 /**
	  * return the decrypt 
	  */
	 @RequestMapping(value="/decrypt.do",method=RequestMethod.POST)
	 public void postPasswd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 String str=request.getParameter("token");
		 logger.info("now decrypt content ->" + str);
		 String passwd= TokenEntrypt.decrypt(str);
		 logger.info("now decrypt over content is -->"+ passwd);
		 Map result = Helper.initResponse();
		 result.put("decrypt", passwd);
		 Helper.restful(response, result);;
	 }
	 
	 @RequestMapping(value="/encrypt/{str}.do")
	 public void getEncrypt(HttpServletRequest request,HttpServletResponse response,@PathVariable String str) throws Exception{
		 String passwd= TokenEntrypt.encrypt(str);
		 Map result = Helper.initResponse();
		 result.put("encrypt", passwd);
		 Helper.restful(response, result);;
	 }
	 
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public void getSayHello(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
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
	@RequestMapping(value="/hello.do",method=RequestMethod.GET)
	public void getHello2(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		request.getHeaderNames();
		int length=request.getContentLength();
		String contentType=request.getContentType();
		String addr=request.getLocalAddr();
		String servletPath=request.getServletPath();
		String servletName=request.getServerName();
		String method=request.getMethod();
		String scheme=request.getScheme();
		String protocol=request.getProtocol();
		String queryString=request.getQueryString();
		
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
