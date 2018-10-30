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
        List<Rate> allRated = rateService.findAllByCourseId(courseId);
        int NanDu = 0;
        int PingFen = 0;
        if(allRated.size()>0) {
            for (Rate i : allRated) {
                NanDu = NanDu + i.getDifficulty();
                PingFen = PingFen + i.getRating();
            }
            double AvgNandu = Math.round((NanDu / allRated.size()) * 10)/10;
            double AvgPingfen = Math.round((PingFen / allRated.size()) * 10)/10;

            model.addAttribute("averageDiff", AvgNandu);
            model.addAttribute("averageRate", AvgPingfen);
        }
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

        Rate rate = new Rate();

        int rating = Integer.parseInt(request.getParameter("rating"));
        int diff = Integer.parseInt(request.getParameter("difficulty"));
        rate.setRating(rating);
        rate.setDifficulty(diff);

        if(request.getParameter("grade").isEmpty()){
            rate.setGrade(null);
        }else{
            int grade = Integer.parseInt(request.getParameter("grade"));
            rate.setGrade(grade);
        }
        String spec = request.getParameter("spec");
        if(spec.isEmpty()){
            rate.setSpec(null);
        }else{
            rate.setSpec(spec);
        }
        Boolean ifCred = Boolean.parseBoolean(request.getParameter("ifCredit"));
        if(ifCred == null){
            rate.setIfCredit(null);
        }else{
            rate.setIfCredit(ifCred);
        }
        Boolean ifTextBook = Boolean.parseBoolean(request.getParameter("textbook"));
        if(ifTextBook == null){
            rate.setIfTextBook(null);
        }else{
            rate.setIfTextBook(ifTextBook);
        }
        String major = request.getParameter("major");
        if(major.isEmpty()){
            rate.setMajor(null);
        }else{
            rate.setMajor(major);
        }

        rate.setCourseID(courseId);
        String userId = (String)request.getSession().getAttribute("userID");
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
                int startIndex = res.indexOf("<li") - 1;
                if (startIndex < 0) {
                    res = "";
                } else {
                    res = res.substring(startIndex);
                }

                return res;
            }

        } catch (MalformedURLException e) {

        } catch (ProtocolException e) {

        } catch(IOException e) {

        }

        return res;
    }
}
