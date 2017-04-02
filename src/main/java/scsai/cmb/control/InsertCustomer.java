package scsai.cmb.control;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scsai.cmb.datasource.entity.Custom;
import scsai.cmb.datasource.inf.CustomMapper;
import scsai.cmb.helper.Helper;

@Controller
@RequestMapping(value="/insert")
public class InsertCustomer {
	private static final Logger logger = Logger.getLogger(InsertCustomer.class);
	@Autowired
	private CustomMapper dao;
	
	@RequestMapping(value="/customer.do",method=RequestMethod.POST)
	public void customerInsert(HttpServletRequest request ,HttpServletResponse response) throws Exception{
		Map bean=  Helper.initResponse();
		Custom cust = new Custom();
		parseCustom(request, cust);
		dao.insert(cust);
		Helper.restful(response, bean);;
	}
	
	private void parseCustom(HttpServletRequest request,Custom cust){
		Map<String,String[]> map=request.getParameterMap();
		
		cust.setSex(Integer.valueOf(map.get("SEX")[0].toString()));
		cust.setAddress(map.get("ADDRESS")[0].toString());
		cust.setCardNumb(map.get("CARDNUMB")[0].toString());
		cust.setCardType(map.get("CARDTYPE")[0].toString());
		cust.setCreateDate(new Date());
		cust.setName(map.get("NAME")[0].toString());
		cust.setPhone(map.get("PHONE")[0].toString());
	}
	
}
