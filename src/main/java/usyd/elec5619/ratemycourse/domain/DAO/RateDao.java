package usyd.elec5619.ratemycourse.domain.DAO;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Rate;

import javax.persistence.EmbeddedId;
import java.util.List;


@Transactional
@Repository
@Qualifier("RateDao")
public interface RateDao extends CrudRepository<Rate, Integer>{

    List<Rate> findAll();

    Rate findById(int id);

    List<Rate> findAllByCourseID(String courseID);

    List<Rate> findAllByUserID(String userName);
}
