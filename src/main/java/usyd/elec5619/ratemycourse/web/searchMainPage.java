package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
import usyd.elec5619.ratemycourse.domain.DAO.RateDao;
import usyd.elec5619.ratemycourse.domain.Rate;
import usyd.elec5619.ratemycourse.services.SearchServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Controller
public class searchMainPage {
    CourseDAO courseDAO;
    RateDao rateDao;
    @Autowired
    private SearchServiceImpl searchService;

    @Autowired
    public void setRateDao(RateDao rateDao){
        this.rateDao=rateDao;
    }

    @Autowired
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public String showSearchBar(HttpServletRequest request, Model model){

        System.out.println("Search Bar Rendering");
        String uID= (String) request.getSession().getAttribute("userID");
        System.out.print(uID);
        List<Rate> rateList = rateDao.findAllByUserID(uID);

        if(rateList !=null){
            model.addAttribute("userList",rateList);
        }
        return "searchBar";
    }

    @RequestMapping(value = "/sousuo", method = RequestMethod.GET)
    public String searchResult(HttpServletRequest request, Model model) {

        String key = request.getParameter("search");
        if(key.isEmpty()){
            return "searchBar";
        }else{
            if(key.contains(" ")) {
                System.out.println(key);
                List<Course> searchJieGuo = searchService.searchByPhrase(key);
                model.addAttribute("searchJieGuoresult", searchJieGuo);
                return "result";
            }else{
                List<Course> searchJieGuo = searchService.searchById(key);
                model.addAttribute("searchJieGuoresult", searchJieGuo);
                return "result";
            }
        }
    }
}
