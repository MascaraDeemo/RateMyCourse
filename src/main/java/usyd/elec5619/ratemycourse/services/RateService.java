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

<<<<<<< HEAD
import org.springframework.stereotype.Service;
import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;


public interface RateService {
    Rate findById(int id);

    List<Rate> findAllByCourseId(String id);

    List<Rate> findAll();

    void saveOrUpdate(Rate rate);

    void delete(int id);

=======
import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;
import java.util.StringTokenizer;

public interface RateService {

    Rate findbyId(int id);


    List<Rate> findAll();

    List<Rate> findAllByCourseId(String id);
    List<Rate> findAllByUserId(String userName);
    void saveOrUpdate(Rate rate);
    boolean isRated(String userID, String courseID);
    void delete(int id);
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
}
>>>>>>> 032049867a4c7135758af3f4e9ec7fcfc16999c8
