package scsai.cmb.control;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import scsai.cmb.datasource.inf.BusnessItemMapper;
import scsai.cmb.datasource.inf.BusnessOrderMapper;
import scsai.cmb.datasource.inf.CustomMapper;
import scsai.cmb.datasource.inf.UserMapper;
import scsai.cmb.helper.Helper;
import scsai.cmb.helper.MQHelper;

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

	private static AtomicInteger limitOrder = new AtomicInteger(1200);

	@RequestMapping(value = "/killsys.do", method = RequestMethod.GET)
	public void postCustomerInsert(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("userId") String userId, @RequestParam("busType") String busId) throws Exception {
		//1.security system
		//2.check order system
		//3.check access rule 
		//.....
		Map bean = Helper.initResponse();
		if (limitOrder.decrementAndGet() >= 0) {
			try{
				MQHelper mq = MQHelper.getInstance();
				mq.trxPersistentSend(busId+userId);
				bean.put("operate", "1");
			}catch (Exception e) {
				logger.error("MQClient error,busId:"+busId+",userId:"+userId);
				limitOrder.incrementAndGet();
				bean.put("operate", "0");
			}

		} else {
			bean.put("operate", "0");
		}

		Helper.restful(response, bean);
		;
	}

	@RequestMapping(value = "/killsys/getLimit.do", method = RequestMethod.GET)
	public void getLimitOrder(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map bean = Helper.initResponse();
		bean.put("limitOrder", limitOrder.get());
		Helper.restful(response, bean);
		;
	}
	@RequestMapping(value = "/killsys/consumer.do", method = RequestMethod.GET)
	public void consume(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map bean = Helper.initResponse();
		bean.put("limitOrder", limitOrder.get());
		Helper.restful(response, bean);
		MQHelper mq = MQHelper.getInstance();
		mq.consumeMessage(busDao, userDao, orderDao);
		
		
	}
	
	
	
}
