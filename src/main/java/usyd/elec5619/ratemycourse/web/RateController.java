package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usyd.elec5619.ratemycourse.domain.Rate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RateController {

    @GetMapping("/rateCourse")
    public String rateForm(Model model){
        model.addAttribute("rate", new Rate());
        return "rate_course";

    }
    @PostMapping("/rateCourse")
    public String rateSubmit(@ModelAttribute Rate rate){

        return "rates";
    }

}
