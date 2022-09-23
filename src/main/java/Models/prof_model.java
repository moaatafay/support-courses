package Models;
import Beans.*;
import Daos.*;
import Tables.tables;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;  
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 500,maxFileSize = 1024 * 1024 * 500 ,maxRequestSize = 1024 * 1024 * 500)
public class prof_model {
	//prof_dao prof_dao=new prof_dao();
	public int verification(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		prof_dao prof_dao=new prof_dao();
		int operation_result = 0;
		try {
			operation_result=prof_dao.check(email, password);
		} catch (Exception e) {
			System.out.println("error in prof dao check exceptions function verification 1");
		}
		if(operation_result!=-1 && operation_result>0) {
			return operation_result;
		}
		else {
			return -1;
		}	
	}
	// la fnct qui permet de donne les offre de prof
			public boolean prof_offres(int id) {
				try {prof_dao prof_dao=new prof_dao();
				         prof_dao.prof_offres(id);
						return true;
					} catch (SQLException e) {
						return false;
					}
				}
	
	// la fnct qui permet de donne les offre populaire
		public boolean pupilaire_offres() {
			try {prof_dao prof_dao=new prof_dao();
			         prof_dao.pupilaire_offres();
					return true;
				} catch (SQLException e) {
					return false;
				}
			}
	// this function will return the prof who is in the session
    public prof get_prof_by_id(int id) {
		prof_dao prof_dao=new prof_dao();
		try {
			return prof_dao.get_prof_by_id(id);
		} catch (Exception e) {
			System.out.println("error in prof dao check exceptions function get_student_by_id");
			return null;
		}
	}
	//this function return true if this email never used and fale if its already used;
	public boolean is_it_one_email(HttpServletRequest request)
		{
			String email=request.getParameter("email");
			prof_dao prof_dao=new prof_dao();
			try {
				return prof_dao.is_it_one_email(email);
			} catch (SQLException e) {
				System.out.println("error in prof dao check exceptions function is_it_one_email");
				return false;
			}
		}
	//this function return te id of new student inserted in db or -1 if there is an exception
	public int insert_prof_in_DB(HttpServletRequest request)
		{
			prof prof=new prof();
			prof.setName(request.getParameter("name"));
			prof.setFamily_name(request.getParameter("family_name"));
			prof.setEmail(request.getParameter("email"));
			prof.setPassword(request.getParameter("password"));
			prof_dao prof_dao=new prof_dao();
			try {
				return prof_dao.insert_prof_in_DB(prof);
			} catch (SQLException e) {
				System.out.println("error in prof dao check exceptions function insert_prof_in_DB");
				return -1;
			}
		}
	// la fnct qui permet de donne le nmbr d eleve , profs ,offres accepted , offre
	public boolean get_count_tables() {
		try {student_dao student_dao=new student_dao();
				student_dao.get_count_tables();
				return true;
			} catch (SQLException e) {
				return false;
			}
		}
	//insertion d'offre dans la base de donnee.
	public int insert_offre_in_DB(HttpServletRequest request) throws IOException
			{
				offre offre=new offre();			
				offre.setId_profs(Integer.valueOf(request.getParameter("id")));
				offre.setPrix(Double.valueOf(request.getParameter("prix")));
				offre.setInfos(request.getParameter("bio"));	
				
				//the part of upload a picture 
				Part part = null;
				try {
					part = request.getPart("image");
				} catch (IOException e1) {
					System.out.println("exep IOEXCEPTION");
				} catch (ServletException e1) {
					System.out.println("exep SERVLET EXCEPTION ");
				}
				String fileName= extractFileName(part);
				offre.setImage("../assets/img/img_offre/"+fileName);
				String savePath = "C:\\Users\\hp\\eclipse-workspace\\LL\\src\\main\\webapp\\projet_V2\\assets\\img\\img_offre"+File.separator + fileName;
				part.write(savePath + File.separator);
				//end of uploading image
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    LocalDateTime now = LocalDateTime.now();	     
			    offre.setDate(dtf.format(now));
				prof_dao prof_dao=new prof_dao();
				try {
						offre.setId_matiere(prof_dao.search_id_matiere(request.getParameter("matiere")));	
						prof_dao.insert_offre_in_DB(offre);
						prof_dao.prof_offres(Integer.valueOf(request.getParameter("id")));
					    tables.edit_profile_result=1;
						return 0;
					} 
				catch (SQLException e) {
							System.out.println("error in prof dao check exceptions function insert_offre_in_DB");
							return -1;
						}
					}
	//la supression d'offre dans la db
	public void delete_offre(HttpServletRequest request){
		prof_dao prof_dao=new prof_dao();
		try {
			prof_dao.delete_offre(Integer.valueOf(request.getParameter("id_offre")));
			
					
			}
		catch (Exception e) {
			e.printStackTrace();
			}
		
		}
	// changer les donnes dans la bd
	public boolean edit_profile(HttpServletRequest request) {
		prof prof=new prof();
		prof_dao prof_dao=new prof_dao();
		int id_profs=Integer.parseInt(request.getParameter("id_profs"));
		String name=request.getParameter("name");
		String family_name=request.getParameter("family_name");
		String city=request.getParameter("city");
		String bio=request.getParameter("bio");
		String password=request.getParameter("password");
		String img=request.getParameter("img");
		String email=request.getParameter("email");
		prof.setBio(bio);
		prof.setCity(city);
		prof.setEmail(email);
		prof.setFamily_name(family_name);
		prof.setId_profs(id_profs);
		//prof.setImg(img);
		prof.setName(name);
		prof.setPassword(password);
		Part part=null;
		try {
			part=request.getPart("img");
			System.out.println("part is "+part);
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			System.out.println("student model edit profile error exeption 1");
		}
		if(part==null) {
			prof.setImg(img);	
		}
		else {
			String fileName= extractFileName(part);
			prof.setImg("../assets/img/img_offre/"+fileName);
			String savePath = "C:\\Users\\hp\\eclipse-workspace\\LL\\src\\main\\webapp\\projet_V2\\assets\\img\\img_offre"+File.separator + fileName;
			try {
				part.write(savePath + File.separator);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("student model edit profile error exeption 2");
			}	
		}
		System.out.println(prof.getImg());
		try {	
			prof_dao.edit_profile(prof);     
			tables.edit_profile_result=0;
			return true;
			}
		catch (Exception e) {	         
			tables.edit_profile_result=-1;
			System.out.println("error in prof dao check exceptions function edit profile");
			return false;
			}
		}
	//this function will change the status of the offre_accepted:
	public boolean accept_or_refuse_the_student_offre(int id_offre_accepted,int status) {
		prof_dao prof_dao=new prof_dao();
		try {
			prof_dao.accept_or_refuse_the_student_offre(id_offre_accepted,status);
			
			return true;
		} 
		catch (SQLException e) {
			System.out.println("error in prof dao exception function accept_or_refuse_the_student_offre");
			return false;
			}
	}
	//this function will select all offres to accept them or refused them by prof:
	public boolean select_all_offres_to_accept_or_refuse(int id_prof){
		try {
			prof_dao prof_dao=new prof_dao();
			prof_dao.select_all_offres_to_accept_or_refuse(id_prof);
			return true;
			} 
		catch (SQLException e) {	
			System.out.println("error in prof dao exception function  select_all_offres_to_accept_or_refuse");
			return false;
			}
		}
	//this function will select all offres accepted by prof:
	public boolean select_all_offres_accepted(int id_prof) {
		try {
			prof_dao prof_dao=new prof_dao();
			prof_dao.select_all_offres_accepted(id_prof);		
			return true;
			} 
		catch (SQLException e) {
			System.out.println("error in prof dao exception function  select_all_offres_accept");
			return false;
			}					
	}
	//this function return the offre by id offre
	public offre get_offre_by_id(int id) {
		prof_dao prof_dao=new prof_dao();
		try {return prof_dao.get_offre_by_id(id);}
		catch (Exception e) {
			System.out.println("error in prof dao check exceptions function get_offre_by_id");
			return null;
		}
	}
	//this function return the name of matiere by id matiere
	public String get_matiere_by_id(int id) {
		prof_dao prof_dao=new prof_dao();
		try {return prof_dao.get_matiere_by_id(id);}
		catch (Exception e) {
			System.out.println("error in prof dao check exceptions function get_matiere_by_id");
			return null;
				}
			}
	//this fuction update offre data:	
	public boolean update_offre(HttpServletRequest request) {
		prof_dao prof_dao=new prof_dao();
		String image="";
		Part part=null;
		try {
			part=request.getPart("image");
			System.out.println("part is "+part);
		} catch (IOException | ServletException e1) {
			// TODO Auto-generated catch block
			System.out.println("student model edit profile error exeption 1");
		}
		if(part==null) {
		image=request.getParameter("image");		
		}
		else {
			String fileName= extractFileName(part);
			image="../assets/img/img_offre/"+fileName;
			String savePath = "C:\\Users\\hp\\eclipse-workspace\\LL\\src\\main\\webapp\\projet_V2\\assets\\img\\img_offre"+File.separator + fileName;
			try {
				part.write(savePath + File.separator);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("student model edit profile error exeption 2");
			}	
		}
		System.out.println(image);
		try {
			prof_dao.update_offre(Integer.parseInt(request.getParameter("hidden2")),request.getParameter("infos_update"),Double.parseDouble(request.getParameter("prix_update")),Integer.parseInt(request.getParameter("hidden3")),image);			
			} 
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	//the prof notifications:
	public boolean notification(int id) {
		prof_dao prof_dao=new prof_dao();
		try {
			prof_dao.notification(id);
			return true;
			}
		catch (NumberFormatException e) {
			e.printStackTrace();
			return false;
			}
		catch (Exception e) {
			e.printStackTrace();
			return false;
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
		
	//Search 
		
		public boolean search_prof_offre_created(HttpServletRequest request) {
			HttpSession session=request.getSession();
			prof prof=new prof();
			 prof=(Beans.prof) session.getAttribute("prof");
			prof_dao prof_dao = new prof_dao();
			
			try {
				prof_dao.search_prof_offre_created(request.getParameter("search_offre_created"),prof.getId_profs() );
				return true;
			} catch (SQLException e) {
				System.out.println("error in prof dao check exceptions function search_prof_offre_created");
				return false;
			}
		}
		
		public boolean search_prof_offre_accept_or_refuse(HttpServletRequest request) {
			HttpSession session=request.getSession();
			prof prof=new prof();
			 prof=(Beans.prof) session.getAttribute("prof");
			prof_dao prof_dao = new prof_dao();
			
			try {
				prof_dao.search_prof_offre_accept_or_refuse(request.getParameter("search_offre_accept_or_refuse"),prof.getId_profs() );
				return true;
			} catch (SQLException e) {
				System.out.println("error in prof dao check exceptions function search_prof_offre_accept_or_refuse");
				return false;
			}
		}
		
		public boolean search_prof_offre_accepted(HttpServletRequest request) {
			HttpSession session=request.getSession();
			prof prof=new prof();
			 prof=(Beans.prof) session.getAttribute("prof");
			prof_dao prof_dao = new prof_dao();
			
			try {
				prof_dao.search_prof_offre_accepted(request.getParameter("search_offre_accepted"),prof.getId_profs() );
				return true;
			} catch (SQLException e) {
				System.out.println("error in prof dao check exceptions function search_prof_offre_accepted");
				return false;
			}
		}
	}
