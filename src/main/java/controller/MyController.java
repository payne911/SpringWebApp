package controller;

import model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {

    @RequestMapping("/add1")
    public ModelAndView add1(@RequestParam(value="email") String email,
            @RequestParam(value="firstName") String fn,
            @RequestParam(value="lastName") String ln) {

        System.out.println("adding @RequestParam: " + email + fn + ln);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("generic");
        mv.getModel().put("title", "Subscribed!");
        mv.getModel().put("msg", "Welcome! (via @RequestParam)");
        mv.getModel().put("person", new Person(email, fn, ln));

        return mv;
    }

    @RequestMapping("/add2")
    public ModelAndView add2(@ModelAttribute Person person) {

        System.out.println("adding @ModelAttribute: " + person.getEmail() + person.getFirstName() + person.getLastName());

        ModelAndView mv = new ModelAndView();
        mv.setViewName("generic");
        mv.getModel().put("title", "Subscribed!");
        mv.getModel().put("msg", "Welcome! (via @ModelAttribute)");
        mv.getModel().put("person", person);

        return mv;
    }

    @PostMapping("/remove")
    public ModelAndView remove(@RequestParam(value="email") String email) {

        System.out.println("removing: " + email);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("generic");
        mv.getModel().put("title", "Ciao!");
        mv.getModel().put("msg", "The following user has been removed: " + email);

        return mv;
    }

    @RequestMapping("/")
    public String home() {

        System.out.println("home");



        return "index";
    }
}
