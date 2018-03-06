package controller;

import domain.Enrolment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EnrolmentController {

    @RequestMapping(value="/enrolment", method= RequestMethod.GET)
    public String showForm(Model model){
        model.addAttribute("enrolment", new Enrolment());
        return "enrolment";
    }


    @RequestMapping(value="/addEnrolment", method= RequestMethod.POST)
    public String submitForm(@Validated @ModelAttribute("enrolment")Enrolment enrolment, BindingResult result, Model model){
        if(result.hasErrors()) {
            return "error";
        }
        model.addAttribute("name", enrolment.getName());
        model.addAttribute("contactNumber", enrolment.getContactNumber());
        model.addAttribute("id", enrolment.getId());

        return "enrolmentView";
    }

}
