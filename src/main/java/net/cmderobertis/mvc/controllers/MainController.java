package net.cmderobertis.mvc.controllers;

import net.cmderobertis.mvc.models.Book;
import net.cmderobertis.mvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    BookService bookService;

    @GetMapping("/")
    String index() {
        return "redirect:/books";
    }
    @GetMapping("/books")
    String books(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        System.out.println(books);
        return "books.jsp";
    }

    @GetMapping("/books/{id}")
    String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}
