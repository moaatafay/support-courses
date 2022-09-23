package Servlets_profs;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.prof_model;
import Tables.tables;


@WebServlet("/projet_V2/prof/Drop_offre_prof")
public class Drop_offre_prof extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Drop_offre_prof() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		prof_model prof_model=new prof_model();
		prof_model.delete_offre(request);
		HttpSession session=request.getSession();
		session.setAttribute("matiereSup",request.getParameter("matiere"));		
		session.setAttribute("Drop_offre",0);
		session.setAttribute("edit_offre",-1);
		session.setAttribute("Ajout_offre",-1);
		
		response.sendRedirect("../prof/my_offres.jsp");
		//this.getServletContext().getRequestDispatcher("/projet_V2/prof/").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
