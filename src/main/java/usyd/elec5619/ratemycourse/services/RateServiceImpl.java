<<<<<<< HEAD
<<<<<<< HEAD
//package usyd.elec5619.ratemycourse.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import usyd.elec5619.ratemycourse.domain.DAO.RateDAO;
//import usyd.elec5619.ratemycourse.domain.Rate;
//
//import java.util.List;
//
//@Service("RateService")
//public class RateServiceImpl implements RateService{
//    RateDAO rateDAO;
//
//    @Autowired
//    public void setRateDAO(RateDAO rateDAO){
//        this.rateDAO = rateDAO;
//    }
//
//    @Override
//    public Rate findById(Integer id){
//        return rateDAO.findById(id);
//    }
//
//    @Override
//    public List<Rate> findAllByCourseId(String id) {
//        return rateDAO.findAllByCourseID(id);
//    }
//
//    @Override
//    public List<Rate> findAll(){
//        return  rateDAO.findAll();
//    }
//
//    @Override
//    public void saveOrUpdate(Rate rate){
//        if (findById(rate.getRateId())==null) {
//            rateDAO.save(rate);
//        }
//        else {
//            rateDAO.update(rate);
//        }
//    }
//
//    @Override
//    public void delete(int id){
//        rateDAO.delete(id);
//    }
//
//}
=======
package usyd.elec5619.ratemycourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import usyd.elec5619.ratemycourse.domain.Dao.RateDAO;
=======
package usyd.elec5619.ratemycourse.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.DAO.RateDao;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;

<<<<<<< HEAD
@Service("RateService")
public class RateServiceImpl implements RateService{
    private RateDAO rateDAO;

    @Autowired
    public void setRateDAO(RateDAO rateDAO){
        this.rateDAO = rateDAO;
    }

    @Override
    public Rate findById(int id){
        return rateDAO.findById(id);
    }

    @Override
    public List<Rate> findAllByCourseId(String id) {
        return rateDAO.findAllByCourseID(id);
    }

    @Override
    public List<Rate> findAll(){
        return  rateDAO.findAll();
    }

    @Override
    public void saveOrUpdate(Rate rate){
        if (findById(rate.getRateId())==null) {
            rateDAO.save(rate);
        }
        else {
            rateDAO.update(rate);
        }
    }

    @Override
    public void delete(int id){
        rateDAO.delete(id);
    }

}
>>>>>>> 032049867a4c7135758af3f4e9ec7fcfc16999c8
=======


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
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
