package Beans;

public class offre_complete_a_affiche {
	int id_offre;
	String family_name;
	String name;
	String email;
	String infos;
	String matiere;
	double prix;
	String date;
	double moyenne;
	String img;
	String imageOffre;
	public String getImageOffre() {
		return imageOffre;
	}
	public void setImageOffre(String imageOffre) {
		this.imageOffre = imageOffre;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getId_offre() {
		return id_offre;
	}
	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getInfos() {
		return infos;
	}
	public void setInfos(String infos) {
		this.infos = infos;
	}
	public double getMoyenne() {
		return moyenne;
	}
	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

}
