package usyd.elec5619.ratemycourse.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class searchTestController {
	
	@RequestMapping("/")
	public String search(HttpServletRequest request, HttpServletResponse response) {

		return "searchBar.jsp";
	}

}
