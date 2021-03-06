package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.Wiki;
<<<<<<< HEAD
import usyd.elec5619.ratemycourse.services.WikiServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
=======
import usyd.elec5619.ratemycourse.services.CourseService;
import usyd.elec5619.ratemycourse.services.WikiService;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

@Controller
public class WikiController {
    private WikiService wikiService;
    @Autowired
    private CourseService courseService;

<<<<<<< HEAD
    @GetMapping("/wiki")
    public String rateForm(Model model){
//        wikiService = (WikiServiec) new WikiServiceImpl();
//        model.addAttribute("rate", new Wiki());
//        Wiki wiki = wikiServiceImpl.findWikiByCourseId("AERO3465");
//        System.out.println(wiki.getContent());
        return "wiki";
=======
    @Autowired
    public void setWikiService(WikiService wikiService) {
        this.wikiService = wikiService;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
    }

    @GetMapping(value="/wiki/{courseId}")
    public String showWikiPage(Model model, @PathVariable("courseId") String courseId){
        courseId = courseId.toUpperCase();
        Wiki wiki = wikiService.findWikiByCourseId(courseId);
        String courseName = courseService.findCourseNameByCourseID(courseId);
        wiki.setCourseName(courseName);

        model.addAttribute("wiki", wiki);
        return "wiki";
    }

    @PostMapping("/wiki/{id}")
    public RedirectView updateWiki(Model model, @ModelAttribute("Wiki") Wiki wiki, @PathVariable("id") int id) {

        wiki.setId(id);
        wikiService.saveOrUpdate(wiki);

        model.addAttribute("wiki",wiki);
        return new RedirectView("/wiki/" + wiki.getCourseId());
    }
}
