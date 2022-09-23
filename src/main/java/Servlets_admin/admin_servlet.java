package Servlets_admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.admin;
import Models.admin_model;
import Tables.tables;
import Tables.tables_admin;

/**
 * Servlet implementation class admin_servlet
 */
@WebServlet("/projet_V2/connexion/admin_servlet")
public class admin_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public admin_servlet() {
        super();
        
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		admin_model admin_model=new admin_model();
		int operation_status=admin_model.verification(request,response);
		HttpSession session=request.getSession();
		if(operation_status!=-1) {
			admin admin=new admin();
			admin=admin_model.get_admin(operation_status);
			if(admin!=null) {
				if(admin_model.get_count_tables()) {
					session.setAttribute("count_tables",tables_admin.count_tables);
				}
				if(admin_model.get_all_students())
				{
					session.setAttribute("all_students",tables_admin.all_students);
					session.setAttribute("all_students_size",tables_admin.all_students.size());
				}
				if(admin_model.get_all_profs()) {
					session.setAttribute("all_profs",tables_admin.all_profs);
					session.setAttribute("all_profs_size",tables_admin.all_profs.size());
				}
				if(admin_model.get_all_offers()) {
					session.setAttribute("all_offers",tables_admin.all_offres);
					session.setAttribute("all_offers_size",tables_admin.all_offres.size());
				}
				if(admin_model.get_all_offers_effect()) {
					session.setAttribute("all_offers_effect",tables_admin.all_offres_effect);
					session.setAttribute("all_offers_effect_size",tables_admin.all_offres_effect.size());
				}
				response.sendRedirect(request.getContextPath() + "/projet_V2/admin/home-admin.jsp");
			}
			else {
			System.out.println("the admin is null please check the function get admin by id;");
			}
		}
		else 
		{
			String status_failed="vos données ne sont pas correctes.";
			request.setAttribute("status_failed",status_failed);
			this.getServletContext().getRequestDispatcher("/projet_V2/connexion/login_admin.jsp").forward(request, response);
		}
	}
		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
