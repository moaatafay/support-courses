package Servlets_students;

import java.io.IOException;
import Models.*;
import Tables.tables;
import Beans.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/projet_V2/connexion/student_register")
public class student_register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public student_register_servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student_model student_model=new student_model();
		HttpSession session=request.getSession();
		if(student_model.is_it_one_email(request)) {
			int id_students=student_model.insert_student_in_DB(request);
			if(id_students!=-1 && id_students>0) {
				student student=new student();
				student=student_model.get_student_by_id(id_students);
				session.setAttribute("student",student);
				if(student_model.get_last_3_offres())
				{
					session.setAttribute("last_3_offres",tables.last_3_offres);
					session.setAttribute("last_3_offres_size",tables.last_3_offres.size());
				}
				if(student_model.get_random_3_profs())
				{
					session.setAttribute("random_3_profs", tables.random_3_profs);
				}
				if(student_model.get_count_tables()) 
				{
					session.setAttribute("count_tables",tables.count_tables);
				}
				if(student_model.get_all_offres()) 
				{
					session.setAttribute("all_offres",tables.all_offres);
					session.setAttribute("all_offres_size",tables.all_offres.size());
				}
				if(student_model.get_offres_that_i_passsed(id_students))
				{
					session.setAttribute("all_offres_that_i_passed",tables.all_offres_that_i_passed);
					session.setAttribute("all_offres_that_i_passed_size",tables.all_offres_that_i_passed.size());
				}
				if(student_model.get_notfications(id_students)) {
					session.setAttribute("notification",tables.notification);
					session.setAttribute("notification_size",tables.notification.size());	
				}
				session.setAttribute("student",student);
				tables.student_id=student.getId_students();
				//this.getServletContext().getRequestDispatcher("/projet_V2/student/dash_board_student.jsp").forward(request, response);
			    response.sendRedirect("../student/dash_board_student.jsp");
				
			}
			else {
				System.out.println("there is an error the id_students returned -1 or <=0");
			}
		}
		else {
			String status_failed="this email is already used try other one ";
			request.setAttribute("status_failed",status_failed);
			this.getServletContext().getRequestDispatcher("/projet_V2/connexion/register.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
