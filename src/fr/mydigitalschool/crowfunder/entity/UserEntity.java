package fr.mydigitalschool.crowfunder.entity;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="user")
public class UserEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public UserEntity() {
		
	}
	public UserEntity(String email,String password) {
		super();
		this.password = password;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return email;
	}
	public void setUsername(String username) {
		this.email = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
