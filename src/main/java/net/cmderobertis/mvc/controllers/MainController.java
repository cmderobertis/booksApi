package net.cmderobertis.mvc.controllers;

import net.cmderobertis.mvc.models.Book;
import net.cmderobertis.mvc.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
        return "books.jsp";
    }

    @GetMapping("/books/{id}")
    String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getOne(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }

    @GetMapping("/books/new")
    String createForm(@ModelAttribute("book") Book book) {
        return "create.jsp";
    }

    @PostMapping("/books")
    String create(
        @Valid
        @ModelAttribute("book") Book book,
        BindingResult result)
    {
        if (result.hasErrors()) {
            return "create.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
}
