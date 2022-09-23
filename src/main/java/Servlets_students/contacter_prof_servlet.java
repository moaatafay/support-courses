package Servlets_students;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Daos.*;

@WebServlet("/projet_V2/student/contacter_prof")
public class contacter_prof_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public contacter_prof_servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.setAttribute("contacter_prof_id_offre",request.getParameter("contacter_prof_id_offre"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDateTime now = LocalDateTime.now();
		session.setAttribute("date_min",dtf.format(now));
		LocalDateTime then = now.plusDays(10);
		session.setAttribute("date_max",dtf.format(then));
		response.sendRedirect("valider_offre.jsp");	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
