package usyd.elec5619.ratemycourse.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Wiki")
public class Wiki {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private int id;

    @Column(name="Content")
    private String content;

    @Column(name="CourseId")
    private String CourseId;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> history = new ArrayList<String>();

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

    public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }
}
