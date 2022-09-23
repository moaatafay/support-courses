package Beans;

public class offre {
	int id_offre;
	int id_profs;
	int id_matiere;
	double prix;
	String date;
	String infos;
	int id_rate;
	String image;
	String prof_name;
	public String getProf_name() {
		return prof_name;
	}
	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}
	public int getId_offre() {
		return id_offre;
	}
	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}
	public int getId_profs() {
		return id_profs;
	}
	public void setId_profs(int id_profs) {
		this.id_profs = id_profs;
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
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
	public int getId_rate() {
		return id_rate;
	}
	public void setId_rate(int id_rate) {
		this.id_rate = id_rate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

}
