package Beans;

public class offre_accepted {
	int id_offre_accepted;
	int id_offre;
	int id_students;
	String date;
	String start;
	String finish;
	int status;
	int id_rate;
	String localisation;
	public int getId_offre_accepted() {
		return id_offre_accepted;
	}
	public void setId_offre_accepted(int id_offre_accepted) {
		this.id_offre_accepted = id_offre_accepted;
	}
	public int getId_offre() {
		return id_offre;
	}
	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}
	public int getId_students() {
		return id_students;
	}
	public void setId_students(int id_students) {
		this.id_students = id_students;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getId_rate() {
		return id_rate;
	}
	public void setId_rate(int id_rate) {
		this.id_rate = id_rate;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
}
