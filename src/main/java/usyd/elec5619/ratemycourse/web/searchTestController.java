package usyd.elec5619.ratemycourse.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class searchTestController {
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, HttpServletResponse response) {

		return "searchBar";
	}


}
