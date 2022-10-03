package net.cmderobertis.mvc.controllers;

import net.cmderobertis.mvc.models.Book;
import net.cmderobertis.mvc.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService) {
        this.bookService = bookService;
    }
    @RequestMapping("/api/books")
    public List<Book> index() {
        return bookService.getAll();
    }

    @PostMapping("/api/books")
    public Book create(
            @RequestParam(value = "title") String title,
            @RequestParam(value = "description") String desc,
            @RequestParam(value = "language") String lang,
            @RequestParam(value = "pages") Integer numOfPages) {
        Book book = new Book(title, desc, lang, numOfPages);
        return bookService.createBook(book);
    }

    @RequestMapping("/api/books/{id}")
    public Book show(@PathVariable("id") Long id) {
        return bookService.getOne(id);
    }

    @PutMapping("/api/books/{id}")
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String desc,
            @RequestParam("language") String lang,
            @RequestParam("pages") Integer numOfPages) {
        return bookService.updateBook(id, title, desc, lang, numOfPages);
    }

    @DeleteMapping("/api/books/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}
