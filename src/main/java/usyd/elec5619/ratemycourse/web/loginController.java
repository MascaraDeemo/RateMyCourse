package usyd.elec5619.ratemycourse.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
=======

import org.springframework.ui.Model;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< HEAD
=======
 
//import usyd.elec5619.ratemycourse.domain.Login;

import org.springframework.web.servlet.view.RedirectView;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
import usyd.elec5619.ratemycourse.domain.Login;
import usyd.elec5619.ratemycourse.domain.User;
import usyd.elec5619.ratemycourse.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@Controller
public class loginController {

  @Autowired
  UserService userService;


//  @RequestMapping(value = "/login", method = RequestMethod.GET)
//
//  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
//
//    ModelAndView mav = new ModelAndView("loginForm");
//
//    mav.addObject("loginForm", new Login());
//
//    return mav;
//
//  }
 
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public RedirectView loginProcess(HttpServletRequest request, Model model,
                                   @ModelAttribute("login") Login login) {


    User user1 = userService.validateUser(login);
    if (!user1.getPassword().equals(login.getPassword())) {
      return new RedirectView("/?msg=password");
    }

    if (user1 != null) {
      request.getSession().setAttribute("userID",user1.getUserName());
    } else {
      System.out.println("DO SOMTHING ! LOGIN FAILED");
    }
    return new RedirectView("/search");
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