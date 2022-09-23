package Tables;


import java.util.ArrayList;
import java.util.List;

import Beans.*;

public class tables_admin {
	static public List<offre_complete_a_affiche>last_3_offres=new ArrayList<offre_complete_a_affiche>();
	static public List<prof>random_3_profs=new ArrayList<prof>();
	static public int[] count_tables=new int[4];
	//Admin Get All Data
	static public List<student>all_students=new ArrayList<student>();
	static public List<offre>all_offres=new ArrayList<offre>();
	static public List<admin_offre_effectue>all_offres_effect=new ArrayList<admin_offre_effectue>();
	static public List<prof>all_profs=new ArrayList<prof>();
	//Admin Search
	static public List<student>search_student_list=new ArrayList<student>();
	static public List<offre>search_offre_list=new ArrayList<offre>();
	static public List<prof>search_prof_list=new ArrayList<prof>();
	static public List<admin_offre_effectue>search_offres_effect_list=new ArrayList<admin_offre_effectue>();

}
