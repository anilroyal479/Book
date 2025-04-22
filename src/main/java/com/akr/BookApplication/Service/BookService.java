package com.akr.BookApplication.Service;

import com.akr.BookApplication.Entity.Book;
import com.akr.BookApplication.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public Book addBook(Book book){
        return bookRepository.save(book);

    }
    public Book getBookByName(String name){
        return bookRepository.findBookByTitle(name);

    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> findById(Integer id) {
        return bookRepository.findById(id);
    }
}
