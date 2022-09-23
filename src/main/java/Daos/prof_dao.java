package Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Beans.*;
import Tables.tables;

public class prof_dao {
	public Connection con;
	//function used to connect in database;
	public boolean connect_to_database() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_first_data?useSSL=false&serverTimezone=UTC","root","0000");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("error in connection with database in prof_dao ...");
			return false;
		}
	}
	//this function return -1 if data not match database else return the id of utilisator;
	public int check(String email,String password) throws Exception
	{
		// testing connection first:
		if(this.connect_to_database()) {
			  String count = "select count(*) from profs where email=\""+email+"\" and password=\""+password+"\"";
			  PreparedStatement preparedStatement = con.prepareStatement(count);
			  ResultSet result=preparedStatement.executeQuery();
			  int operation_result=0;
			  while(result.next()) {
					operation_result=result.getInt("count(*)");
				}
			  if(operation_result==0)// thats mean that no one in data base match this email and password
			  {
				  return -1;
			  }
			  else {
				  count="select id_profs from profs where email=\""+email+"\" and password=\""+password+"\"";
				  preparedStatement = con.prepareStatement(count);
				  result=preparedStatement.executeQuery();
				  result.next();
				  operation_result=result.getInt("id_profs");
				  System.out.println(operation_result);
				  
				  //prof_offres(operation_result);
				  
				  return operation_result;
			  }
		}
		else {
			return -1;
		}
		
	}
	//function that calcule the moyenne of offre defined by id
	double get_offre_moyenne(int id_offre) throws SQLException
	{
		double moyenne=-1;
		if(this.connect_to_database()) {
			String count="select avg(oa.id_rate) as average\r\n"
					+ "from profs p,students s,offre_accepted oa,offre o\r\n"
					+ "where s.id_students=oa.id_students\r\n"
					+ "and o.id_profs=p.id_profs \r\n"
					+ "and o.id_offre=oa.id_offre\r\n"
					+ "and o.id_offre="+id_offre+"\r\n"
					+ "and oa.id_rate is not null\r\n"
					+ "and oa.status=1;";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {
				moyenne=result.getDouble("average");
				}
			}
		return moyenne;
		}
	//return prof by String id
	public prof get_prof_by_id(String id) throws Exception {
		if(this.connect_to_database()) {
			  String count = "select * from profs where id_profs="+id;
			  System.out.println(count);
			  PreparedStatement preparedStatement = con.prepareStatement(count);
			  ResultSet result=preparedStatement.executeQuery();
			  int id_profs=0;
			  String family_name="";
			  String name="";
			  String email="";
			  String img="";
			  String password="";
			  String bio="";
			  String city="";
			  prof prof=new prof();
			  while(result.next()) {
				  id_profs=result.getInt("id_profs");
				  family_name=result.getString("family_name");
				  name=result.getString("name");
				  img=result.getNString("img");
				  email=result.getString("email");
				  password=result.getString("password");
				  bio=result.getString("bio");
				  city=result.getString("city");
				}
			 prof.setId_profs(id_profs);
			 prof.setName(name);
			 prof.setImg(img);
			 prof.setFamily_name(family_name);
			 prof.setPassword(password);
			 prof.setEmail(email);
			 prof.setBio(bio);
			 prof.setCity(city);
			return prof;
		}
		else {
			return null;
		}
	}
	//return prof by int id
	public prof get_prof_by_id(int id) throws Exception {
		return this.get_prof_by_id(Integer.toString(id));
	}
	//this function return true if this email never used and fale if its already used;
	public boolean is_it_one_email(String email) throws SQLException {
		if(this.connect_to_database()) {
			String count = "select count(*) from profs where email=\""+email+"\"";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			int nmbr=0;
			while(result.next()) {nmbr=result.getInt("count(*)");}
			if(nmbr==0) {return true;}
			else {return false;}
			}
		else {return false;}
		}
	//this function return the id of student that we just insert in data base or -1 if there is an error with connexion
	public int insert_prof_in_DB(prof prof) throws SQLException {
		if(this.connect_to_database()) {
			String INSERT_USERS_SQL = "insert into profs(family_name,name,email,password,img) values(?,?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setString(1, prof.getFamily_name());
			preparedStatement.setString(2, prof.getName());
			preparedStatement.setString(3, prof.getEmail());
			preparedStatement.setString(4, prof.getPassword());
		    preparedStatement.setString(5, "../assets/img/theme/team-4.jpg");
			preparedStatement.executeUpdate();
			String count = "select id_profs from profs where email=\""+prof.getEmail()+"\" and password=\""+prof.getPassword()+"\"";
			preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			int i=0;
			while(result.next()) {i=result.getInt("id_profs");}
				return i;
			}
		else {return -1;}	
	   }
	// la fnct qui nous affiches tt les matiere de base de donne.
	public boolean get_all_matiere() throws SQLException {
		if(this.connect_to_database()) {
			String count="select  matiere from matiere ";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.all_matiere.clear();
			while(result.next()) {tables.all_matiere.add(result.getString("matiere"));}
			return true;
			}
		else {return false;}	
		} 
	//this function add offre in batabase :
	public int insert_offre_in_DB(offre offre ) throws SQLException {
		if(this.connect_to_database()) {
		String INSERT_offer_SQL = "INSERT INTO `offre` (`id_profs`,`prix`,`infos`,`image`,`id_matiere`,`date`) VALUES (?,?,?,?,?,?);";
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_offer_SQL);
		preparedStatement.setString(2, String.valueOf(offre.getPrix()));
		preparedStatement.setString(3, offre.getInfos());
		preparedStatement.setString(4, offre.getImage());
		preparedStatement.setInt(5, offre.getId_matiere());
	    preparedStatement.setInt(1, offre.getId_profs());
	    preparedStatement.setString(6, offre.getDate());
		preparedStatement.executeUpdate();	        
		return 0;
		}
		else {return -1;}	
	}
		//this function search for id_matiere :
    //trouver l id de matiere par matiere
	public int search_id_matiere( String matiere ) throws SQLException {
		if(this.connect_to_database()) {
			int operation=0;
			int id=0;
			String count="select count(*) from matiere where matiere=\"" +matiere+ "\"" ;	
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {operation=result.getInt("count(*)");}
			if(operation==0) {
				String count1="insert into matiere (`matiere`) values(?)" ;
				PreparedStatement preparedStatement1 = con.prepareStatement(count1);
				preparedStatement1.setString(1, matiere);
				preparedStatement1.executeUpdate();			
				return this.search_id_matiere(matiere);
				}
			else {
				String count2="select * from matiere where matiere=\""+matiere+"\"" ;
				PreparedStatement preparedStatement2 = con.prepareStatement(count2);
				ResultSet result2=preparedStatement2.executeQuery();
				while(result2.next()) {id=result2.getInt("id_matiere");}
				return id;
				}
			}
		return -1;
	}
	/*//this function search about id_offre:
			public int search_id_offre(offre offre) throws SQLException {
				if(this.connect_to_database()) {	
					String count="select  id_offre from offre where id_prof=\""+offre.getId_profs()+"\"and id_matiere=\""+offre.getId_matiere()+"\"" ;
					PreparedStatement preparedStatement = con.prepareStatement(count);
					ResultSet result=preparedStatement.executeQuery();			
					return result.getInt("id_offre");
					}
				else {return -1;}	
					}*/
	//this function getall offres of profs
	public boolean prof_offres(int id) throws SQLException {
		if(this.connect_to_database()) {	
			String count1="select o.id_offre as id_offre,o.image as img,m.matiere as matiere,o.prix as prix,o.date as date from matiere m,offre o where o.id_profs=\""+id+"\" and o.id_matiere=m.id_matiere order by o.date desc;";
			PreparedStatement preparedStatement1 = con.prepareStatement(count1);
			ResultSet result1=preparedStatement1.executeQuery();
			tables.all_offres_byID.clear();
			while(result1.next()) {
				offre_complete_a_affiche o=new offre_complete_a_affiche();
				o.setId_offre(result1.getInt("id_offre"));
				o.setMatiere(result1.getString("matiere"));
				o.setDate(result1.getString("date"));
				o.setPrix(result1.getDouble("prix"));
				o.setImageOffre(result1.getString("img"));
				o.setMoyenne(this.get_offre_moyenne(result1.getInt("id_offre")));		
				tables.all_offres_byID.add(o);
				}			
			return true;
			}
		else {return false;}	
	}
	//supprimer un offre definit par son id	
	public void delete_offre(int id) throws Exception {
		if(this.connect_to_database()) {		
			String count="delete from offre where id_offre="+id ;
			PreparedStatement preparedStatement = con.prepareStatement(count);
			preparedStatement.executeUpdate();}
        else {System.out.println("delete_offre de DAO ne fonction pas");}			
	}
	//le changement des champs de bd
	public boolean edit_champ(int id_profs,String champ,String val) throws SQLException {
		if(this.connect_to_database()) {
			String count = " update profs set "+champ+"=\""+val+"\" where id_profs="+id_profs+";";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			preparedStatement.executeUpdate();
			return true;
			}
		else {
			return false;
		}
	}
	//edit profile 
	public boolean edit_profile(prof prof) throws Exception {
		if(!prof.getEmail().isEmpty())
		{
			if(!this.is_it_one_email(prof.getEmail())){
			throw new Exception("this email is already used");
			}
			else 
			{
				this.edit_champ(prof.getId_profs(),"email",prof.getEmail());
				if(!prof.getName().isEmpty()) 
				{
					this.edit_champ(prof.getId_profs(),"name",prof.getName());
				}
				if(!prof.getBio().isEmpty())
				{
					this.edit_champ(prof.getId_profs(),"bio",prof.getBio());
				}
				if(!prof.getCity().isEmpty()) 
				{
					this.edit_champ(prof.getId_profs(),"city",prof.getCity());
				}
				if(!prof.getFamily_name().isEmpty()) 
				{
					this.edit_champ(prof.getId_profs(),"family_name",prof.getFamily_name());
				}
				if(!prof.getImg().isEmpty() && !prof.getImg().equals("../assets/img/img_offre/")) 
				{
					this.edit_champ(prof.getId_profs(),"img",prof.getImg());
				}
				if(!prof.getPassword().isEmpty()) 
				{
					this.edit_champ(prof.getId_profs(),"password",prof.getPassword());
				}
			}
		}
		
		if(!prof.getName().isEmpty())
		{
			this.edit_champ(prof.getId_profs(),"name",prof.getName());
		}
		if(!prof.getBio().isEmpty())
		{
			this.edit_champ(prof.getId_profs(),"bio",prof.getBio());
		}
		if(!prof.getCity().isEmpty())
		{
			this.edit_champ(prof.getId_profs(),"city",prof.getCity());
		}
		if(!prof.getFamily_name().isEmpty()) 
		{
			this.edit_champ(prof.getId_profs(),"family_name",prof.getFamily_name());
		}
		if(!prof.getImg().isEmpty() && !prof.getImg().equals("../assets/img/img_offre/")) 
		{
			this.edit_champ(prof.getId_profs(),"img",prof.getImg());
		}
		if(!prof.getPassword().isEmpty())
		{
			this.edit_champ(prof.getId_profs(),"password",prof.getPassword());
		}
        return true;	
	}
	//acceptation ou refuser la demande d'etudiant:
	public boolean accept_or_refuse_the_student_offre(int id_offre_accepted,int status) throws SQLException {
		if(this.connect_to_database()) {
			String INSERT_USERS_SQL = "update offre_accepted set status ="+status+" where id_offre_accepted="+id_offre_accepted+";";
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
	        preparedStatement.executeUpdate();
	        return true;
		}
		else {
			return false;
		}
	}
	//afficher tout les demandes des etudiants
	public boolean select_all_offres_to_accept_or_refuse(int id_prof) throws SQLException {
		if(this.connect_to_database()) {
			String count= "select oa.id_offre_accepted,s.email,m.matiere,o.prix,oa.date,oa.start,oa.finish,oa.localisation,o.image \r\n"
					+ "from offre_accepted oa,offre o,students s,matiere m\r\n"
					+ "where oa.id_offre=o.id_offre\r\n"
					+ "and m.id_matiere=o.id_matiere\r\n"
					+ "and s.id_students=oa.id_students\r\n"
					+ "and oa.status=0\r\n"
					+ "and oa.status=0 and (oa.date >date(now()) or ( oa.date =date(now())  and  oa.start >=time(now())  )) \r\n"
					+ "and o.id_profs="+id_prof+" \r\n"
			        + "order by oa.date desc;";
			
			
			 PreparedStatement preparedStatement = con.prepareStatement(count);
			 ResultSet result=preparedStatement.executeQuery();
			 tables.prof_accept_or_refuse_list.clear();
			 while(result.next()) {
				 offres_received_by_prof_to_accept_or_refuse or=new offres_received_by_prof_to_accept_or_refuse();
				 or.setDate(result.getString("date"));
				 or.setId_offre_accepted(result.getInt("id_offre_accepted"));
				 or.setMatiere(result.getString("matiere"));
				 or.setEmail(result.getString("email"));
				 or.setStart(result.getString("start"));
				 or.setFinish(result.getString("finish"));
				 or.setImage(result.getString("image"));
				 or.setLocalisation(result.getString("localisation"));
				 or.setPrix(result.getDouble("prix"));
				 tables.prof_accept_or_refuse_list.add(or);
			 }
			 return true;
		}
		else {
				return false;
		}
	}
	public boolean select_all_offres_accepted(int id_prof) throws SQLException {
		if(this.connect_to_database()) {
			String count= "select oa.id_offre_accepted,s.email,m.matiere,o.prix,oa.date,oa.start,oa.finish,oa.localisation,o.image \r\n"
					+ "from offre_accepted oa,offre o,students s,matiere m \r\n"
					+ "where oa.id_offre=o.id_offre \r\n"
					+ "and m.id_matiere=o.id_matiere \r\n"
					+ "and s.id_students=oa.id_students \r\n"
					+ "and oa.status=1 \r\n"
					+ "and (oa.date >date(now()) or ( oa.date =date(now())  and  oa.start >=time(now()))) \r\n"
					+ "and o.id_profs="+id_prof+" \r\n"
					+ "order by oa.date desc;";
			 PreparedStatement preparedStatement = con.prepareStatement(count);
			 ResultSet result=preparedStatement.executeQuery();
			 tables.prof_accept_list.clear();
			 while(result.next()) {
				 offres_received_by_prof_to_accept_or_refuse or=new offres_received_by_prof_to_accept_or_refuse();
				 or.setDate(result.getString("date"));
				 or.setId_offre_accepted(result.getInt("id_offre_accepted"));
				 or.setMatiere(result.getString("matiere"));
				 or.setEmail(result.getString("email"));
				 or.setStart(result.getString("start"));
				 or.setFinish(result.getString("finish"));
				 or.setImage(result.getString("image"));
				 or.setLocalisation(result.getString("localisation"));
				 or.setPrix(result.getDouble("prix"));
				 tables.prof_accept_list.add(or);
			 }
			 return true;
		}
		else {
				return false;
		}
	}
	//this function get pupilaire offres of profs
	public void pupilaire_offres() throws SQLException {
		if(this.connect_to_database()) {
			String count1="SELECT avg(oa.id_rate),oa.id_offre,p.img,o.image,p.family_name,p.name,m.matiere,o.prix,o.infos,o.date FROM offre_accepted oa,matiere m,profs p, offre o\r\n"
					+ "where oa.id_offre=o.id_offre\r\n"
					+ "and m.id_matiere=o.id_matiere\r\n"
					+ "and p.id_profs=o.id_profs\r\n"   
					+ "and oa.status=1\r\n"
					+ "GROUP BY id_offre\r\n"
					+ "ORDER BY avg(oa.id_rate) DESC;";
			PreparedStatement preparedStatement1 = con.prepareStatement(count1);
			ResultSet result1=preparedStatement1.executeQuery();
			tables.pupilaire_3_offres.clear();
			while(result1.next()) {
				offre_complete_a_affiche o=new offre_complete_a_affiche();
				o.setId_offre(result1.getInt("id_offre"));
				o.setName(result1.getString("name"));
				o.setFamily_name(result1.getString("family_name"));
				o.setMatiere(result1.getString("matiere"));
				o.setInfos(result1.getString("infos"));
				o.setDate(result1.getString("date"));
				o.setPrix(result1.getDouble("prix"));
				o.setImg(result1.getString("img"));
				o.setImageOffre(result1.getString("image"));
				o.setMoyenne(this.get_offre_moyenne(result1.getInt("id_offre")));
				tables.pupilaire_3_offres.add(o);
				}			
		}
		else {System.out.println("eror in connection DB");}	
	   }
	//return the offre defined by id
	public offre get_offre_by_id(int id) throws Exception {
	if(this.connect_to_database()) {
		String count = "select * from offre where id_offre="+id;  
		PreparedStatement preparedStatement = con.prepareStatement(count);
		ResultSet result=preparedStatement.executeQuery();  
		int id_offre=0;
		int id_matiere=0;
		String infos="";
		String date="";
		String img="";
		double prix = 0;
		int id_profs=0;
		offre offre=new offre();
		while(result.next()) 
		{
			id_matiere=result.getInt("id_matiere");
			id_offre=result.getInt("id_offre");
			infos=result.getString("infos");
			date=result.getNString("date");
			prix=result.getDouble("prix");
			img=result.getString("image");
			id_profs=result.getInt("id_profs");	  
		}
		offre.setId_offre(id_offre);
		offre.setId_matiere(id_matiere);
		offre.setInfos(infos);
		offre.setDate(date);
		offre.setPrix(prix);
		offre.setImage(img);
		offre.setId_profs(id_profs); 
		return offre  ;
		}
	else {return null;}
	}
	//return the matiere defined by id
	public String  get_matiere_by_id(int id) throws Exception 
	{
		if(this.connect_to_database()) 
		{
			String count = "select matiere from matiere where id_matiere="+id;
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			String matiere="";
			while(result.next()) {matiere=result.getString("matiere");}	
			return  matiere ;
		}
		else {return null;}
	}	
	//update offre created by prof:
	public void update_offre(int id_offre,String infos,double prix,int id_prof,String image ) throws Exception {
		if(this.connect_to_database())
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date();
			String count = "update offre set infos=\""+infos+"\" , prix="+prix+" ,image=\""+image+"\", date=\""+formatter.format(date)+"\" where id_offre="+id_offre+";";	
			PreparedStatement preparedStatement = con.prepareStatement(count);
			preparedStatement.executeUpdate();
			count = "select o.id_offre,m.matiere,o.infos,o.date,o.prix,o.image from offre o,matiere m where id_profs="+id_prof+" and o.id_matiere=m.id_matiere";
			preparedStatement = con.prepareStatement(count);
			ResultSet result = preparedStatement.executeQuery();				
			tables.all_offres_byID.clear();
			while(result.next())
			{
				offre_complete_a_affiche o=new offre_complete_a_affiche(); 
				o.setId_offre(result.getInt("id_offre"));
				o.setMatiere(result.getString("matiere"));
				o.setInfos(result.getString("infos"));
				o.setDate(result.getString("date"));
				o.setPrix(result.getDouble("prix"));
				o.setImageOffre(result.getString("image"));
				o.setMoyenne(this.get_offre_moyenne(result.getInt("id_offre")));				
				tables.all_offres_byID.add(o);		
			}	
		}	
	}
	//les notification recu par prof	
	public void notification(int id_prof ) throws Exception {
		if(this.connect_to_database())
		{
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date();
			String count ="select O.name , O.family_name , P.prix , O.email , O.img ,  S.id_offre_accepted   , S.date  , S.start , S.finish , M.matiere   \r\n"
					+ " FROM offre_accepted as S , students as O , matiere as M , offre as P \r\n"
					+ "where S.id_students like O.id_students \r\n"
					+ "AND S.id_offre like P.id_offre \r\n"
					+ "AND P.id_matiere like M.id_matiere   \r\n"
					+ "AND S.status="+0+" \r\n"
					+ "AND P.id_profs="+id_prof+" \r\n"
					+ "and S.status=0 \r\n"
					+"and (S.date >date(now()) or ( S.date =date(now())  and  S.start >=time(now())  )) \r\n"
					+ "order by S.date desc;";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result = preparedStatement.executeQuery();
			tables.notification_prof.clear();
			while(result.next())
			{
				offre_accepted_complete_a_afficher o=new offre_accepted_complete_a_afficher(); 
				o.setId_offre_accepted(result.getInt("id_offre_accepted"));
				o.setStart(result.getString("start"));
				o.setDate(result.getString("date"));
				o.setFinish(result.getString("finish"));
				o.setEmail(result.getString("email"));
				o.setImg(result.getString("img"));
				o.setMatiere(result.getString("matiere"));
				o.setFamily_name(result.getString("family_name"));
				o.setName(result.getString("name"));
				o.setPrix(result.getDouble("prix"));
				tables.notification_prof.add(o);		
			}	
		}
	}
	
	// Search
				public boolean search_prof_offre_created(String search,int id) throws SQLException {
					if(this.connect_to_database()) {
						String count = "select m.id_matiere,o.id_matiere,o.id_profs as id_profs,o.id_offre as id_offre,o.image as img,m.matiere as matiere,o.prix as prix,o.date as date from matiere m,offre o\r\n"
								+ "where "+id+"=id_profs \r\n"
								+ "AND  m.id_matiere=o.id_matiere \r\n"
								+ " AND ( matiere like \"%"+search+"%\"  or prix like \"%"+search+"%\" or date like \"%"+search+"%\" );";
						PreparedStatement preparedStatement = con.prepareStatement(count);
						ResultSet result=preparedStatement.executeQuery();
						tables.search_prof_offre_created_list.clear();
						while(result.next())
						{
							offre_complete_a_affiche o= new offre_complete_a_affiche();
							
							o.setId_offre(result.getInt("id_offre"));
							o.setMatiere(result.getString("matiere"));
							o.setDate(result.getString("date"));
							o.setPrix(result.getDouble("prix"));
							o.setImg(result.getString("img"));
							o.setMoyenne(this.get_offre_moyenne(result.getInt("id_offre")));	
							
							tables.search_prof_offre_created_list.add(o);
						}
						return true;	
					}
					else {
						return false;
					}
					
				}
				
				public boolean search_prof_offre_accept_or_refuse(String search,int id) throws SQLException {
					if(this.connect_to_database()) {
						String count = "select m.matiere,oa.id_offre_accepted,s.email,m.matiere,o.prix,oa.date,oa.start,oa.finish,oa.localisation,o.image \r\n"
								+ "from offre_accepted oa,offre o,students s,matiere m\r\n"
								+ "where oa.id_offre=o.id_offre\r\n"
								+ "and m.id_matiere=o.id_matiere\r\n"
								+ "and s.id_students=oa.id_students\r\n"
								+ "and oa.status=0 and (oa.date >date(now()) or ( oa.date =date(now())  and  oa.start >=time(now())  ))\r\n"
								+ "and "+id+"=o.id_profs \r\n"
								+ "and ( m.matiere like \"%"+search+"%\"  or o.prix like \"%"+search+"%\" or oa.date like \"%"+search+"%\" \r\n)"
								+ "order by oa.date desc;";
						PreparedStatement preparedStatement = con.prepareStatement(count);
						ResultSet result=preparedStatement.executeQuery();
						tables.search_prof_offre_accept_or_refuse_list.clear();
						while(result.next())
						{
							offres_received_by_prof_to_accept_or_refuse or=new offres_received_by_prof_to_accept_or_refuse();
							 or.setDate(result.getString("date"));
							 or.setId_offre_accepted(result.getInt("id_offre_accepted"));
							 or.setMatiere(result.getString("matiere"));
							 or.setEmail(result.getString("email"));
							 or.setStart(result.getString("start"));
							 or.setFinish(result.getString("finish"));
							 or.setImage(result.getString("image"));
							 or.setLocalisation(result.getString("localisation"));
							 or.setPrix(result.getDouble("prix"));
							tables.search_prof_offre_accept_or_refuse_list.add(or);
						}
						return true;	
					}
					else {
						return false;
					}
					
				}
				
				public boolean search_prof_offre_accepted(String search,int id) throws SQLException {
					if(this.connect_to_database()) {
						String count = "select m.matiere,oa.id_offre_accepted,s.email,m.matiere,o.prix,oa.date,oa.start,oa.finish,oa.localisation,o.image \r\n"
								+ "from offre_accepted oa,offre o,students s,matiere m \r\n"
								+ "where oa.id_offre=o.id_offre \r\n"
								+ "and m.id_matiere=o.id_matiere \r\n"
								+ "and s.id_students=oa.id_students \r\n"
								+ "and oa.status=1 \r\n"
								+ "and (oa.date >date(now()) or ( oa.date =date(now())  and  oa.start >=time(now()))) \r\n"
								+ "and "+id+"=o.id_profs \r\n"
								+ "and ( m.matiere like \"%"+search+"%\"  or o.prix like \"%"+search+"%\" or oa.date like \"%"+search+"%\" ) \r\n"
								+ "order by oa.date desc;";
						PreparedStatement preparedStatement = con.prepareStatement(count);
						ResultSet result=preparedStatement.executeQuery();
						tables.search_prof_offre_accepted_list.clear();
						while(result.next())
						{
							offres_received_by_prof_to_accept_or_refuse or=new offres_received_by_prof_to_accept_or_refuse();
							 or.setDate(result.getString("date"));
							 or.setId_offre_accepted(result.getInt("id_offre_accepted"));
							 or.setMatiere(result.getString("matiere"));
							 or.setEmail(result.getString("email"));
							 or.setStart(result.getString("start"));
							 or.setFinish(result.getString("finish"));
							 or.setImage(result.getString("image"));
							 or.setLocalisation(result.getString("localisation"));
							 or.setPrix(result.getDouble("prix"));
							tables.search_prof_offre_accepted_list.add(or);
						}
						return true;	
					}
					else {
						return false;
					}
					
				}
}
