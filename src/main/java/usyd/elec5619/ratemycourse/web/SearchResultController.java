package usyd.elec5619.ratemycourse.web;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
import usyd.elec5619.ratemycourse.domain.DAO.CourseSearchDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller

public class SearchResultController {

    @Autowired
    private CourseSearchDAO courseSearchDAO;

    @RequestMapping(value = "/search_action",method = RequestMethod.GET)
    public String searchResult(HttpServletRequest request, Model model){

        String input = request.getParameter("search");
        List<Course> searchResult = courseSearchDAO.searchCourseNameByKeyword(input);

        model.addAttribute("searchResult",searchResult);

        return "searchResult";
    }
}
