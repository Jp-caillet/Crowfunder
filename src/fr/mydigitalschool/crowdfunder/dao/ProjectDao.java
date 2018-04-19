package fr.mydigitalschool.crowdfunder.dao;

public class ProjectDao {
	private String title ;
	private String describe;
	private int user_id;
	private String categorie;
	
	public ProjectDao(String title, String describe, String categorie) {
		this.title = title;
		this.describe = describe;
	}
	

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

}
