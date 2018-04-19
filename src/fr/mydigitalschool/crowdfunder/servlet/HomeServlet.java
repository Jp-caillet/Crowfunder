package fr.mydigitalschool.crowdfunder.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.mydigitalschool.crowdfunder.dao.ConnectDao;
import fr.mydigitalschool.crowfunder.factory.ProjectFactory;


public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<String> allproject = new ArrayList<>();
		ConnectDao connect = new ConnectDao();
    	connect = connect.connect();
		ProjectFactory project = new ProjectFactory(connect);
		allproject = project.getall();
		req.setAttribute("listproject", allproject );
		RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
		rd.forward(req, resp);
		
		
	}

}
