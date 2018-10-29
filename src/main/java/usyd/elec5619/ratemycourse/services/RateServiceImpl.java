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
    public void saveOrUpdate(Rate rate) {
        Session currentSeesion = this.sessionFactory.getCurrentSession();
        Transaction transaction = currentSeesion.beginTransaction();
        currentSeesion.save(rate);
        transaction.commit();
    }

    @Override
    public void delete(int id) {

    }
}
