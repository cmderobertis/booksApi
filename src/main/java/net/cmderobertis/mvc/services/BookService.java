package net.cmderobertis.mvc.services;

import net.cmderobertis.mvc.models.Book;
import net.cmderobertis.mvc.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // returns all the books
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }

    // retrieves a book
    public Book getOne(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book updateBook(Long id, String title, String description, String language, Integer numOfPages) {
        Book b = getOne(id);
        b.setTitle(title);
        b.setDescription(description);
        b.setLanguage(language);
        b.setNumberOfPages(numOfPages);
        return bookRepository.save(b);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
