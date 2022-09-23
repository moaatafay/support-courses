package Servlets_profs;
import Models.*;
import Tables.tables;
import Beans.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/projet_V2/connexion/prof_login")
public class prof_login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public prof_login_servlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prof_model prof_model=new prof_model();
		int id_prof=prof_model.verification(request,response);
		HttpSession session=request.getSession();
		if(id_prof!=-1) {
			prof prof=new prof();
			prof=prof_model.get_prof_by_id(id_prof);
			if(prof!=null) 
			{
				session.setAttribute("prof",prof);
				tables.prof_id=id_prof;
				//this.getServletContext().getRequestDispatcher("/projet_V2/prof/dash_board_prof.jsp").forward(request, response);
				response.sendRedirect("../prof/dash_board_prof.jsp");
			}
		}
		else {
			String status_failed="vos donnes ne sont pas correcte";
			request.setAttribute("status_failed",status_failed);
			this.getServletContext().getRequestDispatcher("/projet_V2/connexion/login.jsp").forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}





