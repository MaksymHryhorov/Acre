package org.hryhorov;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String sayA() {
        return "hello_world";
    }

    @GetMapping("hello/map")
    public String sayB() {
        return "goodbye_b";
    }

}
