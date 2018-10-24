package usyd.elec5619.ratemycourse.web;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
import usyd.elec5619.ratemycourse.domain.DAO.CourseSearchDAO;

import java.util.List;

@Controller

public class searchResult {

    @Autowired
    private CourseSearchDAO courseSearchDAO;

    @RequestMapping("/search_action")
    public ModelAndView passResult(){

        ModelAndView modelAndView = new ModelAndView("/searchResult");
        return modelAndView;
    }
}
