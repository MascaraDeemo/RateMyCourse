package usyd.elec5619.ratemycourse.domain;

import javax.persistence.*;

@Entity
@Table(name="Wiki_History")
public class WikiHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="content")
    private String content;

    @Column(name="Wiki_Id")
    private Integer Wiki_Id;

    @Column(name="history")
    private String history;

    @Column(name="summary")
    private String summary;

    public WikiHistory() {

    }

    public WikiHistory(String content, Integer wiki_Id) {
        this.content = content;
        this.Wiki_Id = wiki_Id;
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

    public int getWiki_Id() {
        return Wiki_Id;
    }

    public void setWiki_Id(int wiki_Id) {
        Wiki_Id = wiki_Id;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

