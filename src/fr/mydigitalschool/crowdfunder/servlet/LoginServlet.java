package fr.mydigitalschool.crowdfunder.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Synthesizer;

import fr.mydigitalschool.crowdfunder.dao.ConnectDao;
import fr.mydigitalschool.crowdfunder.dao.UserDao;
import fr.mydigitalschool.crowfunder.factory.UserFactory;

public class LoginServlet extends HttpServlet {
	
	private ArrayList<String> user;
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
		rd.forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("login");
		ConnectDao connect = new ConnectDao();
    	connect = connect.connect();
    	UserFactory toto = new UserFactory(connect);
		String username = req.getParameter( "username" );
		String psw = req.getParameter( "psw" );
		user= toto.getuserbymail(username);
		Iterator<String> it = user.iterator();
		int i = 0;
		if(user!= null) {
			while (it.hasNext()) {
			       String bdd =  it.next();
			       if(i==2) {
			    	   if(bdd.equals(psw)) {
				    	    HttpSession session = req.getSession();
				   			session.setAttribute("login", username);
				       }  
			       }
			       
			       i++;
			}
		}
				
		resp.sendRedirect("login");
		
	
	}

}