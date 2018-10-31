<<<<<<< HEAD
//package usyd.elec5619.ratemycourse.services;
//
//import usyd.elec5619.ratemycourse.domain.Rate;
//
//import java.util.List;
//
//public interface RateService {
//    Rate findById(Integer id);
//
//    List<Rate> findAllByCourseId(String id);
//
//    List<Rate> findAll();
//
//    void saveOrUpdate(Rate rate);
//
//    void delete(int id);
//
//}
=======
package usyd.elec5619.ratemycourse.services;

import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;


public interface RateService {
    Rate findById(int id);

    List<Rate> findAllByCourseId(String id);

    List<Rate> findAll();

    void saveOrUpdate(Rate rate);

    void delete(int id);

}
>>>>>>> 032049867a4c7135758af3f4e9ec7fcfc16999c8
