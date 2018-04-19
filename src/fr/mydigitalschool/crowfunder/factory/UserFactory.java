package fr.mydigitalschool.crowfunder.factory;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import fr.mydigitalschool.crowdfunder.dao.ConnectDao;
import fr.mydigitalschool.crowdfunder.dao.UserDao;
import fr.mydigitalschool.crowfunder.entity.UserEntity;

public class UserFactory {
private ConnectDao connect;
	
	public UserFactory(ConnectDao connect) {
		super();
		this.connect = connect;
	}
	
	public void add( UserDao user ) {
		  Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  try {
			  connex = (Connection) connect.getConnection();
			  String email =  user.getEmail();
			  String mdp = user.getMdp();
			  String name = user.getName();
			  String lastname = user.getLastname();
			  preparedStatement = (PreparedStatement) connex.prepareStatement("INSERT INTO users(email, mdp, name, lastname) VALUES(?, ?, ?,?);");
			  preparedStatement.setString(1, email);
	            preparedStatement.setString(2, mdp);
	            preparedStatement.setString(3, name);
	            preparedStatement.setString(4, lastname);
	            preparedStatement.executeUpdate();
	            }
		  catch (Exception e) {
			// TODO: handle exception
			 
			  System.out.println(e);
		}
		  
	    
	}
	// Recherche d'un utilisateur à partir de son adresse email
	public int getid( String email ) {
		Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  int id ;
		  try {
			  connex = (Connection) connect.getConnection();
			  preparedStatement = (PreparedStatement) connex.prepareStatement("select * from users where email = ?;");
			  preparedStatement.setString(1, email);
			  ResultSet toto = preparedStatement.executeQuery();
			  ResultSetMetaData resultMeta = (ResultSetMetaData) toto.getMetaData();
			  while(toto.next()){         
			        for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
			        	id =  Integer.parseInt(toto.getObject(1).toString());
			        	return id;
			        }
			      }
			  
		  }catch (Exception e) {
			// TODO: handle exception
			  System.out.println(e);
		}
		  return 0;
	    
	 
	}
	public ArrayList<String> getuserbymail( String email ) {
		Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  ArrayList<String> user = new ArrayList<>();
		  try {
			  connex = (Connection) connect.getConnection();
			  preparedStatement = (PreparedStatement) connex.prepareStatement("select * from users where email = ?;");
			  preparedStatement.setString(1, email);
			  ResultSet toto = preparedStatement.executeQuery();
			  ResultSetMetaData resultMeta = (ResultSetMetaData) toto.getMetaData();
			  while(toto.next()){         
			        for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
			        	System.out.print("\t" +toto.getObject(i).toString() + "\t |");
			        	user.add(toto.getObject(i).toString());
			        }
			      }
			  return user;
		  }catch (Exception e) {
			// TODO: handle exception
			  System.out.println(e);
		}
		  return null;
	    
	 
	}

}
