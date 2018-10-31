package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.services.CourseService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/course/rank", method = RequestMethod.GET)
    public String courseRank(Model model) {
        List<Course> courses = courseService.findCourseRankList();
        List<Course> newCourses = new ArrayList<Course>();

        for (int i = 0; i < courses.size(); i++) {
           newCourses.add(courseService.setCourseName(courses.get(i)));
        }

        model.addAttribute("courses", newCourses);
        return "course_rank";
    }

    @RequestMapping(value = "/course/addform", method = RequestMethod.GET)
    public String courseForm(Model model,  @ModelAttribute("Course") Course course) {

        return "create_course";
    }

    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    public RedirectView addCourse(Model model, @ModelAttribute("Course") Course course) {
        course.setRate(new BigDecimal(0));
        courseService.addCourse(course);
        return new RedirectView("/search");
    }

}
