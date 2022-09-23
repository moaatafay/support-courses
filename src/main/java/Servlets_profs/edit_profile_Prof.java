package Servlets_profs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.prof;
import Beans.student;
import Models.prof_model;
import Models.student_model;
import Tables.tables;

@WebServlet("/projet_V2/prof/edit_profile_Prof")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 500,maxFileSize = 1024 * 1024 * 500 ,maxRequestSize = 1024 * 1024 * 500)
public class edit_profile_Prof extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public edit_profile_Prof() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		prof_model prof_model=new prof_model();
		HttpSession session=request.getSession();
		prof prof=new prof(); 
		if(prof_model.edit_profile(request)) {
			prof=prof_model.get_prof_by_id(Integer.parseInt(request.getParameter("id_profs")));
			session.setAttribute("prof",prof);
		}
		session.setAttribute("edit_profile_result",tables.edit_profile_result);
		response.sendRedirect("edit_profile_prof.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
