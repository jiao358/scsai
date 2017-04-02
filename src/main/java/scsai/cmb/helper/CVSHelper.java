package scsai.cmb.helper;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import scsai.cmb.datasource.entity.Custom;

public class CVSHelper {

	public static final int items = 10000;
	public static final String today = "2017-04-02";
	public static  BlockingQueue<String> source = new LinkedBlockingQueue();
	public static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(11);
	public static AtomicInteger atom = new AtomicInteger(0);

	public static void main(String[] args) {
		CVSHelper cvs = new CVSHelper();
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			cvs.fixedThreadPool.execute(p);
		}
		Consume con = new Consume();
		cvs.fixedThreadPool.execute(con);
		System.out.println("trans over");
	}
	
}

class Product extends Thread {
	GenerateCustomer gg = new GenerateCustomer();

	@Override
	public void run() {
		for (int i = 0; i < CVSHelper.items; i++) {
			StringBuffer sb = new StringBuffer();
			Custom custom = gg.generateCustom();
			// values(${sex},${name},${cardtype},${phone},${num},${address},${create_date});
			sb.append(custom.getSex()).append(",").append(custom.getName()).append(",").append(custom.getCardType())
					.append(",").append(custom.getPhone()).append(",").append(custom.getCardNumb()).append(",").append(custom.getAddress()).append(",")
					.append(CVSHelper.today);
			try {
				CVSHelper.source.put(sb.toString());
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(getName() + " generate string error");
				return;
			}
		}
		CVSHelper.atom.incrementAndGet();
		System.out.println(getName()+" writer over");
	}


}

class Consume extends Thread {

	@Override
	public void run() {
		System.out.println("start to write item");
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("e:/cvs.txt"), "UTF-8"));

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		try {
			while (true) {
				String str = CVSHelper.source.poll(300, TimeUnit.MILLISECONDS);
				pw.println(str);
				if(CVSHelper.atom.compareAndSet(10, 10)){
					System.out.println("all thread over");
					break;
				}
			}
		} catch (InterruptedException e) {
			System.out.println("no item to run");
		} finally {
			pw.flush();
			pw.close();
			CVSHelper.fixedThreadPool.shutdown();
		}

	}

}
