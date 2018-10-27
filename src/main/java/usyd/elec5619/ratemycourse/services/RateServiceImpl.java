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
