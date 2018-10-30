package usyd.elec5619.ratemycourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Rate")
public class Rate {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;

	public Rate(){

	}
	public Rate(int rating){
		this.rating = rating;
	}

	@Column(name="RateCourse")
	@NotNull
    private int rating;
	
	@Column(name="Difficulty")
    private int difficulty;

	@Column(name="TakenForCredit")
	private Boolean ifCredit;

	@Column(name = "textBookUsage")
	private Boolean ifTextBook;

	@Column(name="Specification")
	private String spec;
	
	@Column(name="Grade")
	private Integer grade;
	
	@Column(name="Major")
	private String major;

	@Column(name="courseID")
	private String courseID;

	@Column(name="userID")
	private String userID;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> tags = new ArrayList<>();


	public Boolean getIfTextBook() {
		return ifTextBook;
	}

	public void setIfTextBook(Boolean ifTextBook) {
		this.ifTextBook = ifTextBook;
	}

	public Boolean isIfCredit() {
		return ifCredit;
	}

	public void setIfCredit(Boolean ifCredit) {
		this.ifCredit = ifCredit;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public boolean isNew() { return ((Integer)this.id == null);
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}


//    public String toString() {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("Description: " + description + ";");
//        buffer.append("Price: " + price);
//        return buffer.toString();
//    }
}
