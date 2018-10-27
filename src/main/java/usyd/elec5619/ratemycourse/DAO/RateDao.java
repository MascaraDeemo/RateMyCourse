package usyd.elec5619.ratemycourse.DAO;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import usyd.elec5619.ratemycourse.domain.Rate;

import javax.annotation.Resource;
import java.util.List;


@Repository(value = "RateDao")
public class RateDao {

    @Resource
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveRate(Rate rate){
        sessionFactory.getCurrentSession().save(rate);
    }
}
