package org.hryhorov.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hi")
    public String helloPage() {
        return "first/hi";
    }

    @GetMapping("goodbye")
    public String goodBye() {
        return "first/goodbye";
    }
}
