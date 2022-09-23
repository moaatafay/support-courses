package Servlets_students;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.*;
import Tables.*;

@WebServlet("/projet_V2/student/search_student")
public class search_student_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public search_student_servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		student_model student_model=new student_model();
		if(student_model.search_student(request)) {
			session.setAttribute("search_student_list",tables.search_student_list);
			session.setAttribute("search_student_list_size",tables.search_student_list.size());
		}
		response.sendRedirect("search.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
