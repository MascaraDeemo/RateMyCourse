package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usyd.elec5619.ratemycourse.domain.Wiki;
import usyd.elec5619.ratemycourse.services.WikiServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WikiController {

    @GetMapping("/wiki")
    public String rateForm(Model model){
//        wikiService = (WikiServiec) new WikiServiceImpl();
//        model.addAttribute("rate", new Wiki());
//        Wiki wiki = wikiServiceImpl.findWikiByCourseId("AERO3465");
//        System.out.println(wiki.getContent());
        return "wiki";
    }

    @PostMapping("/wiki")
    public String updateWiki(Model model) {
        return "wiki";
    }
}
