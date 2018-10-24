package usyd.elec5619.ratemycourse.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="Wiki")
public class Wiki {
    @Id
    @GeneratedValue
    @Column(name="Id")
    private long id;

    @Column(name="content")
    private String content;

    @Column(name="edited_by")
//    @OneToMany(mappedBy="User")
    private ArrayList<User> users;

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
