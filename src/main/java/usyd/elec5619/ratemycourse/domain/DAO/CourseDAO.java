package usyd.elec5619.ratemycourse.domain.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import usyd.elec5619.ratemycourse.domain.Course;

import java.util.List;

@Repository
@Transactional
public interface CourseDAO  extends CrudRepository<Course, String> {

    List<Course> findAll();

//    Course findByCourseId(String courseId);
//
//    Course findByCourseName(String courseName);
//
//    List<Course> findAllByCourseId(String courseId);

//    List<Course> findAllByCourseIdAndCourseName(String courseId);
//    List<Course> findAllByCourseName(String courseName);



}
