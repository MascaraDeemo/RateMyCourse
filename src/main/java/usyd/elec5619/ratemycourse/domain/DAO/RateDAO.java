package usyd.elec5619.ratemycourse.domain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Rate;

import java.util.List;

@Repository
@Transactional
public interface RateDAO  extends CrudRepository<Rate, String> {

    List<Rate> findAll();

    Rate findById(long id);

    List<Rate> findAllByCourseID(String courseID);

    void update(Rate rate);

    void delete(Integer id);



}
