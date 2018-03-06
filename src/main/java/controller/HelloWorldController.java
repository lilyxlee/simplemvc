package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloWorldController {

    @RequestMapping("/h")
    public String handleHelloworld(Model model){
        model.addAttribute("message", "test");
        return "helloworld";
    }

}
