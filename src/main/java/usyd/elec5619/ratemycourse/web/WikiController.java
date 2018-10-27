package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.services.WikiService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WikiController {
    private WikiService wikiService;

    private List<Wiki> allWikis = new ArrayList<Wiki>(0);

    @Autowired
    public void setWikiService(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping(value="/wiki/{courseId}")
    public String showWikiPage(Model model, @PathVariable("courseId") String courseId){
        this.initWikis();

        Wiki targetWiki = null;
        courseId = courseId.toUpperCase();
        for (int i = 0; i < this.allWikis.size(); i++) {
            Wiki wiki = allWikis.get(i);
            String wikiCourseId = wiki.getCourseId();
            if (wikiCourseId.equals(courseId)) {
                targetWiki = allWikis.get(i);
                System.out.println("heyheyyoyo");
                break;
            }
        }

        if (targetWiki != null) {
            model.addAttribute("courseTitle", targetWiki.getCourseId());
            model.addAttribute("wikiContent", targetWiki.getContent());
        }
        return "wiki";
    }

    @PostMapping("/wiki/{courseId}")
    public String updateWiki(Model model, @PathVariable("courseId") String courseId) {

        return "Update Status";
    }

    private void initWikis() {
        if (this.allWikis.size() == 0) {
            this.allWikis = wikiService.findAll();
        }
    }
}
