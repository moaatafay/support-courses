package Beans;

public class student {
	private int id_students;
	private String family_name;
	private String name;
	private String email;
	private String password;
	private String bio;
	private String img;
	private String city;
	private int offres_accepted;
	public int getOffres_accepted() {
		return offres_accepted;
	}
	public void setOffres_accepted(int offres_accepted) {
		this.offres_accepted = offres_accepted;
	}
	public int getId_students() {
		return id_students;
	}
	public void setId_students(int id_students) {
		this.id_students = id_students;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
}
