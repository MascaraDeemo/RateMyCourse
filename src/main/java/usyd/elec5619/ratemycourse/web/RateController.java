package usyd.elec5619.ratemycourse.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
import usyd.elec5619.ratemycourse.domain.Rate;

import org.hibernate.SessionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import usyd.elec5619.ratemycourse.domain.Course;
import usyd.elec5619.ratemycourse.services.CourseService;
import usyd.elec5619.ratemycourse.services.RateService;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

@Controller
public class RateController {

    private RateService rateService;
    private CourseService courseService;
    private CourseDAO courseDAO;

    @Autowired
    public void setRateService(RateService rateService) {
        this.rateService = rateService;
    }

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    public void setCourseDAO(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @RequestMapping(value = "/rates/{courseId}", method = RequestMethod.GET)
    public String showAllRatesInCourse(@PathVariable String courseId, Model model) {
        String courseName = courseService.findCourseNameByCourseID(courseId);
        String html = this.extractTextBook(courseName);

        model.addAttribute("textbookHtml", html);
        String courseDescrip = courseDAO.findByCourseID(courseId).getCourseDescrip();
        model.addAttribute("descrip",courseDescrip);
        model.addAttribute("courseId",courseId);
        model.addAttribute("rates", rateService.findAllByCourseId(courseId));
        return "rates";
    }


    @RequestMapping(value = "/rate_course/{courseId}", method = RequestMethod.GET)
    public String getRateForm(@PathVariable String courseId,Model model) {

        model.addAttribute("courseId", courseId);
        return "rate_course";
    }


    @RequestMapping(value = "rates/{courseId}", method = RequestMethod.POST)
    public RedirectView rateSubmit(@PathVariable String courseId, HttpServletRequest request) {
        String userId = (String)request.getSession().getAttribute("userID");

        int rating = Integer.parseInt(request.getParameter("rating"));
        String spec = request.getParameter("spec");
        int diff = Integer.parseInt(request.getParameter("difficulty"));
        Boolean ifCred = Boolean.parseBoolean(request.getParameter("ifCredit"));
        Boolean ifTextBook = Boolean.parseBoolean(request.getParameter("textbook"));
        int grade = Integer.parseInt(request.getParameter("grade"));
        String major = request.getParameter("major");
        Rate rate = new Rate();
        rate.setRating(rating);
        rate.setDifficulty(diff);
        rate.setIfCredit(ifCred);
        rate.setGrade(grade);
        rate.setMajor(major);
        rate.setIfTextBook(ifTextBook);
        rate.setSpec(spec);
        rate.setCourseID(courseId);
        rate.setUserID(userId);


        rateService.saveOrUpdate(rate);
        return new RedirectView(courseId);
    }

    private String extractTextBook(String courseName) {
        String res = "";
        try {
            URL url = new URL("https://coop.resultspage.com/search?ts=rac&w=" + URLEncoder.encode(courseName, "UTF-8") +"&rt=rac&dv=o");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("application/type", "text/html");

            int responseCode = con.getResponseCode();
            System.out.println("GET Response Code :: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                res = response.toString();
                res = res.substring(res.indexOf("<li") - 1);
                return res;
            }

        } catch (MalformedURLException e) {

        } catch (ProtocolException e) {

        } catch(IOException e) {

        }

        return res;
    }
}
