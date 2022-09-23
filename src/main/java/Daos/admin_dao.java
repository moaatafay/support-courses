package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.admin;
import Beans.admin_offre_effectue;
import Beans.offre;
import Beans.offre_complete_a_affiche;
import Beans.offre_effectue;
import Beans.prof;
import Beans.student;
import Tables.tables;
import Tables.tables_admin;

public class admin_dao {
	public Connection con;
	//function used to connect in database;
		public boolean connect_to_database() throws SQLException
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_first_data?useSSL=false&serverTimezone=UTC&allowMultiQueries=true","root","0000");
				return true;
			} catch (ClassNotFoundException e) {
				System.out.println("error in connection with database in admin_dao ...");
				return false;
			}
		}
		
		//check admin login informations
		public int login_admin(String email,String password) throws Exception {
			if(this.connect_to_database()) { 
				
				String count = "select count(*) from admin where email=\""+email+"\" and password=\""+password+"\"";
				  PreparedStatement preparedStatement = con.prepareStatement(count);
				  ResultSet result=preparedStatement.executeQuery();
				  int operation_result=0;
				  while(result.next()) {
						operation_result=result.getInt("count(*)");
						System.out.println("operation result"+operation_result);
					}
				return operation_result;
			} else {
				return -1;
			}
		}

		public admin get_admin(int id) throws Exception {
			if(this.connect_to_database()) {
				  String count = "select * from admin where id="+id;
				  PreparedStatement preparedStatement = con.prepareStatement(count);
				  ResultSet result=preparedStatement.executeQuery();
				  int the_id=0;
				  String email="";
				  String password="";
				  admin admin=new admin();
				  while(result.next()) {
					  the_id=result.getInt("id");
					  email=result.getString("email");
					  password=result.getString("password");		  
					}
				  admin.setEmail(email);
				  admin.setId(the_id);
				  admin.setPassword(password);
				  return admin;
			}
			else {
				return null;
			}	
		}
		
		public boolean get_all_students() throws SQLException {
			if(this.connect_to_database()) {
				String requete = "select family_name,name,email,img,id_students,city from students";
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.all_students.clear();
				while(result.next()) {
					student s=new student();
					s.setId_students(result.getInt("id_students"));
					s.setFamily_name(result.getString(1));
					s.setName(result.getString(2));
					s.setEmail(result.getString(3));
					s.setImg(result.getString(4));
					s.setCity(result.getString("city"));
					s.setOffres_accepted(this.nombre_offre(s.getId_students()));
					tables_admin.all_students.add(s);	
					
				}
				return true;
			}
			else {
				return false;
			}	
		}
		public int nombre_offre(int id) throws SQLException {
			if(this.connect_to_database()) { 
				String count_offres = "select count(*) as count from students s ,offre_accepted oa\r\n"
						+ " where oa.id_students=s.id_students\r\n"
						+ " and oa.status=1\r\n"
						+ " and s.id_students="+id+"\r\n"
						+ " and oa.date < date(now());";
				PreparedStatement preparedStatement = con.prepareStatement(count_offres);
				ResultSet result_count=preparedStatement.executeQuery();
				
				int count=-1;
				while(result_count.next()) {
					count = result_count.getInt("count");
				}
				
				return count;
			} else {
				return -1;
			}
		}
		public boolean get_all_profs() throws SQLException {
			if(this.connect_to_database()) {
				String requete="SELECT id_profs,family_name, name, email, bio, city,img from profs";
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.all_profs.clear();
				while(result.next()) {
				prof p =new prof();
				p.setId_profs(result.getInt("id_profs"));
				p.setFamily_name(result.getString("family_name"));
				p.setName(result.getString("name"));
				p.setBio(result.getString("bio"));
				p.setCity(result.getString("city"));
				p.setImg(result.getString("img"));
				p.setEmail(result.getString("email"));
				tables_admin.all_profs.add(p);
				}
				return true;
				}
				else {
				return false;
			}
		}
		public boolean get_all_offers() throws SQLException {
			if(this.connect_to_database()) {
				String requete="SELECT id_offre,infos,date,prix,id_profs,image FROM offre";
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.all_offres.clear();
				
				while(result.next()) {
				offre o =new offre();
				o.setId_offre(result.getInt("id_offre"));
				o.setInfos(result.getString("infos"));
				o.setDate(result.getString("date"));
				o.setPrix(result.getDouble("prix"));
				o.setProf_name(this.get_offers_profs(result.getInt("id_profs")));
				o.setImage(result.getString("image"));
				tables_admin.all_offres.add(o);
				}
				return true;
				}
				else {
				return false;
			}
		}
		public String get_offers_profs(int id) throws SQLException{
			if(this.connect_to_database()) {
				String requete="SELECT family_name,name FROM profs where id_profs="+id;
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				ResultSet result=preparedStatement.executeQuery();
				
				String full_name="";
				while(result.next()) {
					String family_name = result.getString("family_name");
					String name = result.getString("name");
					full_name=family_name+" "+name;
				}
				
				return full_name;
			} else { 
				return null;
			}
		}
		public boolean get_all_offers_effect() throws SQLException {
			if(this.connect_to_database()) 
			{
				String requete="select m.matiere,p.name as prof_name,p.family_name as prof_family_name,s.name as student_name,s.family_name as student_family_name,oa.date,oa.id_rate,st.lebelle\r\n"
						+ "from offre_accepted oa,matiere m,profs p,students s,status st,offre o\r\n"
						+ "where oa.id_offre=o.id_offre\r\n"
						+ "and oa.id_students=s.id_students\r\n"
						+ "and o.id_profs=p.id_profs\r\n"
						+ "and st.status=oa.status\r\n"
						+ "and o.id_matiere=m.id_matiere;";
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.all_offres_effect.clear();
				while(result.next()) {
				admin_offre_effectue o =new admin_offre_effectue();
				o.setDate(result.getString("date"));
				o.setLebelle(result.getString("lebelle"));
				o.setMatiere(result.getString("matiere"));
				o.setProf_family_name(result.getString("prof_family_name"));
				o.setProf_name(result.getString("prof_name"));
				o.setRate(result.getInt("id_rate"));
				o.setStudent_family_name(result.getString("student_family_name"));
				o.setStudent_name(result.getString("student_name"));
				tables_admin.all_offres_effect.add(o);
			}
			return true;
		}
		else {return false;}
		}
		public boolean get_count_tables() throws SQLException {
			if(this.connect_to_database()) {
			String count="select count(*) as count from profs";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {
				tables_admin.count_tables[0]=result.getInt("count");
			}
			count="select count(*) as count from students";
			preparedStatement = con.prepareStatement(count);
			result=preparedStatement.executeQuery();
			while(result.next()) {
				tables_admin.count_tables[1]=result.getInt("count");
			}
			count="select count(*) as count from offre";
			preparedStatement = con.prepareStatement(count);
			result=preparedStatement.executeQuery();
			while(result.next()) {
				tables_admin.count_tables[2]=result.getInt("count");
			}
			count="select count(*) as count from offre_accepted";
			preparedStatement = con.prepareStatement(count);
			result=preparedStatement.executeQuery();
			while(result.next()) {
				tables_admin.count_tables[3]=result.getInt("count");
			}
			
			return true;
			}
			else {
				return false;
			}
			
		}
		public void search_admin_student(String search) throws SQLException {
			if(this.connect_to_database()) {
				String count = "select family_name,name,email,img,id_students,city from students\r\n"
						+ "where \r\n"
						+ "(family_name like \"%"+search+"%\"  or name like \"%"+search+"%\" or email like \"%"+search+"%\" or city like\"%"+search+"%\" );";
				PreparedStatement preparedStatement = con.prepareStatement(count);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.search_student_list.clear();
				while(result.next())
				{
					student s=new student();
					s.setId_students(result.getInt("id_students"));
					s.setFamily_name(result.getString(1));
					s.setName(result.getString(2));
					s.setEmail(result.getString(3));
					s.setImg(result.getString(4));
					s.setCity(result.getString("city"));
					s.setOffres_accepted(nombre_offre(result.getInt("id_students")));
					tables_admin.search_student_list.add(s);
				}
		}
	}

		public void search_admin_prof(String search) throws SQLException {
			if(this.connect_to_database()) {
				String count = "SELECT id_profs,family_name, name, email, bio, city,img from profs\r\n"
						+ "where (family_name like \"%"+search+"%\" or name like \"%"+search+"%\" or email like \"%"+search+"%\" or bio like \"%"+search+"%\" or city like \"%"+search+"%\" );";
				PreparedStatement preparedStatement = con.prepareStatement(count);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.search_prof_list.clear();
				while(result.next())
				{
					prof p =new prof();
					p.setId_profs(result.getInt("id_profs"));
					p.setFamily_name(result.getString("family_name"));
					p.setName(result.getString("name"));
					p.setBio(result.getString("bio"));
					p.setCity(result.getString("city"));
					p.setImg(result.getString("img"));
					p.setEmail(result.getString("email"));
					tables_admin.search_prof_list.add(p);
				}	
			}	
		}

		public void search_admin_offre(String search) throws SQLException {
			if(this.connect_to_database()) {
				String count = "SELECT image,infos,date,prix,id_profs FROM offre\r\n"
						+ "where (infos like \"%"+search+"%\"  or date like \"%"+search+"%\"  or prix like \"%"+search+"%\" );";
				PreparedStatement preparedStatement = con.prepareStatement(count);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.search_offre_list.clear();
				while(result.next())
				{
					offre o =new offre();	
					o.setInfos(result.getString("infos"));
					o.setDate(result.getString("date"));
					o.setPrix(result.getDouble("prix"));
					o.setProf_name(get_offers_profs(result.getInt("id_profs")));
					o.setImage(result.getString("image"));
					tables_admin.search_offre_list.add(o);
				}	
			}
			
		}

		public void search_admin_offre_effect(String search) throws SQLException {
			if(this.connect_to_database()) {
				
				String count="select m.matiere,p.name as prof_name,p.family_name as prof_family_name,s.name as student_name,s.family_name as student_family_name,oa.date,oa.id_rate,st.lebelle\r\n"
						+ "from offre_accepted oa,matiere m,profs p,students s,status st,offre o\r\n"
						+ "where oa.id_offre=o.id_offre\r\n"
						+ "and oa.id_students=s.id_students\r\n"
						+ "and o.id_profs=p.id_profs\r\n"
						+ "and st.status=oa.status\r\n"
						+ "and o.id_matiere=m.id_matiere\r\n"
						+ "and (m.matiere like \"%"+search+"%\" or p.name like \"%"+search+"%\" or p.family_name like \"%"+search+"%\"\r\n"
						+ "or s.name like \"%"+search+"%\" or s.family_name like \"%"+search+"%\" or oa.date like \"%"+search+"%\" or st.lebelle like \"%"+search+"%\" or oa.id_rate like \"%"+search+"%\" ) ;";
				
				
				PreparedStatement preparedStatement = con.prepareStatement(count);
				ResultSet result=preparedStatement.executeQuery();
				tables_admin.search_offres_effect_list.clear();
				while(result.next())
				{
					admin_offre_effectue o =new admin_offre_effectue();
					o.setDate(result.getString("date"));
					o.setLebelle(result.getString("lebelle"));
					o.setMatiere(result.getString("matiere"));
					o.setProf_family_name(result.getString("prof_family_name"));
					o.setProf_name(result.getString("prof_name"));
					o.setRate(result.getInt("id_rate"));
					o.setStudent_family_name(result.getString("student_family_name"));
					o.setStudent_name(result.getString("student_name"));
					tables_admin.search_offres_effect_list.add(o);
				}	
			}
			
		}
		public void delete_student(String id) throws Exception {
			if(this.connect_to_database()) {
				String requete="DELETE FROM students WHERE id_students="+id;
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				preparedStatement.executeUpdate();
				requete="DELETE FROM offre_accepted WHERE status=0 and id_students="+id;
				preparedStatement = con.prepareStatement(requete);
				preparedStatement.executeUpdate();
				
			}
		}


		public void delete_offre(String id) throws Exception {
			if(this.connect_to_database()) {
				String requete="DELETE FROM offre WHERE id_offre="+id;
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				preparedStatement.executeUpdate();
			  }	
		}

		public void delete_prof(String id) throws SQLException {
			if(this.connect_to_database()) {
				String requete="DELETE FROM profs WHERE id_profs="+id;
				PreparedStatement preparedStatement = con.prepareStatement(requete);
				preparedStatement.executeUpdate();
				
				requete="DELETE from offre WHERE id_profs="+id;
				preparedStatement = con.prepareStatement(requete);
				preparedStatement.executeUpdate();
				
				requete="delete from offre_accepted where id_offre in(select id_offre from offre where id_profs="+id+") and status=0";
				preparedStatement = con.prepareStatement(requete);
				preparedStatement.executeUpdate();
			  }	
			
		}
		
	}
		
	
	

	
	
	
	



