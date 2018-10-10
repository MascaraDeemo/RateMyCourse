package usyd.elec5619.ratemycourse.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class RateCoursePage implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;
	
	@Column(name="RateCourse")
    private int rating;
	
	@Column(name="Difficulty")
    private int difficulty;
    
	@Column(name="TakenForCredit")
	private boolean ifCredit;
	
	@Column(name="TextBook")
	private boolean textBook;

	@Column(name="Specification")
	private String spec;
	
	@Column(name="Grade")
	private int grade;
	
	@Column(name="Major")
	private String major;
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
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


//    public String toString() {
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("Description: " + description + ";");
//        buffer.append("Price: " + price);
//        return buffer.toString();
//    }
}
