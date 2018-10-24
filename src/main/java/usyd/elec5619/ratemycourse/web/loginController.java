package usyd.elec5619.ratemycourse.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class loginController {
 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(
	@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
            return "loginFailure";
        }
        return "loginSuccess";
	}
}