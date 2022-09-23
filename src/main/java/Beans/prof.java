package Beans;

public class prof {
	private int id_profs;
	private String family_name;
	private String name;
	private String email;
	private String password;
	private String img;
	private String bio;
	private String city;
	private int nbr_offres;
	public int getNbr_offres() {
		return nbr_offres;
	}
	public void setNbr_offres(int nbr_offres) {
		this.nbr_offres = nbr_offres;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId_profs() {
		return id_profs;
	}
	public void setId_profs(int id_profs) {
		this.id_profs = id_profs;
	}
}
