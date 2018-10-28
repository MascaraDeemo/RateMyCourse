package usyd.elec5619.ratemycourse.services;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.DAO.WikiDAO;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.domain.WikiHistory;

import java.util.ArrayList;
import java.util.List;

@Service("WikiService")
public class WikiServiceImpl implements WikiService{
    @Autowired
    private WikiDAO wikiDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Wiki> findAll() {
        return wikiDAO.findAll();
    }

    @Override
    public Wiki findById(int id) {
        return wikiDAO.findById(id);
    }

    @Override
    public void deleteById(int id) {
        wikiDAO.deleteById(id);
    }

    @Override
    public Wiki findWikiByCourseId(String courseId) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Transaction trans = currentSession.beginTransaction();
        trans.begin();

        // Query Wiki Object
        SQLQuery query = currentSession.createSQLQuery("SELECT * FROM Wiki WHERE CourseID=:courseId");
        query.setParameter("courseId", courseId);
        Wiki wiki = (Wiki) query.setMaxResults(1).setResultTransformer(Transformers.aliasToBean(Wiki.class)).uniqueResult();

//         Query Wiki History Object
        List<WikiHistory> histories = (List<WikiHistory>) currentSession.createSQLQuery("SELECT * FROM Wiki_History Where Wiki_Id=:wikiId")
                .setResultTransformer(Transformers.aliasToBean(WikiHistory.class))
                .setParameter("wikiId", wiki.getId())
                .list();

        currentSession.flush();
        trans.commit();

        wiki.setHistory(castWikiHistory(histories));

        return wiki;
    }

    @Override
    public void saveOrUpdate(Wiki wiki) {
        System.out.println("Save or update method");
        System.out.println(wiki.getContent());
        System.out.println(wiki.getCourseId());
        System.out.println(wiki.getId());

        saveHistory(wiki);

        Session currentSession = this.sessionFactory.getCurrentSession();
        Transaction trans = currentSession.beginTransaction();
        currentSession.update(wiki);
        currentSession.flush();
        trans.commit();
    }

    private void saveHistory(Wiki wiki) {
        WikiHistory newHistory = new WikiHistory();

        newHistory.setHistory(wiki.getContent());
        newHistory.setContent(wiki.getContent());
        newHistory.setWiki_Id(wiki.getId());

        System.out.println("************************************");
        System.out.println(newHistory.getWiki_Id());
        System.out.println(newHistory.getContent());
        System.out.println(newHistory.getHistory());

        Session currentSession = this.sessionFactory.getCurrentSession();
        Transaction trans = currentSession.beginTransaction();
        currentSession.save(newHistory);
        currentSession.flush();
        trans.commit();
        System.out.println(trans.wasCommitted());
    }

    private List<WikiHistory> castWikiHistory(List<WikiHistory> histories) {
        final List<WikiHistory> list = new ArrayList<WikiHistory>();
        for(final Object o : histories) {
            list.add((WikiHistory) o);
        }

        return list;
    }
}
