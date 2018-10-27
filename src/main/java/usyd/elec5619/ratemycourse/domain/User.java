package usyd.elec5619.ratemycourse.domain;

import org.hibernate.search.annotations.*;

import javax.persistence.*;

@Entity
@Indexed
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "userEmail", nullable = false,length = 50)
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String userEmail;
	
	@Column(name = "userName", nullable = false, length = 50)
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String userName;
	
	@Column(name = "password", nullable = false, length = 100)
	String userPswd;
	
	@Column(name = "university", length = 50)
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String userUni;
	
	public int getId() {
		return this.id;
	}
	public String getUserEmail() {
		return this.userEmail;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getUserPswd() {
		return this.userPswd;
	}
	public String getUserUni() {
		return this.userUni;
	}
	public void setUserEmail(String email) {
		this.userEmail = email;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public void setUserPswd(String password) {
		this.userPswd = password;
	}
	public void setUserUni(String university) {
		this.userUni = university;
	}
}
