package Servlets_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.admin_model;
import Tables.tables_admin;

/**
 * Servlet implementation class supprimer_servlet
 */
@WebServlet("/projet_V2/admin/supprimer_servlet")
public class supprimer_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public supprimer_servlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		admin_model admin_model=new admin_model();
		HttpSession session=request.getSession();
		
		if(request.getParameter("student_to_delete") != null) {
						
			if(admin_model.delete_student(request)) 
			{
				session.setAttribute("delete_success_student",1);
				if(admin_model.get_all_students())
				{
					session.setAttribute("all_students",tables_admin.all_students);
					session.setAttribute("all_students_size",tables_admin.all_students.size());
					response.sendRedirect(request.getContextPath() + "/projet_V2/admin/students-admin.jsp");
				}
			}
		}
		
		if(request.getParameter("offre_to_delete") != null) {
			if(admin_model.delete_offre(request))
			{
				session.setAttribute("delete_success_offre",1);
			}
			if(admin_model.get_all_offers()) 
			{
					session.setAttribute("all_offers",tables_admin.all_offres);
					session.setAttribute("all_offers_size",tables_admin.all_offres.size());
					response.sendRedirect(request.getContextPath() + "/projet_V2/admin/offres-admin.jsp");
			}
		}
		
		if(request.getParameter("prof_to_delete") != null) {
			if(admin_model.delete_prof(request)) {
				session.setAttribute("delete_success_prof",1);
				if(admin_model.get_all_profs()) 
				{
					session.setAttribute("all_profs",tables_admin.all_profs);
					session.setAttribute("all_profs_size",tables_admin.all_profs.size());
					response.sendRedirect(request.getContextPath() + "/projet_V2/admin/profs-admin.jsp");
					}
				}
			}
}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
