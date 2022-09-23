package Tables;


import java.util.ArrayList;
import java.util.List;

import Beans.*;

public class tables {
	//student 3 offre afficher par boucle
		static public List<offre_complete_a_affiche>last_3_offres=new ArrayList<offre_complete_a_affiche>();
	//prof 3 plus populaire offre pour afficher par boucle
		static public List<offre_complete_a_affiche>pupilaire_3_offres=new ArrayList<offre_complete_a_affiche>();
	//afficher 3 profs par hasard
		static public List<prof>random_3_profs=new ArrayList<prof>();
	//afficher les donnees de nbr etudiant nbr profs nbr offre nbr offre accepte
		static public int[] count_tables=new int[4];
	//tout les offres de bd
		static public List<offre_complete_a_affiche>all_offres=new ArrayList<offre_complete_a_affiche>();
	// afficher tt les matieres de bd
		static public List<String>all_matiere=new ArrayList<String>();
	//tout les offres effectuer par prof
		static public List<offre>all_offre_prof=new ArrayList<offre>();
		static public List<offre_complete_a_affiche>all_offres_byID=new ArrayList<offre_complete_a_affiche>();	
	//tt les offres q'un etudiant a passer pour les donne une note.
		static public List<offre_accepted_complete_a_afficher>all_offres_that_i_passed=new ArrayList<offre_accepted_complete_a_afficher>();
	//les offre qu'un etudiant a chercher.
		static public List<offre_complete_a_affiche> search_student_list=new ArrayList<offre_complete_a_affiche>();
	//les notification
		static public List<offre_accepted_complete_a_afficher>notification=new ArrayList<offre_accepted_complete_a_afficher>();
	//id student de session
		static public int student_id;
	//id prof de session
		static public int prof_id;
		static public int edit_profile_result=1;
				/*static public int Accept_result=1;
				static public int refuse_result=1;
				static public int edit_offre=1;
				static public int Drop_offre=1;
				static public int Ajout_offre=1;*/
	//les offres pour acceter ou refuser par prof
		static public List<offres_received_by_prof_to_accept_or_refuse>prof_accept_or_refuse_list=new ArrayList<offres_received_by_prof_to_accept_or_refuse>();
	//tout les offres qu'un prof a accepter
		static public List<offres_received_by_prof_to_accept_or_refuse>prof_accept_list=new ArrayList<offres_received_by_prof_to_accept_or_refuse>();
	//les notification de profs
		static public List<offre_accepted_complete_a_afficher>notification_prof=new ArrayList<offre_accepted_complete_a_afficher>();
	//les offre (created) qu'un prof a chercher .
		static public List<offre_complete_a_affiche> search_prof_offre_created_list=new ArrayList<offre_complete_a_affiche>();
	//les offre (accepte_or_refuse) qu'un prof a chercher .
		static public List<offres_received_by_prof_to_accept_or_refuse> search_prof_offre_accept_or_refuse_list=new ArrayList<offres_received_by_prof_to_accept_or_refuse>();
	//les offre (accepted) qu'un prof a chercher .
		static public List<offres_received_by_prof_to_accept_or_refuse> search_prof_offre_accepted_list=new ArrayList<offres_received_by_prof_to_accept_or_refuse>();
}
