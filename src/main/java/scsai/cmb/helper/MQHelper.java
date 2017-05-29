package scsai.cmb.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.apache.log4j.Logger;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.rabbitmq.client.QueueingConsumer;

import scsai.cmb.datasource.entity.BusnessItem;
import scsai.cmb.datasource.entity.BusnessOrder;
import scsai.cmb.datasource.entity.User;
import scsai.cmb.datasource.inf.BusnessItemMapper;
import scsai.cmb.datasource.inf.BusnessOrderMapper;
import scsai.cmb.datasource.inf.UserMapper;

public class MQHelper {
	private static final Logger logger = Logger.getLogger(MQHelper.class);
	
	public static final String KILL_SYSTEM_QUEUE="kill.system";
	public static final String QUEUE= "kill";
	public static final String ROUTE="killsys";
	private Connection connection ;
	private Channel channel;
	private static MQHelper mq= new MQHelper();
	private static boolean reload=false;
	public static MQHelper getInstance() throws IllegalAccessException{
		if(reload){
			throw new IllegalAccessException("Please Reinit MQHelper..");
		}
		return mq;
	}
	
	private MQHelper(){
		init();
	}
	
	private void init(){
		try {
			connection = connectionRabbit();
			channel = connection.createChannel();
			channel.exchangeDeclare(KILL_SYSTEM_QUEUE, "direct",true);
			channel.queueDeclare(QUEUE, true, false,false,null);
			channel.queueBind(QUEUE, KILL_SYSTEM_QUEUE, ROUTE);
		} catch (IOException | TimeoutException e) {
			reload=true;
			logger.error("MQ initial failed..",e);
		}
	}
	
	public static void sendMessage() throws Exception{
		Connection connection  = connectionRabbit();
		//create a channel
		Channel channel = connection.createChannel();
		//declear a persistent exchange
		channel.exchangeDeclare(KILL_SYSTEM_QUEUE, "direct",true);
		channel.queueDeclare(QUEUE, true, false,false,null);
		channel.queueBind(QUEUE, KILL_SYSTEM_QUEUE, ROUTE);
		
		String message="Hello world";
		
		channel.basicPublish(KILL_SYSTEM_QUEUE, ROUTE, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("utf-8"));
		System.out.println("Producer Send:"+message);
		Thread.sleep(Integer.MAX_VALUE);
	}
	
	public  void trxPersistentSend(String message) throws UnsupportedEncodingException, IOException{
		channel.basicPublish(KILL_SYSTEM_QUEUE, ROUTE, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("utf-8"));
	}
	
	
	private static Connection connectionRabbit() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.0.131");
		factory.setUsername("pino");
		factory.setPassword("pino");
		//create a new connection
		Connection connection  = factory.newConnection();
		return connection;
	}
	public static void receiveMessage() throws Exception{
		Connection connection = connectionRabbit();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE, true, false,false,null);
		QueueingConsumer consume = new QueueingConsumer(channel);
		boolean autoflag= false;
		
		channel.basicConsume(QUEUE,autoflag, consume);
		while(true){
			System.out.println("now receive ...");
			QueueingConsumer.Delivery delivery = consume.nextDelivery();
			String message = new String(delivery.getBody(),"utf-8");
			System.out.println("Receive message->"+ message);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
		}
		
	}
	public void consumeMessage(BusnessItemMapper busDao,UserMapper userDao,BusnessOrderMapper orderDao) throws Exception{
		Connection connection = connectionRabbit();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE, true, false,false,null);
		QueueingConsumer consume = new QueueingConsumer(channel);
		boolean autoflag= false;
		
		channel.basicConsume(QUEUE,autoflag, consume);
		while(true){
			QueueingConsumer.Delivery delivery = consume.nextDelivery();
			String message = new String(delivery.getBody(),"utf-8");
			System.out.println("Receive message->"+ message);
			if(!message.startsWith("1")){
				channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
				continue;
			}
			String busId = "1";
			String userId= message.substring(1);
			busDao.update4Decrement(Integer.valueOf(busId));
			BusnessItem busnessItem = busDao.selectByPrimaryKey(Integer.valueOf(busId));
			
			User user = userDao.selectByPrimaryKey(Integer.valueOf(userId));
			BusnessOrder order = new BusnessOrder();
			order.setBusnessId(Integer.valueOf(busId));
			order.setBusnessName(busnessItem.getName());
			order.setCreateDate(new Date());
			order.setCreateTime(new Date());
			order.setPrice(busnessItem.getPrice());
			order.setUserId(Integer.valueOf(userId));
			order.setUserName(user.getUsername());
			orderDao.insert(order);
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
		}
	}
	
	
//	channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
	
//	channel.queueBind(queueName, exchangeName, routingKey);
	/*private void persistentQueue(){
		boolean durable = true;
		channel.queueDeclare("task_queue", durable, false, false, null);
		
		第二， 我们需要标识我们的信息为持久化的。通过设置MessageProperties（implements BasicProperties）值为PERSISTENT_TEXT_PLAIN。
		channel.basicPublish("", "task_queue",MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
		
		 QueueingConsumer consumer = new QueueingConsumer(channel);  
	        // 指定接收者，第二个参数为自动应答，无需手动应答  
	        channel.basicConsume(queueName, true, consumer);
	        
	        QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
            String message = new String(delivery.getBody());  
            
            
            boolean ack = false; // 打开应答机制  
            channel.basicConsume(QUEUE_NAME, ack, consumer);  
            while (true)  
            {  
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();  
                String message = new String(delivery.getBody());  
      
                System.out.println(hashCode + " [x] Received '" + message + "'");  
                doWork(message);  
                System.out.println(hashCode + " [x] Done");  
                //channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);  
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);  
      
            }  
      
	}*/

}
