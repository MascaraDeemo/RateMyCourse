package usyd.elec5619.ratemycourse.services;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.domain.WikiHistory;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Course> findCourseRankList() {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Transaction trans = currentSession.beginTransaction();
        trans.begin();

        // find course with top 20 rates
        List<Course> courses = currentSession.createSQLQuery("SELECT SUM(RateCourse) AS rate, CourseID FROM Rate GROUP BY CourseID ORDER BY rate")
                .setResultTransformer(Transformers.aliasToBean(Course.class)).list();

        currentSession.flush();
        trans.commit();
        return courses;
    }

    @Override
    public void addCourse(Course course) {
        Session currentSession = this.sessionFactory.getCurrentSession();
        Transaction trans = currentSession.beginTransaction();
        trans.begin();

        currentSession.save(course);
        currentSession.flush();
        trans.commit();
    }
}
