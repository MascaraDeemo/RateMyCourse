package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usyd.elec5619.ratemycourse.domain.Wiki;

@Controller
public class WikiController {

    @GetMapping("/wiki")
    public String rateForm(Model model){
//        model.addAttribute("rate", new Wiki());
        return "wiki";
    }

    @PostMapping("/wiki")
    public String updateWiki(Model model) {
        return "wiki";
    }
}
