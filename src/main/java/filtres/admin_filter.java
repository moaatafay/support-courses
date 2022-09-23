package filtres;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.admin_model;
import Tables.tables;
import Tables.tables_admin;

/**
 * Servlet Filter implementation class admin_filter
 */
@WebFilter("/admin_filter")
public class admin_filter implements Filter {

    public admin_filter() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session =req.getSession();
		String chemin = req.getRequestURI().substring( req.getContextPath().length() );
		
		if(chemin.startsWith("/projet_V2/admin") && session.getAttribute("operation_status")==null)
		{
			res.sendRedirect(req.getContextPath() + "/projet_V2/connexion/login_admin.jsp");
		}
		else {
			admin_model admin_model=new admin_model();
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
			chain.doFilter ( request, response );
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
	}

}
