package usyd.elec5619.ratemycourse.services;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

   CourseDAO courseDAO;

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Course> searchById(String searchText) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction=session.beginTransaction();
        transaction.begin();

        SQLQuery q = session.createSQLQuery("SELECT * FROM course " +
                "WHERE LOWER(courseID) LIKE :searchInput1" +
                " OR MATCH(courseName) AGAINST (:searchInput2)" +
                "OR MATCH(courseDescrip) AGAINST (:searchInput2)");
        q.setParameter("searchInput1","%"+searchText.toLowerCase()+"%");
        q.setParameter("searchInput2","'"+searchText.toLowerCase()+"*'");

        List<Course> searchResult = q.setResultTransformer(Transformers.aliasToBean(Course.class)).list();

        return searchResult;
    }

    @Override
    public List<Course> searchByPhrase(String searchText){

        String input = searchText;

        System.out.print(input);
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction=session.beginTransaction();
        transaction.begin();

        SQLQuery q = session.createSQLQuery
                ("SELECT * FROM course " +
                        "WHERE MATCH(courseName,courseDescrip) AGAINST (:searchInput IN BOOLEAN MODE)");
        q.setParameter("searchInput","'\""+input+"\"'");
        List<Course> searchResult = q.setResultTransformer(Transformers.aliasToBean(Course.class)).list();

        return searchResult;
    }
}
