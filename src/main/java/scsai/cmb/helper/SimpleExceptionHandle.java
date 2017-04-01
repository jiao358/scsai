package scsai.cmb.helper;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class SimpleExceptionHandle implements HandlerExceptionResolver{
	private static final Logger logger = Logger.getLogger(SimpleExceptionHandle.class);
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		logger.error("erorr page handle");
		try {
			arg1.sendRedirect("/static/500.html");
		} catch (IOException e) {
			logger.error("Now 500 Error Arise .",e);
		}
		
		return null;
	}

}
