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

import Models.student_model;
import Tables.tables;

@WebFilter("/projet_V2/student/*")
public class filter_student implements Filter {

    public filter_student() {
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
		System.out.println("im in filter");
		if(session.getAttribute("prof")==null && session.getAttribute("student")==null && !chemin.endsWith("css"))
		{
			System.out.println("resend by filtre student");
			res.sendRedirect( "../connexion/login.jsp" );
			//req.getRequestDispatcher("/projet_V2/connexion/login.jsp").forward(request, response);
		}
		else {
			System.out.println("pass throw filtre student");
			student_model student_model=new student_model();
			if(student_model.get_last_3_offres())
				{
						session.setAttribute("last_3_offres",tables.last_3_offres);
						session.setAttribute("last_3_offres_size",tables.last_3_offres.size());
						
				}
			if(student_model.get_random_3_profs())
				{
						session.setAttribute("random_3_profs", tables.random_3_profs);
				}
			if(student_model.get_count_tables()) {
						session.setAttribute("count_tables",tables.count_tables);
				}
			if(student_model.get_all_offres()) {
						session.setAttribute("all_offres",tables.all_offres);
						session.setAttribute("all_offres_size",tables.all_offres.size());
				}
			if(student_model.get_offres_that_i_passsed(tables.student_id))
				{
						session.setAttribute("all_offres_that_i_passed",tables.all_offres_that_i_passed);
						session.setAttribute("all_offres_that_i_passed_size",tables.all_offres_that_i_passed.size());
				}
			if(student_model.get_notfications(tables.student_id)) {
						session.setAttribute("notification",tables.notification);
						session.setAttribute("notification_size",tables.notification.size());	
				}
			
			chain.doFilter ( request, response );
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
