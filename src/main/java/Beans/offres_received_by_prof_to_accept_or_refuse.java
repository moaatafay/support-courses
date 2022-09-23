package Beans;

public class offres_received_by_prof_to_accept_or_refuse {
	String email;
	String localisation;
	String matiere;
	double prix;
	String date;
	String start;
	String finish;
	String image;
	
	int id_offre_accepted;
	public int getId_offre_accepted() {
		return id_offre_accepted;
	}
	public void setId_offre_accepted(int id_offre_accepted) {
		this.id_offre_accepted = id_offre_accepted;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getFinish() {
		return finish;
	}
	public void setFinish(String finish) {
		this.finish = finish;
	}
	
}
