package scsai.cmb.test.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Mybatis {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://192.168.0.202/centos", "estela", "123456");
			if (c != null)
				System.out.println("connection o.k.");
			else
				System.out.println("connection failed!");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
