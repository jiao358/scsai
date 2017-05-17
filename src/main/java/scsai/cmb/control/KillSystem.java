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
import org.springframework.web.bind.annotation.RequestParam;

import scsai.cmb.datasource.entity.BusnessItem;
import scsai.cmb.datasource.entity.BusnessOrder;
import scsai.cmb.datasource.entity.User;
import scsai.cmb.datasource.inf.BusnessItemMapper;
import scsai.cmb.datasource.inf.BusnessOrderMapper;
import scsai.cmb.datasource.inf.CustomMapper;
import scsai.cmb.datasource.inf.UserMapper;
import scsai.cmb.helper.Helper;


@Controller
public class KillSystem {
	private static final Logger logger = Logger.getLogger(KillSystem.class);
	@Autowired
	private UserMapper userDao;
	@Autowired
	private BusnessItemMapper busDao;
	@Autowired
	private CustomMapper custDao;
	@Autowired
	private BusnessOrderMapper orderDao;
	
	// userId=?&busType=?
	@RequestMapping(value="/killsys.do",method=RequestMethod.GET)
	public void postCustomerInsert(HttpServletRequest request ,HttpServletResponse response,@RequestParam("userId")String userId,@RequestParam("busType") String busId ) throws Exception{
		Map<String,String> param=request.getParameterMap();
		Map bean=  Helper.initResponse();
		boolean orderCheck=false;
		BusnessItem busnessItem =null;
		
		synchronized(logger){
			busnessItem = busDao.selectByPrimaryKey(Integer.valueOf(busId));
			if(busnessItem.getTotalNum()>0){
				busnessItem.setTotalNum(busnessItem.getTotalNum()-1);
				busDao.updateByPrimaryKey(busnessItem);
				orderCheck =true;
			}
		}
		
		if(orderCheck){
			User user=userDao.selectByPrimaryKey(Integer.valueOf(userId));
			BusnessOrder order =new BusnessOrder();
			order.setBusnessId(Integer.valueOf(busId));
			order.setBusnessName(busnessItem.getName());
			order.setCreateDate(new Date());
			order.setCreateTime(new Date());
			order.setPrice(busnessItem.getPrice());
			order.setUserId(Integer.valueOf(userId));
			order.setUserName(user.getUsername());
			orderDao.insert(order);
			bean.put("operate", "1");
		}else{
			bean.put("operate", "0");
		}
		
		Helper.restful(response, bean);;
	}
	
}
