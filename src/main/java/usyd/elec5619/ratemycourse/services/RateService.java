package usyd.elec5619.ratemycourse.services;

import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;

public interface RateService {

    Rate findbyId(int id);


    List<Rate> findAll();

    List<Rate> findAllByCourseId(String id);
    List<Rate> findAllByUserId(String userName);
    void saveOrUpdate(Rate rate);

    void delete(int id);
}
