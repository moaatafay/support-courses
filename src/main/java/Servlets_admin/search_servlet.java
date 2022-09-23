package Servlets_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.admin_model;
import Models.student_model;
import Tables.tables_admin;

/**
 * Servlet implementation class search_servlet
 */
@WebServlet("/projet_V2/admin/search_servlet")
public class search_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public search_servlet() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		admin_model admin_model=new admin_model();
		if(request.getParameter("search_student") != null) {
			if(admin_model.search_admin_student(request)) {
				session.setAttribute("search_student_list",tables_admin.search_student_list);
				session.setAttribute("search_student_list_size",tables_admin.search_student_list.size());
				response.sendRedirect("search_admin_student.jsp");
				}
			}
		
		if(request.getParameter("search_prof") != null) {
			if(admin_model.search_admin_prof(request)) {
				session.setAttribute("search_prof_list",tables_admin.search_prof_list);
				session.setAttribute("search_prof_list_size",tables_admin.search_prof_list.size());
				response.sendRedirect("search_admin_prof.jsp");
			}
		}
		if(request.getParameter("search_offre") != null) {
			if(admin_model.search_admin_offre(request)) {
				session.setAttribute("search_offre_list",tables_admin.search_offre_list);
				session.setAttribute("search_offre_list_size",tables_admin.search_offre_list.size());
				response.sendRedirect("search_admin_offre.jsp");
			}
		}
		if(request.getParameter("search_offre_effect") != null) {
			if(admin_model.search_admin_offre_effect(request)) {
				session.setAttribute("search_offres_effect_list",tables_admin.search_offres_effect_list);
				session.setAttribute("search_offres_effect_list_size",tables_admin.search_offres_effect_list.size());
				response.sendRedirect("search_admin_offres_effect.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
