<<<<<<< HEAD
//package usyd.elec5619.ratemycourse.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import usyd.elec5619.ratemycourse.domain.Rate;
//import usyd.elec5619.ratemycourse.services.RateService;
//import usyd.elec5619.ratemycourse.validator.RateFormValidator;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class RateController {
//
//    private RateService rateService;
//
//    private String courseId;
//    @Autowired
//    RateFormValidator rateFormValidator;
//
//    @Autowired
//    public void setRateService(RateService rateService){
//        this.rateService = rateService;
//    }
//
//    //show all rates in a course
//    @RequestMapping(value = "/courseRate", method = RequestMethod.GET)
//    public String showAllRatesInCourse(Model model){
//        model.addAttribute("courseRate", rateService.findAllByCourseId(courseId));
//        return "rates";
//
//    }
//
//    //save or update rate
//    @RequestMapping(value = "/courseRate", method = RequestMethod.POST)
//    public String saveOrUpdateRate(@ModelAttribute("rateForm") @Validated Rate rate,
//                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes){
//        if(result.hasErrors()){
//            populateDefaultModel(model);
//            return "rate_course";
//        }else {
//            redirectAttributes.addFlashAttribute("css", "success");
//            if(rate.isNew()){
//                redirectAttributes.addFlashAttribute("msg", "Rate added successfully!");
//            }else {
//                redirectAttributes.addFlashAttribute("msg", "Rate updated successfully!");
//            }
//
//            rateService.saveOrUpdate(rate);
//
//            return "redirect:/rates/" + rate.getRateId();
//        }
//    }
//
//
//    private void populateDefaultModel(Model model) {
//
//        List<String> tagList = new ArrayList<String>();
//        tagList.add("Spring MVC");
//        tagList.add("Struts 2");
//        tagList.add("JSF 2");
//        tagList.add("GWT");
//        tagList.add("Play");
//        tagList.add("Apache Wicket");
//        model.addAttribute("tagList", tagList);
//
//
//    }
//}
=======
package usyd.elec5619.ratemycourse.web;

<<<<<<< HEAD
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import usyd.elec5619.ratemycourse.domain.DAO.CourseDAO;
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
import usyd.elec5619.ratemycourse.domain.Rate;
import usyd.elec5619.ratemycourse.services.RateService;
import usyd.elec5619.ratemycourse.validator.RateFormValidator;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
=======
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
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867

@Controller
@Scope("singleton")
public class RateController {

<<<<<<< HEAD
    private final Logger logger = LoggerFactory.getLogger(RateController.class);



    private RateService rateService;

    private String courseId;
    @Autowired
    RateFormValidator rateFormValidator;

    @Autowired
    public void setRateService(RateService rateService){
        this.rateService = rateService;
    }

    //show all rates in a course
    @RequestMapping(value = "/courseRate", method = RequestMethod.GET)
    public String showAllRatesInCourse(Model model){
        model.addAttribute("courseRate", rateService.findAllByCourseId(courseId));
=======
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
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
        return "rates";

    }

<<<<<<< HEAD
    //save or update rate
    @RequestMapping(value = "/courseRate", method = RequestMethod.POST)
    public String saveOrUpdateRate(@ModelAttribute("rateForm") @Validated Rate rate,
                                   BindingResult result, final RedirectAttributes redirectAttributes){
        if(result.hasErrors()){

            return "rate_course";
        }else {
            redirectAttributes.addFlashAttribute("css", "success");
            if(rate.isNew()){
                redirectAttributes.addFlashAttribute("msg", "Rate added successfully!");
            }else {
                redirectAttributes.addFlashAttribute("msg", "Rate updated successfully!");
            }

            rateService.saveOrUpdate(rate);

            return "redirect:/rates/" + rate.getRateId();
        }
    }


=======

    @RequestMapping(value = "/rate_course/{courseId}", method = RequestMethod.GET)
    public String getRateForm(@PathVariable String courseId,Model model) {

        model.addAttribute("courseId", courseId);
        return "rate_course";
    }


    @RequestMapping(value = "rates/{courseId}", method = RequestMethod.POST)
    public RedirectView rateSubmit(@PathVariable String courseId, HttpServletRequest request) {
        String userId = (String)request.getSession().getAttribute("userID");
        if(rateService.isRated(userId,courseId)){
            return new RedirectView(courseId);
        }else {
            Rate rate = new Rate();

            int rating = Integer.parseInt(request.getParameter("rating"));
            int diff = Integer.parseInt(request.getParameter("difficulty"));
            rate.setRating(rating);
            rate.setDifficulty(diff);

            if (request.getParameter("grade").isEmpty()) {
                rate.setGrade(null);
            } else {
                int grade = Integer.parseInt(request.getParameter("grade"));
                rate.setGrade(grade);
            }
            String spec = request.getParameter("spec");
            if (spec.isEmpty()) {
                rate.setSpec(null);
            } else {
                rate.setSpec(spec);
            }
            Boolean ifCred = Boolean.parseBoolean(request.getParameter("ifCredit"));
            if (ifCred == null) {
                rate.setIfCredit(null);
            } else {
                rate.setIfCredit(ifCred);
            }
            Boolean ifTextBook = Boolean.parseBoolean(request.getParameter("textbook"));
            if (ifTextBook == null) {
                rate.setIfTextBook(null);
            } else {
                rate.setIfTextBook(ifTextBook);
            }
            String major = request.getParameter("major");
            if (major.isEmpty()) {
                rate.setMajor(null);
            } else {
                rate.setMajor(major);
            }

            rate.setCourseID(courseId);

            rate.setUserID(userId);


            rateService.saveOrUpdate(rate);
            return new RedirectView(courseId);
        }
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
>>>>>>> f4706960995aa5cb3c9e98efbdb0d4bd07cf7867
}
>>>>>>> 032049867a4c7135758af3f4e9ec7fcfc16999c8
