package Models;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Daos.admin_dao;
import Tables.tables_admin;
import Beans.*;
public class admin_model {
	public int verification(HttpServletRequest request, HttpServletResponse response) {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		HttpSession session=request.getSession();
		admin_dao admin_dao=new admin_dao();
		int operation_result = 0;
		try {
			operation_result=admin_dao.login_admin(email, password);
			if(operation_result!=-1 && operation_result>0) {
				session.setAttribute("operation_status", 1);
				return operation_result;
			}
			else {
				return -1;
			}
		} catch (Exception e) {
			System.out.println("error in admin dao check exceptions function login_admin model");
			return -1;
		}
	}
	public admin get_admin(int id) {
		admin_dao admin_dao=new admin_dao();
		try {
			return admin_dao.get_admin(id);
		} catch (Exception e) {
			System.out.println("error in admin dao check exceptions function get_admin model");
			return null;
		}
	}
	public boolean get_all_students() {
		admin_dao admin_dao=new admin_dao();
		try {
			admin_dao.get_all_students();
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function get_all_students");
			return false;
		}
	}
	public boolean get_all_profs() {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.get_all_profs();
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function get_all_profs");
			return false;
		}
	}
	public boolean get_all_offers() {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.get_all_offers();
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function get_all_offers");
			return false;
		}
	}
	public boolean get_all_offers_effect() {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.get_all_offers_effect();
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function get_all_offers_effect");
			return false;
		}
	}
	public boolean get_count_tables() {
		admin_dao admin_dao=new admin_dao();
		try {
			admin_dao.get_count_tables();
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function get_count_tables");
			return false;
		}
	}
	public boolean search_admin_student(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.search_admin_student(request.getParameter("search_student"));
			return true;
		} catch (Exception e) {
			System.out.println("error in admin dao check exceptions function search_admin_student");
			return false;
		}
	}
	public boolean search_admin_prof(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.search_admin_prof(request.getParameter("search_prof"));
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function search_admin_prof");
			return false;
		}
	}
	public boolean search_admin_offre(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.search_admin_offre(request.getParameter("search_offre"));
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function search_admin_offre");
			return false;
		}
	}
	public boolean search_admin_offre_effect(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.search_admin_offre_effect(request.getParameter("search_offre_effect"));
			return true;
		} catch (SQLException e) {
			System.out.println("error in admin dao check exceptions function search_admin_prof");
			return false;
		}
	}
	public boolean delete_student(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.delete_student(request.getParameter("student_to_delete"));
			return true;
		} catch (Exception e) {
			System.out.println("error in admin dao check exceptions function delete_student");
			return false;
		}
	}
	public boolean delete_offre(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.delete_offre(request.getParameter("offre_to_delete"));
			return true;
			}
			catch (Exception e) {
			System.out.println("error in admin dao check exceptions function delete_offre");
			return false;
		}		
		
	}
	public boolean delete_prof(HttpServletRequest request) {
		admin_dao admin_dao = new admin_dao();
		try {
			admin_dao.delete_prof(request.getParameter("prof_to_delete"));
			String id=request.getParameter("prof_to_delete");
			return true;	
			}
		 catch (Exception e) 
		{
			System.out.println("error in admin dao check exceptions function delete_prof");
			return false;
		}	
	}
	

	
	
}
