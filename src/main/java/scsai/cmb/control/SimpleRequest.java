package scsai.cmb.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SimpleRequest {
	private static final Logger logger = Logger.getLogger(InsertCustomer.class);
	@RequestMapping(value="/index.do",method=RequestMethod.GET)
	public void simpleLoginPage(HttpServletRequest request ,HttpServletResponse response) throws Exception{
		request.getRequestDispatcher("/index.html").forward(request, response);
	}
}
