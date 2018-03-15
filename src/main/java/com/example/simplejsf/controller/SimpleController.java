package com.example.simplejsf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author pgutierrez
 */
@Controller
public class SimpleController {
    @RequestMapping("/")
    public String home() {
        return "index.jsf";
    }
}
