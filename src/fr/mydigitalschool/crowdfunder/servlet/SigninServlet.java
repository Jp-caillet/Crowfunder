package fr.mydigitalschool.crowdfunder.servlet;


import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mydigitalschool.crowdfunder.dao.ConnectDao;
import fr.mydigitalschool.crowdfunder.dao.UserDao;
import fr.mydigitalschool.crowfunder.entity.UserEntity;
import fr.mydigitalschool.crowfunder.factory.UserFactory;




@WebServlet( urlPatterns = { "/inscription" } )
public class SigninServlet extends HttpServlet {
  
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/signin.jsp");
		rd.forward(req, resp);
		
		
	}
    

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	System.out.println("signin");
    	String username = request.getParameter( "username" );
    	String psw = request.getParameter( "psw" );
    	String name = request.getParameter( "name" );
    	String lastname = request.getParameter( "lastname" );
    	UserDao user = new UserDao(username, psw, name,lastname);
    	ConnectDao connect = new ConnectDao();
    	connect = connect.connect();
    	UserFactory toto = new UserFactory(connect);
    	toto.add(user);
    	response.sendRedirect("login");
    	
        
      
    }
}