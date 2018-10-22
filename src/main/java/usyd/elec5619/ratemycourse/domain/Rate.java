package usyd.elec5619.ratemycourse.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Store;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Rate")
public class Rate implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private long id;

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
	
	@ElementCollection
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private List<String> tags = new ArrayList<String>();

	@Column(name="Specification")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String spec;
	
	@Column(name="Grade")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private int grade;
	
	@Column(name="Major")
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
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
	
	public List<String> getTags(){
		return tags;
	}
	
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
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
