package com.example.demo.bootstrap;

import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Lonf");
        Book book1 = new Book("dsffds", "1654165165416");
        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book1);

        Author eric2 = new Author("DFFERse", "Lonfewfewf");
        Book book2 = new Book("sefesf", "899464+64");
        eric2.getBooks().add(book2);
        book2.getAuthors().add(eric2);

        authorRepository.save(eric2);
        bookRepository.save(book2);

        System.out.println(bookRepository.count());

    }
}
