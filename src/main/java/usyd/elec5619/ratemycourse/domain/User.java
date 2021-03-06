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
	String password;
	
	@Column(name = "university", length = 50)
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String university;
	
	public int getId() {
		return this.id;
	}
	public String getUserEmail() {
		return this.userEmail;
	}
	public String getUserName() {
		return this.userName;
	}
	public String getPassword() {
		return this.password;
	}
	public String getUniversity() {
		return this.university;
	}
	public void setUserEmail(String email) {
		this.userEmail = email;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
}
