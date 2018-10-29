package usyd.elec5619.ratemycourse.web;

import org.checkerframework.checker.units.qual.C;
import org.hibernate.Hibernate;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
import usyd.elec5619.ratemycourse.domain.DAO.RateDao;
import usyd.elec5619.ratemycourse.domain.Rate;

import org.apache.lucene.search.Query;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.services.RateService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RateController {

    private RateService rateService;

    String courseId = "COMP5318";

    @Autowired
    public void setRateService(RateService rateService){
        this.rateService = rateService;
    }

    @RequestMapping(value = "/{courseId}/rates",method = RequestMethod.GET)
    public String showAllRatesInCourse(@PathVariable String courseId, Model model){

        model.addAttribute("rates", rateService.findAllByCourseId(courseId));
        return "rates";

    }


    @RequestMapping(value = "/{courseId}/rate_course",method = RequestMethod.GET)
        public String getRateForm(@PathVariable String courseId)
        {
            return "rate_course";
        }



    @RequestMapping(value = "rate_course", method = RequestMethod.POST)
    public String rateSubmit(HttpServletRequest request) {
        int rating  = Integer.parseInt(request.getParameter("rating"));
        String spec = request.getParameter("spec");
        int diff = Integer.parseInt(request.getParameter("difficulty"));
        Boolean ifCred = Boolean.parseBoolean(request.getParameter("ifCredit"));
        Boolean ifTextBook = Boolean.parseBoolean(request.getParameter("textbook"));
        int grade = Integer.parseInt(request.getParameter("grade"));
        String major = request.getParameter("major");
        Rate rate = new Rate();
        rate.setRating(rating);
<<<<<<< HEAD
=======
        rate.setTags(new ArrayList<>(Arrays.asList(request.getParameterValues("tags"))));
>>>>>>> b67d19838a8195f59359f7bae06ea311d0cb9c9e
        rate.setDifficulty(diff);
        rate.setIfCredit(ifCred);
        rate.setGrade(grade);
        rate.setMajor(major);
        rate.setIfTextBook(ifTextBook);
        rate.setSpec(spec);




        rate.setCourseID(courseId);

        rate.setUserID("123");
        rateService.saveOrUpdate(rate);


        return "redirect:COMP5318/rates";
    }

<<<<<<< HEAD
    @Autowired
    private SessionFactory sessionFactory;

    CourseDAO courseDAO;

    @Autowired
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @RequestMapping(value = "/search_action", method = RequestMethod.GET)
    public String searchResult(HttpServletRequest request, Model model){


        String key = request.getParameter("search");

        List<Course> allCourse = courseDAO.findAll();

        List<Course> searchJieGuo = new ArrayList<Course>();

        for (Course i:allCourse){
            System.out.println(i.getCourseID());
            if(i.getCourseID().toLowerCase().contains(key.toLowerCase().trim()) ||
                    i.getCourseName().toLowerCase().contains(key.toLowerCase().trim())){
                searchJieGuo.add(i);
            }
            StringTokenizer st = new StringTokenizer(i.getCourseDescrip());
            while(st.hasMoreTokens()){
                if (st.nextToken() == key && !searchJieGuo.contains(i)){
                    searchJieGuo.add(i);
                }
            }
        }
//        List<Course> h = ((List<Course>) searchJieGuo);
        model.addAttribute("searchJieGuoresult",searchJieGuo);
        return "result";
    }



=======
>>>>>>> b67d19838a8195f59359f7bae06ea311d0cb9c9e
}
