package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RateController {

    @RequestMapping(value = "/rate", method = RequestMethod.GET)
    public String rate(HttpServletRequest request, HttpServletResponse response){

        return "rate_course";
    }
    @RequestMapping(value = "/course",method = RequestMethod.GET)
    public String course(HttpServletRequest request, HttpServletResponse response){
        return "course";
    }

}
