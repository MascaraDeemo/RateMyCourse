package usyd.elec5619.ratemycourse.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;
import usyd.elec5619.ratemycourse.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@Controller
 
public class loginController {
 
  @Autowired
 
  UserService userService;
 
  @RequestMapping(value = "/login", method = RequestMethod.GET)
 
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
 
    ModelAndView mav = new ModelAndView("login");
 
    mav.addObject("login", new Login());
 
    return mav;
 
  }
 
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
 
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
 
    ModelAndView mav = null;
 
    User user = userService.validateUser(login);
 
    if (null != user) {
 
    mav = new ModelAndView("welcome");
 
    mav.addObject("name", user.getUserName());
 
    } else {
 
    mav = new ModelAndView("login");
 
    mav.addObject("message", "Username or Password is wrong!!");
 
    }
 
    return mav;
 
  }
 
}
/*
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
*/