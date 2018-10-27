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

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller

public class SearchResultController {

//    @Autowired
//    private CourseSearchDAO courseSearchDAO;
    @Autowired
    private SessionFactory sessionFactory;
//    @RequestMapping(value = "/search_action",method = RequestMethod.GET)
//    public String searchResult(HttpServletRequest request, Model model){
//
//        String input = request.getParameter("search");
//        List<Course> searchResult = courseSearchDAO.searchCourseNameByKeyword(input);
//
//        model.addAttribute("searchResult",searchResult);
//
//        return "searchResult";
//    }

    @RequestMapping("/seach_action")
    public String searchResult(HttpServletRequest request, Model model){

        FullTextSession fts = Search.getFullTextSession(sessionFactory.getCurrentSession());
        QueryBuilder queryBuilder = fts.getSearchFactory().buildQueryBuilder().forEntity(Course.class).get();
        String keywords = request.getParameter("search");
        Query luceneQuery = queryBuilder.keyword().onFields("courseId","courseName","courseDescrip").matching(keywords).createQuery();
        FullTextQuery query = fts.createFullTextQuery(luceneQuery,Course.class);

        List<Course> searchJieGuo = query.getResultList();

        model.addAttribute("searchResult",searchJieGuo);
        return "searchResult";
    }
}
