//package usyd.elec5619.ratemycourse.domain;
//
//import org.hibernate.search.annotations.Analyze;
//import org.hibernate.search.annotations.Field;
//import org.hibernate.search.annotations.Index;
//import org.hibernate.search.annotations.Store;
//import org.hibernate.validator.constraints.NotEmpty;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import java.io.Serializable;
//import java.util.List;
//
//
//@Entity
//@Table(name="Rate")
//public class Rate implements Serializable {
//
//	@Id
//	@GeneratedValue
//	@Column(name="Id")
//	private Integer rateId;
//
//	@Column(name="RateCourse")
//	@NotEmpty(message = "Please rate this course")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//    private int rating;
//
//	@Column(name="Difficulty")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//    private int difficulty;
//
//	@Column(name="TakenForCredit")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//	private boolean ifCredit;
//
//	@Column(name="TextBook")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//	private boolean textBook;
//
////	@Column(name = "tags")
////	private List<String> tags;
//
//	@Column(name="Specification")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//	private String spec;
//
//	@Column(name="Grade")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//	private int grade;
//
//	@Column(name="Major")
//	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
//	private String major;
//
//	@Column(name="CourseID")
//	@NotNull
//	private String courseID;
//
//	@Column(name = "userID")
//	@NotNull
//	private String userID;
//
//	public boolean isNew() {
//		return (this.rateId == null);
//	}
//
//	public String getUserID() {
//		return userID;
//	}
//
//	public void setUserID(String userID) {
//		this.userID = userID;
//	}
//
//	public int getRateId() {
//		return rateId;
//	}
//
//	public String getCourseID() {
//		return courseID;
//	}
//
//	public void setCourseID(String courseID) {
//		this.courseID = courseID;
//	}
//
//	public int getRating() {
//		return rating;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
//
//	public int getDifficulty() {
//		return difficulty;
//	}
//
//	public void setDifficulty(int difficulty) {
//		this.difficulty = difficulty;
//	}
//
//	public boolean isIfCredit() {
//		return ifCredit;
//	}
//
//	public void setIfCredit(boolean ifCredit) {
//		this.ifCredit = ifCredit;
//	}
//
//	public boolean isTextBook() {
//		return textBook;
//	}
//
//	public void setTextBook(boolean textBook) {
//		this.textBook = textBook;
//	}
//
//	public String getSpec() {
//		return spec;
//	}
//
//	public void setSpec(String spec) {
//		this.spec = spec;
//	}
//
//	public int getGrade() {
//		return grade;
//	}
//
//	public void setGrade(int grade) {
//		this.grade = grade;
//	}
//
//	public String getMajor() {
//		return major;
//	}
//
//	public void setMajor(String major) {
//		this.major = major;
//	}
//
//	public void setRateId(int rateId) {
//		this.rateId = rateId;
//	}
//
////	public List<String> getTags() {
////		return tags;
////	}
////
////	public void setTags(List<String> tags) {
////		this.tags = tags;
////	}
//}
package usyd.elec5619.ratemycourse.domain;

<<<<<<< HEAD
import org.hibernate.search.annotations.Analyze;
=======
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.search.annotations.Indexed;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Rate")
public class Rate {

	@Id
	@GeneratedValue
	@Column(name="Id")
<<<<<<< HEAD
	private int rateId;
=======
	private int id;

	public Rate(){

	}
	public Rate(int rating){
		this.rating = rating;
	}
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

	@Column(name="RateCourse")
	@NotNull
    private int rating;
	
	@Column(name="Difficulty")
    private int difficulty;

	@Column(name="TakenForCredit")
<<<<<<< HEAD
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private boolean ifCredit;
	
	@Column(name="TextBook")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private boolean textBook;

	@ElementCollection
	@Column(name = "tags")
	private List<String> tags;
=======
	private Boolean ifCredit;

	@Column(name = "textBookUsage")
	private Boolean ifTextBook;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

	@Column(name="Specification")
	private String spec;
	
	@Column(name="Grade")
	private Integer grade;
	
	@Column(name="Major")
	private String major;

<<<<<<< HEAD
	@Column(name="CourseID")
	@NotNull
	private String courseID;

	@Column(name = "userID")
	@NotNull
	private String userID;

	public boolean isNew() {
		return ((Integer)rateId == null);
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getRateId() {
		return rateId;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
=======
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
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
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
<<<<<<< HEAD
=======
	
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
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

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

<<<<<<< HEAD
	public void setRateId(int rateId) {
		this.rateId = rateId;
	}
=======
	public boolean isNew() { return ((Integer)this.id == null);
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
