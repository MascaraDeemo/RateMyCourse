package usyd.elec5619.ratemycourse.web;


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
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller

public class SearchResultController {

    private CourseDAO courseDao;

    @Autowired
    public void setCourseDao(CourseDAO courseDao){
        this.courseDao=courseDao;
    }

    @RequestMapping("/search_action")
    public String searchResult(HttpServletRequest request, Model model){

//        String key = request.getParameter("search");
//
//        List<Course> allCourse = courseDao.findAll();
//
//        System.out.println(allCourse.get(0));
//
//        ArrayList<Course> searchJieGuo = new ArrayList<>();
//
//        for (Course i:allCourse){
//            System.out.println(i.getCourseId());
//            if(i.getCourseId().contains(key) ||
//            i.getCourseName().contains(key) ||
//            i.getCourseDescrip().contains(key)){
//                searchJieGuo.add(i);
//            }
//        }
//
//        model.addAttribute("searchResult",searchJieGuo);
      return "result";
   }
}