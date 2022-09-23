package Servlets_profs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.prof_model;
import Models.student_model;
import Tables.tables;

@WebServlet("/projet_V2/prof/add_offre")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 500,maxFileSize = 1024 * 1024 * 500 ,maxRequestSize = 1024 * 1024 * 500)
public class prof_add_offer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public prof_add_offer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		prof_model prof_model=new prof_model();
	    //int	id_prof=prof_model.verification(request, response);
		prof_model.insert_offre_in_DB(request);
		
		session.setAttribute("matiereAjouter",request.getParameter("matiere"));
		session.setAttribute("Drop_offre",-1);
		session.setAttribute("edit_offre",-1);
		session.setAttribute("Ajout_offre",0); 
		response.sendRedirect("../prof/my_offres.jsp");
		//this.getServletContext().getRequestDispatcher("/projet_V2/prof/my_offres.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
