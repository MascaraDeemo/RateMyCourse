package usyd.elec5619.ratemycourse.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;


@Entity
@Indexed
@Table(name = "Course")
public class Course {
	@Id
	@Column(name = "courseId", nullable = false,length = 8)
	String courseId;
	
	@Column(name = "courseName", nullable = false, length = 100)
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String courseName;
	
	@Column(name = "courseDescrip")
	@Field(index = Index.YES,analyze = Analyze.YES,store = Store.NO)
	String courseDescrip;
	
	public String getCourseId() {
		return this.courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
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
}
