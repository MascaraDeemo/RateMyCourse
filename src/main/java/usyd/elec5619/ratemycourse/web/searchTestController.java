package usyd.elec5619.ratemycourse.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class searchTestController {
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response) {

		return "searchBar";
	}


}
