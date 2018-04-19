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
import fr.mydigitalschool.crowdfunder.dao.UserDao;

public class ProjectFactory {
private ConnectDao connect;
	
	public ProjectFactory(ConnectDao connect) {
		super();
		this.connect = connect;
	}
	
	public void add( ProjectDao project ,String request, int cate_id ) {
		  Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  UserFactory user = new UserFactory(connect);
		  CategorieFactory cate = new CategorieFactory(connect);
		  try {
			  connex = (Connection) connect.getConnection();
			 int user_id = user.getid(request);
			 String title = project.getTitle();
			 String describe = project.getDescribe();
			 int categorie_id = cate_id;	
			 
			  preparedStatement = (PreparedStatement) connex.prepareStatement("INSERT INTO projects(user_id, title, `describe`, categorie_id) VALUES(?, ?, ?, ?);");
			  preparedStatement.setInt(1, user_id);
	            preparedStatement.setString(2, title);
	            preparedStatement.setString(3, describe);
	            preparedStatement.setInt(4, categorie_id);
	            preparedStatement.executeUpdate();
	            }
		  catch (Exception e) {
			// TODO: handle exception
			 
			  System.out.println(e);
		}
		  
	    
	}
	// Recherche d'un utilisateur à partir de son adresse email
	public ArrayList<String> getall() {
		Connection connex = null;
		  PreparedStatement preparedStatement = null;
		  ArrayList<String> category = new ArrayList<>();
		  ArrayList<ArrayList> categories = new ArrayList<>();
		  try {
			  connex = (Connection) connect.getConnection();
			  preparedStatement = (PreparedStatement) connex.prepareStatement("select title,`describe`  from projects");
			 
			  ResultSet toto = preparedStatement.executeQuery();
			  ResultSetMetaData resultMeta = (ResultSetMetaData) toto.getMetaData();
			  while(toto.next()){         
			        for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
			        	System.out.print("\t" +toto.getObject(i).toString() + "\t |");
			        	category.add(toto.getObject(i).toString());
			        }
			        System.out.println();
			       
			      }
			  
			  return category;
		  }catch (Exception e) {
			// TODO: handle exception
			  System.out.println(e);
		}
		  return null;
	    
	 
	}

}
