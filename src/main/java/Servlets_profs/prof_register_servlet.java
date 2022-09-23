package Servlets_profs;
import Beans.*;
import Models.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.student;
import Models.student_model;
import Tables.tables;

@WebServlet("/projet_V2/connexion/prof_register")
public class prof_register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public prof_register_servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prof_model prof_model=new prof_model();
		HttpSession session=request.getSession();
		if(prof_model.is_it_one_email(request)) {
			int id_profs=prof_model.insert_prof_in_DB(request);
			if(id_profs!=-1 && id_profs>0) {
				prof prof=new prof();
				prof=prof_model.get_prof_by_id(id_profs);
				if(prof!=null) 
				{
					session.setAttribute("prof",prof);
					tables.prof_id=id_profs;
					//this.getServletContext().getRequestDispatcher("/projet_V2/prof/dash_board_prof.jsp").forward(request, response);
					response.sendRedirect("../prof/dash_board_prof.jsp");
				}
			}
			else {
				System.out.println("there is an error the id_profs returned -1 or <=0");
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
