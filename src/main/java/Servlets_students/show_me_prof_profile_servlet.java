package Servlets_students;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.student_model;
import Beans.*;

@WebServlet("/projet_V2/student/show_me_prof_profile")
public class show_me_prof_profile_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public show_me_prof_profile_servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student_model student_model=new student_model();
		prof p=new prof();
		p=student_model.show_me_prof_profile(request);
		HttpSession session=request.getSession();
		if(p!=null) {
			
			session.setAttribute("show_this_prof", p);
		}
		response.sendRedirect("prof_profile.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
