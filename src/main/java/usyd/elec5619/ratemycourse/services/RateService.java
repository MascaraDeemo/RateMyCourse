package usyd.elec5619.ratemycourse.services;

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
}
