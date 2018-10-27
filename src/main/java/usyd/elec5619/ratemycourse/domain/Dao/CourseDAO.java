package usyd.elec5619.ratemycourse.domain.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Course;

import java.util.List;

@Repository
@Transactional
public interface CourseDAO  extends CrudRepository<Course, String> {

    public List<Course> findAll();

    public Course findByCourseId(String courseId);

    public Course findByCourseName(String courseName);



}
