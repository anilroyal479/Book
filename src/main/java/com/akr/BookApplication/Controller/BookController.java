package com.akr.BookApplication.Controller;

import com.akr.BookApplication.Entity.Book;
import com.akr.BookApplication.Exceptions.ProductNotFoundException;
import com.akr.BookApplication.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/v1")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
       Book savedBook = bookService.addBook(book);
       return ResponseEntity.ok(savedBook);
    //return ResponseEntity.ok(bookService.addBook(book));
    }
    @GetMapping("/getBookByName/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name){
        Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }

    @GetMapping("/getBookById/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id") Integer id){
        Book bookById = bookService.findById(id).
                orElseThrow(() -> new ProductNotFoundException("Prouduct Not Found:" + id));
        return ResponseEntity.ok(bookById);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
