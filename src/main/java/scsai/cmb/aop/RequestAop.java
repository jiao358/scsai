package scsai.cmb.aop;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import scsai.cmb.datasource.entity.RequestInfo;
import scsai.cmb.datasource.inf.RequestInfoMapper;

public class RequestAop {
	private static final Logger logger = Logger.getLogger(RequestAop.class);
	@Autowired
	private RequestInfoMapper requestDao;
	@Transactional
	public void filterRequest(ProceedingJoinPoint  jp){
		HttpServletRequest request=(HttpServletRequest) jp.getArgs()[0];
		String id=UUID.randomUUID().toString(); 
		RequestInfo requestInfo = generateInfo(request);
		try{
			requestInfo.setId(id);
			requestDao.insert(requestInfo);
		}catch (Exception e) {
			logger.error("Insert RequestInfo error",e);
		}
		try{
			jp.proceed();
		
		}catch (Throwable e) {
			logger.error("RequestInfoException arise" + request.getQueryString() ,e);
		}finally{
			requestInfo.setResponseDate(new Date());
			requestDao.updateByPrimaryKey(requestInfo);
		}
		
	}
	
	public void beforeJp(JoinPoint jp){
		
	}
	
	private RequestInfo generateInfo(HttpServletRequest request){
		RequestInfo requestInfo = new RequestInfo();
		Date begin = new Date();
		requestInfo.setCreateDate(begin);
		requestInfo.setContentLength(request.getContentLength());
		requestInfo.setContentType(request.getContentType());
		
		requestInfo.setIsWork(true);
		requestInfo.setLocalAddr(request.getLocalAddr());
		requestInfo.setProtocol(request.getProtocol());
		requestInfo.setQuery(request.getQueryString());
		requestInfo.setRequestMethod(request.getMethod());
		requestInfo.setRequestPath(request.getServletPath());
		requestInfo.setRequestServer(request.getServerName());
		
		 String ip = request.getHeader("x-forwarded-for");   
		  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip) || "null".equalsIgnoreCase(ip))    {     
		    ip = request.getHeader("Proxy-Client-IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)   || "null".equalsIgnoreCase(ip)) {    
		  ip = request.getHeader("WL-Proxy-Client-IP");  
		 }  
		 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)    || "null".equalsIgnoreCase(ip)) {  
		  ip = request.getRemoteAddr();   
		 }  
		requestInfo.setIp(ip);
		return requestInfo;
	}
	
}
