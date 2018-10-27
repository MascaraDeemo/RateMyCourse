package usyd.elec5619.ratemycourse.domain.DAO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Wiki;

import java.util.List;

@Repository
@Transactional
public interface WikiDAO extends CrudRepository<Wiki, String> {
    List<Wiki> findAll();

    Wiki findById(int id);

//    void update(Wiki );
//    Wiki findByCourseId(String courseId);
//    List<Wiki> findAllByCourseId(String CourseId);
}
