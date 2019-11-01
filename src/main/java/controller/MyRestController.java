package controller;

import model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class MyRestController {

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
}
