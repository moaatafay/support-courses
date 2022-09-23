package Servlets_students;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.student_model;
import Tables.tables;

@WebServlet("/projet_V2/student/rate_passed_offre")
public class rate_passed_offre_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public rate_passed_offre_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student_model student_model=new student_model();
		HttpSession session=request.getSession();
		if(student_model.rate_this_offre(request))
		{
			session.setAttribute("all_offres_that_i_passed",tables.all_offres_that_i_passed);
			session.setAttribute("all_offres_that_i_passed_size",tables.all_offres_that_i_passed.size());
			response.sendRedirect("offres_effectues.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
