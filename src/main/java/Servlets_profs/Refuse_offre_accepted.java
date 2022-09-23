package Servlets_profs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.prof;
import Models.prof_model;
import Tables.tables;


@WebServlet("/projet_V2/prof/Refuse_offre_accepted")
public class Refuse_offre_accepted extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Refuse_offre_accepted() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		prof_model prof_model=new prof_model();
		prof_model.accept_or_refuse_the_student_offre(Integer.valueOf(request.getParameter("id_offre_accepted")), -1);
		session.setAttribute("Accept_result",-1);
		session.setAttribute("refuse_result",0);
		session.setAttribute("matiereRefus",request.getParameter("matiere"));
		session.setAttribute("emailRefus",request.getParameter("email"));

		response.sendRedirect("../prof/accepter_offre.jsp");
		//this.getServletContext().getRequestDispatcher("/projet_V2/prof/accepter_offre.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

