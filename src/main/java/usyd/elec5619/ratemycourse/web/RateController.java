package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
import usyd.elec5619.ratemycourse.domain.Rate;

import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.services.RateService;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class RateController {

    private RateService rateService;

    @Autowired
    public void setRateService(RateService rateService) {
        this.rateService = rateService;
    }

    @RequestMapping(value = "/rates/{courseId}", method = RequestMethod.GET)
    public String showAllRatesInCourse(@PathVariable String courseId, Model model) {
        model.addAttribute("courseId",courseId);
        model.addAttribute("rates", rateService.findAllByCourseId(courseId));
        return "rates";

    }


    @RequestMapping(value = "/rate_course/{courseId}", method = RequestMethod.GET)
    public String getRateForm(@PathVariable String courseId,Model model) {
        model.addAttribute("courseId", courseId);
        return "rate_course";
    }


    @RequestMapping(value = "rates/{courseId}", method = RequestMethod.POST)
    public RedirectView rateSubmit(@PathVariable String courseId, HttpServletRequest request) {
        String userId = (String)request.getSession().getAttribute("userID");

        int rating = Integer.parseInt(request.getParameter("rating"));
        String spec = request.getParameter("spec");
        int diff = Integer.parseInt(request.getParameter("difficulty"));
        Boolean ifCred = Boolean.parseBoolean(request.getParameter("ifCredit"));
        Boolean ifTextBook = Boolean.parseBoolean(request.getParameter("textbook"));
        int grade = Integer.parseInt(request.getParameter("grade"));
        String major = request.getParameter("major");
        Rate rate = new Rate();
        rate.setRating(rating);
        rate.setDifficulty(diff);
        rate.setIfCredit(ifCred);
        rate.setGrade(grade);
        rate.setMajor(major);
        rate.setIfTextBook(ifTextBook);
        rate.setSpec(spec);
        rate.setCourseID(courseId);
        rate.setUserID(userId);
        rateService.saveOrUpdate(rate);
        return new RedirectView(courseId);
    }

    @Autowired
    private SessionFactory sessionFactory;

    CourseDAO courseDAO;

    @Autowired
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }
}
