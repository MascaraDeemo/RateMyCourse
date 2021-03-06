package usyd.elec5619.ratemycourse.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
import java.util.List;

@Entity
@Table(name="Wiki")
public class Wiki {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private Integer id;

<<<<<<< HEAD
    @Column(name="CourseID")
    private String courseID;

    @Column(name="Content")
    private String content;
=======
    @Column(name="Content")
    private String content;

    @Column(name="CourseId")
    private String CourseId;

    @Column(name="CourseName")
    private String CourseName;

    @Column(name="Wiki_Id")
    private Integer Wiki_Id;

    @Column(name="Summary")
    private String summary;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
    private List<WikiHistory> history = new ArrayList<WikiHistory>();

    public Wiki() {

    }

    public Wiki(int id, String courseId, String content, List<WikiHistory> history) {
        this.id = id;
        this.content = content;
        this.history = history;
        this.CourseId = courseId;
    }
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

    public Integer getWiki_Id() {
        return Wiki_Id;
    }

    public void setWiki_Id(Integer wiki_Id) {
        Wiki_Id = wiki_Id;
    }

    public void addHistory(String content) {
        this.history.add(new WikiHistory(content, this.id));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourseId() {
        return CourseId;
    }

    public void setCourseId(String courseId) {
        this.CourseId = courseId;
    }

    public List<WikiHistory> getHistory() {
        return history;
    }

    public void setHistory(List<WikiHistory> history) {
        this.history = history;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
