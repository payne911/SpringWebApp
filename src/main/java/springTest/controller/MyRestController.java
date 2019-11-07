package springTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import springTest.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springTest.service.PersonService;


@RestController
@RequestMapping("/rest")
public class MyRestController {

    @Autowired
    PersonService personService;

    // todo: @ExceptionHandler

    @GetMapping("/remove")
    public Person remove(@RequestParam(value="email") String email) {

        System.out.println("removing: " + email);

        return new Person(email, "bob", "fdiwj");
    }

    @GetMapping("/remove/{email}")
    public Person removeById(@PathVariable String email) {

        System.out.println("removing: " + email);

        return new Person(email, "bob", "fdiwj");
    }

    @RequestMapping("/add")
    public Person addByForm(@ModelAttribute("person") Person person) {
        System.out.println(person);
        return person;
    }
}
