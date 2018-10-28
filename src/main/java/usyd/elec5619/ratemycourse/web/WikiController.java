package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.services.WikiService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WikiController {
    private WikiService wikiService;

    private static List<Wiki> allWikis = new ArrayList<Wiki>(0);

    @Autowired
    public void setWikiService(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping(value="/wiki/{courseId}")
    public String showWikiPage(Model model, @PathVariable("courseId") String courseId, HttpServletRequest request){
        this.initWikis();

        Wiki targetWiki = null;
        courseId = courseId.toUpperCase();
        for (int i = 0; i < allWikis.size(); i++) {
            Wiki wiki = allWikis.get(i);
            String wikiCourseId = wiki.getCourseId();
            if (wikiCourseId.equals(courseId)) {
                targetWiki = allWikis.get(i);
                break;
            }
        }

        List<String> history = (List<String>) request.getSession().getAttribute(targetWiki.getCourseId() + "-history");
        System.out.println("Request Session History in renderWiki method:");
        System.out.println(history);

        if (history != null) {
            System.out.println(history.size());
            targetWiki.setHistory(history);
        }

        model.addAttribute("wiki", targetWiki);
        return "wiki";
    }

    @PostMapping("/wiki/{id}")
    public RedirectView updateWiki(Model model, HttpServletRequest request,
                                   @ModelAttribute("Wiki") Wiki wiki, @PathVariable("id") int id) {
        List<String> history = (List<String>) request.getSession().getAttribute(wiki.getCourseId() + "-history");

        System.out.println("Request Session History in updateWiki method:");
        System.out.println(history);
        if (history != null)  {
            history.add(wiki.getContent());
            wiki.setHistory(history);
            request.getSession().setAttribute(wiki.getCourseId() + "-history", history);
            System.out.println(wiki.getHistory().size());
        } else {
            List<String> newHistory = new ArrayList<String>();
            newHistory.add(wiki.getContent());
            request.getSession().setAttribute(wiki.getCourseId() + "-history", newHistory);
        }


        wikiService.deleteById(id);
        wikiService.saveOrUpdate(wiki);

        for (int i = 0; i < allWikis.size(); i++) {
            Wiki tmp = allWikis.get(i);
            String wikiCourseId = tmp.getCourseId();
            if (wikiCourseId.equals(wiki.getCourseId())) {
                allWikis.remove(i);
                allWikis.add(wiki);
                break;
            }
        }

        wiki.setId(id);
        model.addAttribute("wiki", wiki);
        return new RedirectView("/wiki/" + wiki.getCourseId());
    }

    private void initWikis() {
        if (allWikis.size() == 0) {
            allWikis = wikiService.findAll();
        }
    }
}
