package com.ncmn.school.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class MainController {

    @RequestMapping("/join")
    public String index() {
        return "/join";
    }

}
