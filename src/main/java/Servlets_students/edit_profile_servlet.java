package Servlets_students;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.student;
import Models.*;
import Tables.tables;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 500,maxFileSize = 1024 * 1024 * 500 ,maxRequestSize = 1024 * 1024 * 500)
@WebServlet("/projet_V2/student/edit_profile")
public class edit_profile_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public edit_profile_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student_model student_model=new student_model();
		HttpSession session=request.getSession();
		student student=new student(); 
		if(student_model.edit_profile(request)) {
			student=student_model.get_student_by_id(Integer.parseInt(request.getParameter("id_students")));
			session.setAttribute("student",student);
		}
		session.setAttribute("edit_profile_result",tables.edit_profile_result);
		response.sendRedirect("edit_profile.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
