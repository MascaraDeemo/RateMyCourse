//package usyd.elec5619.ratemycourse.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.ValidationUtils;
//import org.springframework.validation.Validator;
//import usyd.elec5619.ratemycourse.domain.Rate;
//import usyd.elec5619.ratemycourse.services.RateService;
//
//@Component
//public class RateFormValidator implements Validator {
//
//    @Autowired
//    RateService rateService;
//
//
//
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return Rate.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Rate rate = (Rate) target;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"rating","NotEmpty.rateForm.rating");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"difficulty","NotEmpty.rateForm.difficulty");
////        if(rate.getTags()== null || rate.getTags().size() <3){
////            errors.rejectValue("skill", "Valid.rateForm.tags");
////        }
//
//    }
//}
