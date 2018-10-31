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
import usyd.elec5619.ratemycourse.domain.Rate;
import usyd.elec5619.ratemycourse.services.RateService;
import usyd.elec5619.ratemycourse.validator.RateFormValidator;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("singleton")
public class RateController {

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
        return "rates";

    }

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


}
>>>>>>> 032049867a4c7135758af3f4e9ec7fcfc16999c8
