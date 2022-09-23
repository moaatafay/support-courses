package Daos;
import Beans.*;
import Tables.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class student_dao {
	
	public Connection con;
	//function used to connect in database;
	public boolean connect_to_database() throws SQLException
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_first_data?useSSL=false&serverTimezone=UTC","root","0000");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("error in connection with database in student_dao ...");
			return false;
		}
	}
	//this function return -1 if data not match database else return the id of utilisator;
	public int check(String email,String password) throws Exception
	{
		// testing connection first:
		if(this.connect_to_database()) {
			  String count = "select count(*) from students where email=\""+email+"\" and password=\""+password+"\"";
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
				  count="select id_students from students where email=\""+email+"\" and password=\""+password+"\"";
				  preparedStatement = con.prepareStatement(count);
				  result=preparedStatement.executeQuery();
				  result.next();
				  operation_result=result.getInt("id_students");
				  System.out.println(operation_result);
				  return operation_result;
			  }
		}
		else {
			return -1;
		}
		
	}
    //this function return student if we found his id in DB or null if we didnt 
	public student get_student_by_id(String id) throws Exception {
		if(this.connect_to_database()) {
			  String count = "select * from students where id_students="+id;
			  System.out.println(count);
			  PreparedStatement preparedStatement = con.prepareStatement(count);
			  ResultSet result=preparedStatement.executeQuery();
			  int id_students=0;
			  String family_name="";
			  String name="";
			  String email="";
			  String password="";
			  String img="";
			  String bio="";
			  String city="";
			  student student=new student();
			  while(result.next()) {
				  id_students=result.getInt("id_students");
				  family_name=result.getString("family_name");
				  name=result.getString("name");
				  email=result.getString("email");
				  password=result.getString("password");
				  img=result.getString("img");
				  bio=result.getString("bio");
				  city=result.getString("city");
				  
				}
			  student.setId_students(id_students);
			  student.setName(name);
			  student.setFamily_name(family_name);
			  student.setPassword(password);
			  student.setEmail(email);	
			  student.setImg(img);
			  student.setBio(bio);
			  student.setCity(city);
				return student;
		}
		else {
			return null;
		}
	}
	//re inscription of the previous function with integer data.
	public student get_student_by_id(int id) throws Exception {
		return this.get_student_by_id(Integer.toString(id));
	}
	//this function return true if this email never used and fale if its already used;
	public boolean is_it_one_email(String email) throws SQLException {
		if(this.connect_to_database()) {
			String count = "select count(*) from students where email=\""+email+"\"";
			  System.out.println(count);
			  PreparedStatement preparedStatement = con.prepareStatement(count);
			  ResultSet result=preparedStatement.executeQuery();
			  int nmbr=0;
			  while(result.next()) {
					nmbr=result.getInt("count(*)");
				}
			  if(nmbr==0) {
				  return true;
			  }
			 
			  else {
				  return false;
			  }
		}
		else {
			return false;
		}
	}
	//this function return the id of student that we just insert in data base or -1 if there is an error with connexion
	public int insert_student_in_DB(student student) throws SQLException {
		if(this.connect_to_database()) {
		String INSERT_USERS_SQL = "insert into students(family_name,name,email,password,img) values(?,?,?,?,?);";
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
		preparedStatement.setString(1, student.getFamily_name());
        preparedStatement.setString(2, student.getName());
        preparedStatement.setString(3, student.getEmail());
        preparedStatement.setString(4, student.getPassword());
        preparedStatement.setString(5, "../assets/img/theme/avatar.png");
        preparedStatement.executeUpdate();
        String count = "select id_students from students where email=\""+student.getEmail()+"\" and password=\""+student.getPassword()+"\"";
		preparedStatement = con.prepareStatement(count);
	    ResultSet result=preparedStatement.executeQuery();
	    int i=0;
		while(result.next()) {
			i=result.getInt("id_students");
		}
		System.out.println(i);
		return i;
	}
		else {
			return -1;
		}	
   }
   // la fnct qui nous donne les 3 derniere offres.
	public boolean get_last_3_offres() throws SQLException {
		if(this.connect_to_database()) {
			String count = "select o.id_offre,p.family_name,p.img,o.image,p.name as name,p.email as email,o.infos as infos,m.matiere as matiere,o.prix as prix,o.date as date from profs p,matiere m,offre o where o.id_profs=p.id_profs and o.id_matiere=m.id_matiere order by date desc limit 6";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.last_3_offres.clear();
			while(result.next()) {
				offre_complete_a_affiche o=new offre_complete_a_affiche();
				o.setId_offre(result.getInt("id_offre"));
				o.setMatiere(result.getString("matiere"));
				o.setName(result.getString("name"));
				o.setFamily_name(result.getString("family_name"));
				o.setDate(result.getString("date"));
				o.setPrix(result.getDouble("prix"));
				o.setEmail(result.getString("email"));
				o.setInfos(result.getString("infos"));
				o.setImg(result.getString("img"));
				o.setImageOffre(result.getString("image"));
				o.setMoyenne(this.get_offre_moyenne(result.getInt("id_offre")));
				tables.last_3_offres.add(o);	
			}
			return true;
		}
		else {
			return false;
		}	
	}
	// la fnct qui nous donne 3 random profs
	public boolean get_random_3_profs() throws SQLException {
		if(this.connect_to_database()) {
			String count = "SELECT id_profs,family_name,name,email,bio,img,city FROM profs ORDER BY RAND() LIMIT 3";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.random_3_profs.clear();
			while(result.next()) {
				prof p=new prof();
				p.setId_profs(result.getInt("id_profs"));
				p.setName(result.getString("name"));
				p.setFamily_name(result.getString("family_name"));
				p.setEmail(result.getString("email"));
				p.setCity(result.getString("city"));
				p.setBio(result.getString("bio"));
				p.setImg(result.getString("img"));
				tables.random_3_profs.add(p);	
			}	
			return true;
		}
		else {
			return false;
		}
	}
    //la fnct qui nous donne le nmbr d eleve profs offres.
	public boolean get_count_tables() throws SQLException {
		if(this.connect_to_database()) {
		String count="select count(*) as count from profs";
		PreparedStatement preparedStatement = con.prepareStatement(count);
		ResultSet result=preparedStatement.executeQuery();
		while(result.next()) {
			tables.count_tables[0]=result.getInt("count");
		}
		count="select count(*) as count from students";
		preparedStatement = con.prepareStatement(count);
		result=preparedStatement.executeQuery();
		while(result.next()) {
			tables.count_tables[1]=result.getInt("count");
		}
		count="select count(*) as count from offre";
		preparedStatement = con.prepareStatement(count);
		result=preparedStatement.executeQuery();
		while(result.next()) {
			tables.count_tables[2]=result.getInt("count");
		}
		count="select count(*) as count from offre_accepted";
		preparedStatement = con.prepareStatement(count);
		result=preparedStatement.executeQuery();
		while(result.next()) {
			tables.count_tables[3]=result.getInt("count");
		}
		
		return true;
		}
		else {
			return false;
		}
		
	}
    // la fnct qui nous affiches tt lesoffres de base de donne.
	public boolean get_all_offres() throws SQLException {
		if(this.connect_to_database()) {
			String count="select o.id_offre,o.image,p.family_name,p.img,p.name as name,p.email as email,o.infos as infos,m.matiere as matiere,o.prix as prix,o.date as date from profs p,matiere m,offre o where o.id_profs=p.id_profs and o.id_matiere=m.id_matiere order by date desc ";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.all_offres.clear();
			while(result.next()) {
				offre_complete_a_affiche o=new offre_complete_a_affiche();
				o.setId_offre(result.getInt("id_offre"));
				o.setMatiere(result.getString("matiere"));
				o.setName(result.getString("name"));
				o.setFamily_name(result.getString("family_name"));
				o.setDate(result.getString("date"));
				o.setPrix(result.getDouble("prix"));
				o.setEmail(result.getString("email"));
				o.setInfos(result.getString("infos"));
				o.setImg(result.getString("img"));
				o.setImageOffre(result.getString("image"));
				o.setMoyenne(this.get_offre_moyenne(result.getInt("id_offre")));
				tables.all_offres.add(o);
			}	
			
			return true;
		}
		else {
			return false;
		}
		
	}
    //la fnct qui nous donne tt les offre que utilisateur a passe pour les note.
	public boolean get_offres_that_i_passed(int id) throws SQLException {
		if(this.connect_to_database()) {
			String count = "select oa.id_offre_accepted,p.family_name,p.name,p.email,o.prix,m.matiere,oa.date,oa.start,oa.finish \r\n"
					+ "from offre_accepted oa,profs p,matiere m,offre o \r\n"
					+ "where oa.id_offre=o.id_offre \r\n"
					+ "and o.id_profs=p.id_profs \r\n"
					+ "and m.id_matiere=o.id_matiere \r\n"
					+ "and oa.id_students="+id+" \r\n"
					+ "and oa.status=1 and (oa.date <date(now()) or ( oa.date =date(now())  and  oa.finish <=time(now())  )) \r\n"
					+ "and oa.id_rate is null \r\n"
					+ "order by oa.date;";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.all_offres_that_i_passed.clear();
			while(result.next())
			{
				offre_accepted_complete_a_afficher o=new offre_accepted_complete_a_afficher(); 
				o.setId_offre_accepted(result.getInt("id_offre_accepted"));
				o.setFamily_name(result.getString("family_name"));
				o.setName(result.getString("name"));
				o.setEmail(result.getString("email"));
				o.setPrix(result.getDouble("prix"));
				o.setMatiere(result.getString("matiere"));
				o.setDate(result.getString("date"));
				o.setStart(result.getString("start"));
				o.setFinish(result.getString("finish"));
				tables.all_offres_that_i_passed.add(o);		
			}
		}
		else {
			
		}
		return true;
		
	}
    // la fnct qui permet de search.
	public boolean search_student(String search) throws SQLException {
		if(this.connect_to_database()) {
			String count = "select o.id_offre,o.image,p.img,p.family_name,p.name,p.email,o.infos,m.matiere,o.date,o.prix from profs p,matiere m,offre o where o.id_profs=p.id_profs and m.id_matiere=o.id_matiere and (p.family_name like\"%"+search+"%\" or p.name like\"%"+search+"%\" or m.matiere like\"%"+search+"%\" or p.email like\"%"+search+"%\" )";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.search_student_list.clear();
			while(result.next())
			{
				offre_complete_a_affiche o=new offre_complete_a_affiche();
				o.setDate(result.getString("date"));
				o.setEmail(result.getString("email"));
				o.setFamily_name(result.getString("family_name"));
				o.setId_offre(result.getInt("id_offre"));
				o.setInfos(result.getString("infos"));
				o.setMatiere(result.getString("matiere"));
				o.setName(result.getString("name"));
				o.setPrix(result.getDouble("prix"));
				o.setImg(result.getString("img"));
				o.setImageOffre(result.getString("image"));
				o.setMoyenne(this.get_offre_moyenne(result.getInt("id_offre")));
				tables.search_student_list.add(o);
			}
			return true;	
		}
		else {
			return false;
		}
		
	}
    // accepter un offre.
	public boolean valider_offre(offre_accepted offre_accepted) throws SQLException {
		if(this.connect_to_database()) {
			String INSERT_USERS_SQL = "insert into offre_accepted(id_offre,id_students,date,start,finish,status,localisation) values(?,?,?,?,?,?,?);";
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL);
			preparedStatement.setInt(1, offre_accepted.getId_offre());
	        preparedStatement.setInt(2, offre_accepted.getId_students());
	        preparedStatement.setString(3, offre_accepted.getDate());
	        preparedStatement.setString(4, offre_accepted.getStart());
	        preparedStatement.setString(5, offre_accepted.getFinish());
	        preparedStatement.setInt(6, offre_accepted.getStatus());
	        preparedStatement.setString(7, offre_accepted.getLocalisation());
	        preparedStatement.executeUpdate();
			return true;
		}
		else {
			return false;
		}
	}
    //donne une note au offre.
	public boolean rate_this_offre(String id_offre_accepted,String rate,String id_students) throws SQLException {
		if(this.connect_to_database())
		{
			String count = "update offre_accepted set id_rate="+rate+" where id_offre_accepted="+id_offre_accepted+";";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			preparedStatement.executeUpdate();
			count = "select oa.id_offre_accepted,p.family_name,p.name,p.email,o.prix,m.matiere,oa.date,oa.start,oa.finish\r\n"
					+ "from offre_accepted oa,profs p,matiere m,offre o\r\n"
					+ "where oa.id_offre=o.id_offre\r\n"
					+ "and o.id_profs=p.id_profs\r\n"
					+ "and m.id_matiere=o.id_matiere\r\n"
					+ "and oa.id_students="+id_students+"\r\n"
					+ "and oa.date <date(now())\r\n"
					+ "and oa.status=1 \r\n"
					+ "and oa.id_rate is null\r\n"
					+ "order by oa.date;";
		    preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.all_offres_that_i_passed.clear();
			while(result.next())
			{
				offre_accepted_complete_a_afficher o=new offre_accepted_complete_a_afficher(); 
				o.setId_offre_accepted(result.getInt("id_offre_accepted"));
				o.setFamily_name(result.getString("family_name"));
				o.setName(result.getString("name"));
				o.setEmail(result.getString("email"));
				o.setPrix(result.getDouble("prix"));
				o.setMatiere(result.getString("matiere"));
				o.setDate(result.getString("date"));
				o.setStart(result.getString("start"));
				o.setFinish(result.getString("finish"));
				tables.all_offres_that_i_passed.add(o);		
			}
			return true;
		}
		else {
			return false;
		}
		
	}
	//calculer la moyenne de chaque offre.
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
	//afficher tout les notification d'un etudiant specifie avec son id
	public boolean get_notification(int id_students) throws SQLException {
		if(this.connect_to_database()) {
			String count = "select oa.id_offre_accepted,p.img,p.name,p.family_name,o.prix,oa.date,m.matiere\r\n"
					+ "from profs p,offre_accepted oa,offre o,matiere m,students s\r\n"
					+ "where p.id_profs=o.id_profs\r\n"
					+ "and o.id_offre=oa.id_offre\r\n"
					+ "and m.id_matiere=o.id_matiere\r\n"
					+ "and s.id_students=oa.id_students\r\n"
					+ "and oa.status=1\r\n"
					+ "and oa.id_rate is null\r\n"
					+ "and oa.status=0 and (oa.date >date(now()) or ( oa.date =date(now())  and  oa.finish >=time(now())  ))\r\n"
					+ "and s.id_students="+id_students+" order by oa.id_offre_accepted desc;";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			tables.notification.clear();
			while(result.next())
			{
				offre_accepted_complete_a_afficher n=new offre_accepted_complete_a_afficher(); 
				n.setId_offre_accepted(result.getInt("id_offre_accepted"));
				n.setFamily_name(result.getString("family_name"));
				n.setName(result.getString("name"));
				n.setPrix(result.getDouble("prix"));
				n.setMatiere(result.getString("matiere"));
				n.setDate(result.getString("date"));
				n.setImg(result.getString("img"));
				tables.notification.add(n);	
			}
		}
		else {
			
		}
		return false;
	}
	//changer les donners d'un champ dans la bd 
	public boolean edit_champ(int id_students,String champ,String val) throws SQLException {
		if(this.connect_to_database()) {
			String count = " update students set "+champ+"=\""+val+"\" where id_students="+id_students+";";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			preparedStatement.executeUpdate();
			return true;
			}
		else {
			return false;
		}
	}
	//changer les donnes d'un profile
	public boolean edit_profile(student student) throws Exception {
		if(!student.getEmail().isEmpty())
		{
			if(!this.is_it_one_email(student.getEmail())) {
				throw new Exception("this email is already used");
			}
			else {
				this.edit_champ(student.getId_students(),"email",student.getEmail());
				if(!student.getName().isEmpty()) {
					this.edit_champ(student.getId_students(),"name",student.getName());
				}
				if(!student.getBio().isEmpty())
				{
					this.edit_champ(student.getId_students(),"bio",student.getBio());
				}

				if(!student.getCity().isEmpty()) {
					this.edit_champ(student.getId_students(),"city",student.getCity());
				}
				if(!student.getFamily_name().isEmpty()) {
					this.edit_champ(student.getId_students(),"family_name",student.getFamily_name());
				}
				if(!student.getImg().isEmpty()&& !student.getImg().equals("../assets/img/img_offre/")) {
					this.edit_champ(student.getId_students(),"img",student.getImg());
				}
				if(!student.getPassword().isEmpty()) {
					this.edit_champ(student.getId_students(),"password",student.getPassword());
				}
			}
		}
		if(!student.getName().isEmpty()) {
			this.edit_champ(student.getId_students(),"name",student.getName());
		}
		if(!student.getBio().isEmpty())
		{
			this.edit_champ(student.getId_students(),"bio",student.getBio());
		}

		if(!student.getCity().isEmpty()) {
			this.edit_champ(student.getId_students(),"city",student.getCity());
		}
		if(!student.getFamily_name().isEmpty()) {
			this.edit_champ(student.getId_students(),"family_name",student.getFamily_name());
		}
		if(!student.getImg().isEmpty() && !student.getImg().equals("../assets/img/img_offre/")) {
			this.edit_champ(student.getId_students(),"img",student.getImg());
		}
		if(!student.getPassword().isEmpty()) {
			this.edit_champ(student.getId_students(),"password",student.getPassword());
		}

		return true;
		
	}
	//affichage de prof profile
	public prof show_me_prof_profile(String id_offre) throws Exception {
		if(this.connect_to_database()) {
			String count = "select p.name,p.family_name,p.img,p.bio,p.city,p.email \r\n"
					+ "from profs p,offre o \r\n"
					+ "where p.id_profs=o.id_profs \r\n"
					+ "and o.id_offre="+id_offre+";";
			PreparedStatement preparedStatement = con.prepareStatement(count);
			ResultSet result=preparedStatement.executeQuery();
			prof p=new prof();
			while(result.next())
			{
				p.setName(result.getString("name"));
				p.setFamily_name(result.getString("family_name"));
				p.setImg(result.getString("img"));
				p.setBio(result.getString("bio"));
				p.setCity(result.getString("city"));
				p.setEmail(result.getString("email"));
			}
			return p;
			
		}
		else {
			return null;
		}
	}
	
}




