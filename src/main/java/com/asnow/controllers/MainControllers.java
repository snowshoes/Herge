package com.asnow.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Shaokun on 08/02/17.
 */
@Controller
public class MainControllers {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Proudly handcrafted by " +
                "<a href='https://github.com/snowshoes/Herge'>App Backend Team</a> :)";
    }
}
