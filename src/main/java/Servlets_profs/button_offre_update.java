package Servlets_profs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.offre;
import Models.prof_model;
import Tables.tables;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 500,maxFileSize = 1024 * 1024 * 500 ,maxRequestSize = 1024 * 1024 * 500)
@WebServlet("/projet_V2/prof/button_offre_update")
public class button_offre_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public button_offre_update() {
        super();       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int i=Integer.parseInt(request.getParameter("hidden"));
		prof_model modelprof=new prof_model();
		offre offre=new offre();
		offre=modelprof.get_offre_by_id(i);
		session.setAttribute("offre_update",offre);
		String matiere=modelprof.get_matiere_by_id(offre.getId_matiere());
		session.setAttribute("matiere",matiere);
		this.getServletContext().getRequestDispatcher("/projet_V2/prof/edit_offre.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		prof_model prof=new prof_model();
		HttpSession session=request.getSession();
		boolean etat=prof.update_offre(request);
		session.setAttribute("matiereUp",request.getParameter("matiere"));
		session.setAttribute("Drop_offre",-1);
		session.setAttribute("edit_offre",0);
		session.setAttribute("Ajout_offre",-1);
		if(etat) {
			response.sendRedirect("../prof/my_offres.jsp");
		//this.getServletContext().getRequestDispatcher("/projet_V2/prof/").forward(request, response);
			}
		else {
			System.out.println("erreur update");}
		
	}

}
