package net.cmderobertis.mvc.controllers;

import net.cmderobertis.mvc.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class MainController {
    @RequestMapping("/")
    String index(Model model) {

        return "index.jsp";
    }
}
