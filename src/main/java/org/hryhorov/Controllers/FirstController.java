package org.hryhorov.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
                          @RequestParam(value = "surname", required = false) String surname,
                          Model model) {

        //System.out.println("Hello " + name + " " + surname);
        model.addAttribute("message","Hello " + name + " " + surname);

        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false) int a,
                             @RequestParam(value = "b", required = false) int b,
                             @RequestParam(value = "action",required = false) String action,
                             Model model) {

        double result;

        switch (action) {
            case "multi":
                result = a * b;
                break;
            case "div":
                result = a / (double) b;
                break;
            case "sub":
                result = a - b;
                break;
            case "add":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result", result);

        return "first/calculator";
    }
}
