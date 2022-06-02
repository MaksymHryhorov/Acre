package org.hryhorov.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hi")
    public String helloPage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello " + name + " " + surname);

        return "first/hi";
    }

    @GetMapping("goodbye")
    public String goodBye(@RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "surname", required = false) String surname) {

        System.out.println("Hello " + name + " " + surname);

        return "first/goodbye";
    }
}
