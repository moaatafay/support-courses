package Servlets_students;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.student_model;

@WebServlet("/projet_V2/student/valider_offre")
public class valider_offre_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public valider_offre_servlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student_model student_model=new student_model();
		if(student_model.valider_offre(request))
		{
			response.sendRedirect("dash_board_student.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
