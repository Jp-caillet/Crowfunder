package fr.mydigitalschool.crowdfunder.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ConnectDao {
	private String url;
	private String login;
	private String pwd;
	
	
	public ConnectDao(String url, String login, String pwd) {
		super();
		this.url = url;
		this.login = login;
		this.pwd = pwd;
	}


	public ConnectDao() {
		// TODO Auto-generated constructor stub
	}


	public ConnectDao connect() {
		
        try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("toto");
			e.printStackTrace();
		}
        ConnectDao connect = new ConnectDao("jdbc:mysql://localhost:3306/crowfunder", "root", "");  
        return connect;

	}
	
	public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, pwd);
    }
	
}
