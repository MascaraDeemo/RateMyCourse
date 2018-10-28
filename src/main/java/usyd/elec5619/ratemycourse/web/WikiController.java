package usyd.elec5619.ratemycourse.web;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.domain.WikiHistory;
import usyd.elec5619.ratemycourse.services.WikiService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WikiController {
    private WikiService wikiService;

    @Autowired
    public void setWikiService(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping(value="/wiki/{courseId}")
    public String showWikiPage(Model model, @PathVariable("courseId") String courseId, HttpServletRequest request){
        courseId = courseId.toUpperCase();
        Wiki wiki = wikiService.findWikiByCourseId(courseId);

        model.addAttribute("wiki", wiki);
        return "wiki";
    }

    @PostMapping("/wiki/{id}")
    public RedirectView updateWiki(Model model, HttpServletRequest request,
                                   @ModelAttribute("Wiki") Wiki wiki, @PathVariable("id") int id) {

        wiki.setId(id);
        wikiService.saveOrUpdate(wiki);

        model.addAttribute("wiki", wiki);
        return new RedirectView("/wiki/" + wiki.getCourseId());
    }
}
