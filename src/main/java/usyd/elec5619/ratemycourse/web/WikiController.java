package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.services.WikiService;

import java.util.List;

@Controller
public class WikiController {
    private WikiService wikiService;

    @Autowired
    public void setWikiService(WikiService wikiService) {
        this.wikiService = wikiService;
    }

    @GetMapping("/wiki")
    public String rateForm(Model model){
//        model.addAttribute("rate", new Wiki());
        List<Wiki> wikis = wikiService.findAll();
        System.out.println("Wiki size is : " + wikis.size());
        return "wiki";
    }

    @PostMapping("/wiki")
    public String updateWiki(Model model) {
        return "wiki";
    }
}
