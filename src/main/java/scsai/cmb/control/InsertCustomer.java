package scsai.cmb.control;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scsai.cmb.datasource.entity.Custom;
import scsai.cmb.datasource.inf.CustomMapper;
import scsai.cmb.helper.Helper;

@Controller(value="/insert")
public class InsertCustomer {

	@Autowired
	private CustomMapper dao;
	
	@RequestMapping(value="/customer",method=RequestMethod.POST)
	public void customerInsert(HttpServletRequest request ,HttpServletResponse response) throws Exception{
		Map bean=  Helper.initResponse();
		Custom cust = new Custom();
		parseCustom(request, cust);
		dao.insert(cust);
		Helper.restful(response, bean);;
	}
	
	private void parseCustom(HttpServletRequest request,Custom cust){
		Map map=request.getParameterMap();
		cust.setSex(Integer.valueOf(map.get("SEX").toString()));
		cust.setAddress(map.get("ADDRESS").toString());
		cust.setCardNumb(map.get("CARDNUMB").toString());
		cust.setCardType(map.get("CARDTYPE").toString());
		cust.setCreateDate(new Date());
		cust.setName(map.get("NAME").toString());
		cust.setPhone(map.get("PHONE").toString());
	}
	
}
