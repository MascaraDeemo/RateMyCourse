package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller

public class SearchResultController {



    @RequestMapping(value = "/search_action",method = RequestMethod.GET)
    public String searchResult(HttpServletRequest request, Model model){

        String input = request.getParameter("search");
       // List<Course> searchResult = courseSearchDAO.searchCourseNameByKeyword(input);

       // model.addAttribute("searchResult",searchResult);

        return "searchResult";
    }
}
