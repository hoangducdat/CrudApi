package org.aibles.teamjava.Crud.Controller;

import org.aibles.teamjava.Crud.Entity.Books;
import org.aibles.teamjava.Crud.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/crud/books")
public class BooksController {
    private static final Logger LOGGER = Logger.getLogger(BooksController.class.getName());

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Books> getAllBooks() {
        LOGGER.info("GET ALL BOOKS");
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Long id) {
        LOGGER.info("GET BOOK BY ID");
        return booksService.getBooksById(id);
    }

    @PostMapping
    public ResponseEntity<Books> createBooks(@RequestBody Books books) {
        LOGGER.info("CREATE BOOK");
        Books createBook = booksService.createBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBooks(@PathVariable Long id, @RequestBody Books bookDetails) {
        LOGGER.info("UPDATE BOOK");
        Books updateBook = booksService.updateBooks(id, bookDetails);
        return ResponseEntity.ok(updateBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Books> deleteBooks(@PathVariable Long id) {
        LOGGER.info("DELETE BOOK");
        booksService.deleteBooks(id);
        return ResponseEntity.noContent().build();
    }
}
