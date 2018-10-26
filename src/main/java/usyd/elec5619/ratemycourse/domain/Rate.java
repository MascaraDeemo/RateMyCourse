package usyd.elec5619.ratemycourse.domain;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name="Rate")
public class Rate implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long rateId;

	@Column(name="RateCourse")
	@NotEmpty(message = "Please rate this course")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private int rating;
	
	@Column(name="Difficulty")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private int difficulty;
    
	@Column(name="TakenForCredit")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private boolean ifCredit;
	
	@Column(name="TextBook")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private boolean textBook;

	@Column(name="Specification")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String spec;
	
	@Column(name="Grade")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private int grade;
	
	@Column(name="Major")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String major;

	@Column(name="CourseID")
	@NotNull
	private String courseID;

	@Column(name = "userID")
	@NotNull
	private String userID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public long getRateId() {
		return rateId;
	}

	public void setRateId(long rateId) {
		this.rateId = rateId;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String courseID) {
		this.courseID = courseID;
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

	public boolean isIfCredit() {
		return ifCredit;
	}

	public void setIfCredit(boolean ifCredit) {
		this.ifCredit = ifCredit;
	}

	public boolean isTextBook() {
		return textBook;
	}

	public void setTextBook(boolean textBook) {
		this.textBook = textBook;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}
