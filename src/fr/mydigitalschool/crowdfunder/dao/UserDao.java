package fr.mydigitalschool.crowdfunder.dao;



import fr.mydigitalschool.crowfunder.entity.UserEntity;

public class UserDao {
	 private String email;
	 private String mdp;
	 private String name;
	 private String lastname;
	 
	public UserDao(String email, String mdp, String name,String lastname) {
		super();
		this.email = email;
		this.mdp = mdp;
		this.name = name;
		this.lastname = lastname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	
}







