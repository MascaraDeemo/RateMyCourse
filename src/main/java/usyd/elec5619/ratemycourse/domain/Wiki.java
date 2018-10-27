package usyd.elec5619.ratemycourse.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Wiki")
public class Wiki {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private long id;

    @Column(name="CourseID")
    private String courseID;

    @Column(name="Content")
    private String content;

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
