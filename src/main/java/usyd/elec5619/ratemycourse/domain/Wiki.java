package usyd.elec5619.ratemycourse.domain;

import javax.persistence.*;
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

    public int getId() {
        return id;
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
}
