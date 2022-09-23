package Models;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Daos.*;
import Tables.tables;
import Beans.*;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 500,maxFileSize = 1024 * 1024 * 500 ,maxRequestSize = 1024 * 1024 * 500)

public class student_model {
	student_dao student_dao=new student_dao();
	//verify the email and password:
	public int verification(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		student_dao student_dao=new student_dao();
		int operation_result = 0;
		try {
			operation_result=student_dao.check(email, password);
		} catch (Exception e) {
			System.out.println("error in student dao check exceptions function verification");
		}
		if(operation_result!=-1 && operation_result>0) {
			return operation_result;
		}
		else {
			return -1;
		}	
	}
	//define student by his id.
	public student get_student_by_id(int id) {
		try {
			return student_dao.get_student_by_id(id);
		} catch (Exception e) {
			System.out.println("error in student dao check exceptions function get_student_by_id");
			return null;
		}
	}
	//this function return true if this email never used and fale if its already used;
	public boolean is_it_one_email(HttpServletRequest request)
	{
		String email=request.getParameter("email");
		try {
			return student_dao.is_it_one_email(email);
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function is_it_one_email");
			return false;
		}
	}
	//this function return te id of new student inserted in db or -1 if there is an exception
	public int insert_student_in_DB(HttpServletRequest request)
	{
		student student=new student();
		student.setName(request.getParameter("name"));
		student.setFamily_name(request.getParameter("family_name"));
		student.setEmail(request.getParameter("email"));
		student.setPassword(request.getParameter("password"));
		student_dao student_dao=new student_dao();
		try {
			return student_dao.insert_student_in_DB(student);
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function insert_student_in_DB");
			return -1;
		}
	}
	//la fonction qui permet d'affiche 10 last offres .
	public boolean get_last_3_offres() {
		try {
			student_dao.get_last_3_offres();
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function get_last_3_offres");
			return false;
		}
	}
	// la fonction qui fait retourn 3 random profs:
	public boolean get_random_3_profs()
	{
		try {
			student_dao.get_random_3_profs();
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function get_random_3_profs");
			return false;
		}
		
	}
	// la fnct qui permet de donne le nmbr d eleve , profs ,offres accepted , offre
	public boolean get_count_tables() {
		try {
			student_dao.get_count_tables();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	// la fnct qui permet d afficher tt les offres .
	public boolean get_all_offres() {
		try {
			student_dao.get_all_offres();
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function all_offres functions");
			return false;
		}
		
	}
	// la fnct qui affiche tt les offre deja passer pour les donner une note.
	public boolean get_offres_that_i_passsed(int operation_status) {
		try {
			student_dao.get_offres_that_i_passed(operation_status);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	// la fnct qui fait la recherche sur un offre.
	public boolean search_student(HttpServletRequest request) {
		String search=request.getParameter("search");
		try {
			student_dao.search_student(search);
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function search_students");
			return false;
		}
	}
	//the function that analyse offre data that student choose:
	public boolean valider_offre(HttpServletRequest request) {
		int id_offre=Integer.parseInt(request.getParameter("id_offre"));
		int id_students=Integer.parseInt(request.getParameter("id_students"));
		String date=request.getParameter("date");
		String start=request.getParameter("start");
		String finish=request.getParameter("finish");
		String localisation=request.getParameter("localisation");
		int status=0;
	    offre_accepted offre_accepted=new offre_accepted();
		offre_accepted.setDate(date);
		offre_accepted.setFinish(finish);
		offre_accepted.setId_offre(id_offre);
		offre_accepted.setId_students(id_students);
		offre_accepted.setLocalisation(localisation);
		offre_accepted.setStart(start);
		offre_accepted.setStatus(status);
		try {
			student_dao.valider_offre(offre_accepted);
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function valider_offre");
			return false;
		}
		
	}
	//the function that rate offre by student:
	public boolean rate_this_offre(HttpServletRequest request) {
		String rate=request.getParameter("star");
		String id_offre_accepted=request.getParameter("id_offre_accepted");
		String id_students=request.getParameter("id_students");
		try {
			student_dao.rate_this_offre(id_offre_accepted,rate,id_students);
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function rate_this_offre");
			return false;
		}
		
	}
	//all notification of student defined by id
	public boolean get_notfications(int id_students) {
		try {
			student_dao.get_notification(id_students);
			return true;
		} catch (SQLException e) {
			System.out.println("error in student dao check exceptions function get notifications");
			return false;
		}
		
		
	}
	//editing profile and change student profile.
	public boolean edit_profile(HttpServletRequest request) {
		student student=new student();
		int id_students=Integer.parseInt(request.getParameter("id_students"));
		String name=request.getParameter("name");
		String family_name=request.getParameter("family_name");
		String city=request.getParameter("city");
		String bio=request.getParameter("bio");
		String password=request.getParameter("password");
		String img=request.getParameter("img");
		String email=request.getParameter("email");
		student.setBio(bio);
		student.setCity(city);
		student.setEmail(email);
		student.setFamily_name(family_name);
		student.setId_students(id_students);
		System.out.println(student.getImg());
		student.setName(name);
		student.setPassword(password);
		Part part=null;
		try {
			part=request.getPart("img");
			System.out.println("part is "+part);
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			System.out.println("student model edit profile error exeption 1");
		}
		if(part==null) {
			System.out.println("l image est "+student.getImg());
		}
		else {
			String fileName= extractFileName(part);
			student.setImg("../assets/img/img_offre/"+fileName);
			String savePath = "C:\\Users\\hp\\eclipse-workspace\\LL\\src\\main\\webapp\\projet_V2\\assets\\img\\img_offre"+File.separator + fileName;
			try {
				part.write(savePath + File.separator);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("student model edit profile error exeption 2");
			}	
		}
		System.out.println("----------------------------------------");
		System.out.println(student.getImg());
		try {
			student_dao.edit_profile(student);
			tables.edit_profile_result=0;
			return true;
		} catch (Exception e) {
			tables.edit_profile_result=-1;
			System.out.println("error in student dao check exceptions function edit profile");
			return false;
		}
	}
	//discover prof profile and data.
	public prof show_me_prof_profile(HttpServletRequest request) {
		String id_offre=request.getParameter("id_offre");
		try {
			prof p=new prof();
			p=student_dao.show_me_prof_profile(id_offre);
			return p;
		} catch (Exception e) {
			System.out.println("error in student dao check exceptions function show_me_prof_profile");
			return null;
		}
	}
	//function to extract file name by part:
		public String extractFileName(Part part) {//This method will print the file name.
			 String contentDisp = part.getHeader("content-disposition");
			 String[] items = contentDisp.split(";");
			 for (String s : items) {
			 if (s.trim().startsWith("filename")) {return s.substring(s.indexOf("=") + 2, s.length() - 1);}}
			 return "";
			}
}
