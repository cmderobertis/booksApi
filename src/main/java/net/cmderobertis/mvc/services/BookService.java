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

    public Book updateBook(Book book) {
        Book b = getOne(book.getId());
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setLanguage(book.getLanguage());
        b.setNumberOfPages(book.getNumberOfPages());
        return bookRepository.save(b);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
