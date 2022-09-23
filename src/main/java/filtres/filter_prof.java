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

import Models.prof_model;
import Tables.tables;

@WebFilter("/projet_V2/prof/*")
public class filter_prof implements Filter {
	public filter_prof() 
    {
        // TODO Auto-generated constructor stub
    }
	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String chemin = req.getRequestURI().substring( req.getContextPath().length() );
		System.out.println("im in filter prof");
		if(session.getAttribute("prof")==null && session.getAttribute("student")==null &&!chemin.endsWith("css"))
		{
			System.out.println("resend by filtre prof");
			res.sendRedirect( "../connexion/login.jsp" );
			//req.getRequestDispatcher("/projet_V2/connexion/login.jsp").forward(request, response);
		}
		else {
			System.out.println("pass throw filtre prof");
			prof_model prof_model=new prof_model();
			if(prof_model.get_count_tables()){
			  session.setAttribute("count_tables",tables.count_tables);
			}
			if(prof_model.prof_offres(tables.prof_id)) {
				session.setAttribute("all_offres_byID",tables.all_offres_byID);
			    session.setAttribute("all_offres_byID_size",tables.all_offres_byID.size());
			}
			if(prof_model.select_all_offres_to_accept_or_refuse(tables.prof_id)){
				session.setAttribute("prof_accept_or_refuse_list",tables.prof_accept_or_refuse_list);
				session.setAttribute("prof_accept_or_refuse_list_size",tables.prof_accept_or_refuse_list.size());
				}
			if(prof_model.select_all_offres_accepted(tables.prof_id)) {
				session.setAttribute("prof_accept_list",tables.prof_accept_list);
			    session.setAttribute("prof_accept_list_size",tables.prof_accept_list.size());
			}
			if(prof_model.pupilaire_offres()) {
				session.setAttribute("pupilaire_3_offres",tables.pupilaire_3_offres);
			    session.setAttribute("pupilaire_3_offres_size",tables.pupilaire_3_offres.size());
			}
			
			if(prof_model.notification(tables.prof_id)) {
				session.setAttribute("notification_prof",tables.notification_prof);
				session.setAttribute("notification_prof_size",tables.notification_prof.size());
				}
			chain.doFilter ( request, response );
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}
