package fr.mydigitalschool.crowdfunder.dao;

public class CategorieDao {
	private String label;

	public CategorieDao(String label) {
		super();
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	 
}
