package usyd.elec5619.ratemycourse.services;

import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;

public interface RateService {
    Rate findById(Integer id);

    List<Rate> findAllByCourseId(String id);

    List<Rate> findAll();

    void saveOrUpdate(Rate rate);

    void delete(int id);

}
