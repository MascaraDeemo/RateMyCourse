package usyd.elec5619.ratemycourse.domain.DAO;

import org.springframework.data.repository.CrudRepository;
import usyd.elec5619.ratemycourse.domain.Wiki;

public interface WikiDAO extends CrudRepository<Wiki, String> {
    Wiki findByCourseID(String CourseId);
}
