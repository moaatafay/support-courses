package Servlets_profs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.prof_model;
import Tables.tables;

/**
 * Servlet implementation class search_servlet
 */
@WebServlet("/projet_V2/prof/search_servlet")
public class search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public search_servlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		prof_model prof_model=new prof_model();
		if(request.getParameter("search_offre_created") != null) {
			if(prof_model.search_prof_offre_created(request)) {
				session.setAttribute("search_prof_offre_created_list",tables.search_prof_offre_created_list);
				session.setAttribute("search_prof_offre_created_list_size",tables.search_prof_offre_created_list.size());
				response.sendRedirect("search_prof_offre_created.jsp");
			}
		}
		if(request.getParameter("search_offre_accept_or_refuse") != null) {
			System.out.println(request.getParameter("search_offre_accept_or_refuse"));
			if(prof_model.search_prof_offre_accept_or_refuse(request)) {
				System.out.println(request.getParameter("search_offre_accept_or_refuse"));
				System.out.println(tables.search_prof_offre_accept_or_refuse_list.size());
				session.setAttribute("search_prof_offre_accept_or_refuse_list",tables.search_prof_offre_accept_or_refuse_list);
				session.setAttribute("search_prof_offre_accept_or_refuse_list_size",tables.search_prof_offre_accept_or_refuse_list.size());
				response.sendRedirect("search_prof_offre_accept_or_refuse.jsp");
			}
		}
		if(request.getParameter("search_offre_accepted") != null) {
			if(prof_model.search_prof_offre_accepted(request)) {
				session.setAttribute("search_prof_offre_accepted_list",tables.search_prof_offre_accepted_list);
				session.setAttribute("search_prof_offre_accepted_list_size",tables.search_prof_offre_accepted_list.size());
				response.sendRedirect("search_prof_offre_accepted.jsp");
			}
		}
		
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
