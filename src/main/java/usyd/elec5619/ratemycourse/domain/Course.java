package usyd.elec5619.ratemycourse.domain;

import org.hibernate.search.annotations.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

<<<<<<< HEAD
=======
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import java.math.BigDecimal;

>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

@Entity
@Indexed
@Table(name = "Course")
public class Course {
	@Id
	@Column(name = "courseID", nullable = false,length = 8)
	String courseID;
	
	@Column(name = "courseName", nullable = false, length = 100)
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String courseName;
	
	@Column(name = "courseDescrip")
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String courseDescrip;

	@Column(name="coordinator")
    private String coordinator;

	private BigDecimal rate;

	public String getCourseID() {
		return this.courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return this.courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName=courseName;
	}
	public String getCourseDescrip() {
		return this.courseDescrip;
	}
	public void setCourseDescrip(String courseDescrip) {
		this.courseDescrip = courseDescrip;
	}

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }
}
