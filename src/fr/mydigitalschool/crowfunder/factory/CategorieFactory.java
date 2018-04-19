package fr.mydigitalschool.crowfunder.factory;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import fr.mydigitalschool.crowdfunder.dao.CategorieDao;
import fr.mydigitalschool.crowdfunder.dao.ConnectDao;
import fr.mydigitalschool.crowdfunder.dao.ProjectDao;

public class CategorieFactory {
private ConnectDao connect;
	
	public CategorieFactory(ConnectDao connect) {
		super();
		this.connect = connect;
	}
	
	public void add( CategorieDao cate ) {
		  Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  
		  try {
			  connex = (Connection) connect.getConnection();
			  String label = cate.getLabel();
			 
			  preparedStatement = (PreparedStatement) connex.prepareStatement("INSERT INTO categories(label) VALUES(?);");
			  preparedStatement.setString(1, label);
	            preparedStatement.executeUpdate();
	            }
		  catch (Exception e) {
			// TODO: handle exception
			 
			  System.out.println(e);
		}
		  
	    

}
	public int getid( String label ) {
		Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  int id ;
		  try {
			  connex = (Connection) connect.getConnection();
			  preparedStatement = (PreparedStatement) connex.prepareStatement("select id from categories where label = ?;");
			  preparedStatement.setString(1, label);
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
}
