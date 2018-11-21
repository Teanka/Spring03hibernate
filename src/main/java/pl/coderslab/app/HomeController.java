package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
@Controller
public class HomeController {

    @GetMapping("/")
    public String hello() {
        System.out.println("!!!!");
        return "hello";
    }

}
