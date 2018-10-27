package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class searchResult {



    @RequestMapping("/search_action")
    public ModelAndView passResult(){

        ModelAndView modelAndView = new ModelAndView("/searchResult");
        return modelAndView;
    }
}
