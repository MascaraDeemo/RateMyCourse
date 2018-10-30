package usyd.elec5619.ratemycourse.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.DAO.RateDao;
import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;



@Service("rateService")
public class RateServiceImpl implements RateService {

    RateDao rateDao;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setRateDao(RateDao rateDao){
        this.rateDao = rateDao;
    }

    @Override
    public Rate findbyId(int id) {
        return rateDao.findById(id);
    }

    @Override
    public List<Rate> findAll() {
        return rateDao.findAll();
    }

    @Override
    public List<Rate> findAllByCourseId(String id) {
        return rateDao.findAllByCourseID(id);
    }
    @Override
    public List<Rate> findAllByUserId(String userName){
        return rateDao.findAllByUserID(userName);
    }
    @Override
    public void saveOrUpdate(Rate rate) {
        Session currentSeesion = this.sessionFactory.getCurrentSession();
        Transaction transaction = currentSeesion.beginTransaction();
        currentSeesion.save(rate);
        transaction.commit();
    }
    @Override
    public boolean isRated(String userName,String courseID){
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        List<Rate> lst = rateDao.findAllByCourseID(courseID);
        for(Rate i:lst){
            if(i.getUserID().equals(userName)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete(int id) {

    }
}
