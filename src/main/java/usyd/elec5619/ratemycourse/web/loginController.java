package usyd.elec5619.ratemycourse.web;


import javax.servlet.http.HttpServletRequest;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.ModelAttribute;
 
import org.springframework.web.bind.annotation.RequestMapping;
 
import org.springframework.web.bind.annotation.RequestMethod;
 
import org.springframework.web.servlet.ModelAndView;
 
//import usyd.elec5619.ratemycourse.domain.Login;

import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;
 
import usyd.elec5619.ratemycourse.services.UserService;
 
@Controller
public class loginController {

  @Autowired
  UserService userService;


  @RequestMapping(value = "/login", method = RequestMethod.GET)
 
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
 
    ModelAndView mav = new ModelAndView("searchBar");
 
    mav.addObject("loginForm", new Login());
 
    return mav;
 
  }
 
  @RequestMapping(value = "/login", method = RequestMethod.POST)
 
  public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {

    ModelAndView mav = null;

    User user1 = userService.validateUser(login);
    request.getSession().setAttribute("userID",user1.getId());

    if (user1 != null) {

      mav = new ModelAndView("searchBar");

      mav.addObject("name", user1.getUserName());

    } else {

      mav = new ModelAndView("loginForm");

      mav.addObject("message", "Username or Password is wrong!!");

      // }
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