package usyd.elec5619.ratemycourse.services;

import usyd.elec5619.ratemycourse.domain.Course;

import java.util.List;

public interface CourseService {
    List<Course> findCourseRankList();
    void addCourse(Course course);
    String findCourseNameByCourseID(String CourseID);
    Course setCourseName(Course course);
}
