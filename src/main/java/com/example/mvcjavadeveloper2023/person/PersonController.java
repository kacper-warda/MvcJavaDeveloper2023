package com.example.mvcjavadeveloper2023.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/test")
    public String test(Model model) {
        System.out.println("użytkownik wszedł w metodę test");
        Integer i = new Random().nextInt();
        model.addAttribute("random", i);
        return "person/test";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Person> users = new ArrayList<>();
        users.add(new Person(1, "kacper", "kacper@gmailc.om", true, new Date()));
        users.add(new Person(2, "pioter", "pioter@gmailc.om", true, new Date()));
        users.add(new Person(3, "karolina", "karoina@gmailc.om", true, new Date()));



        model.addAttribute("users", users);

        return "person/list";
    }

    @GetMapping("/details")
    public String details(Model model) {
        Person kacper = new Person(1, "kacper", "kacper@gmailc.om", true, new Date());
        model.addAttribute("user", kacper);
        return "person/details";
    }
}
