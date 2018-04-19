package fr.mydigitalschool.crowdfunder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.mydigitalschool.crowdfunder.dao.ConnectDao;
import fr.mydigitalschool.crowdfunder.dao.ProjectDao;
import fr.mydigitalschool.crowfunder.factory.CategorieFactory;
import fr.mydigitalschool.crowfunder.factory.ProjectFactory;
import fr.mydigitalschool.crowfunder.factory.UserFactory;

public class AddProjectServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addProject.jsp");
		rd.forward(req, resp);
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("add project");
		ProjectDao projet;
		
		ConnectDao connect = new ConnectDao();
    	connect = connect.connect();
    	ProjectFactory profac = new ProjectFactory(connect);
    	CategorieFactory cate = new CategorieFactory(connect);
		String title = req.getParameter( "title" );
		String label = req.getParameter( "categorie" );
		String describe = req.getParameter( "describe" );
		projet = new ProjectDao(title, describe, label);
		profac.add(projet, (String) req.getSession().getAttribute("login"), cate.getid(label));
		
				
		resp.sendRedirect("../home");
		
	
	}

}
