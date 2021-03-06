package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import usyd.elec5619.ratemycourse.domain.User;
import usyd.elec5619.ratemycourse.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@Controller
 
public class registerController {
 
  @Autowired
 
  public UserService userService;
 
  @RequestMapping(value = "/register", method = RequestMethod.GET)
 
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {

    ModelAndView mav = new ModelAndView("register");

    mav.addObject("user", new User());
 
    return mav;
 
  }
 
  @RequestMapping(value = "/register", method = RequestMethod.POST)

  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("user") User user) {
    System.out.print(user.getUserEmail());
    userService.register(user);

  return new ModelAndView("loginForm");
  }
 
}