package org.aibles.teamjava.Crud.Controller;

import org.aibles.teamjava.Crud.Entity.Books;
import org.aibles.teamjava.Crud.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/crud/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public List<Books> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Books getBookById(@PathVariable Long id) {
        return booksService.getBooksById(id);
    }

    @PostMapping
    public ResponseEntity<Books> createBooks(@RequestBody Books books) {
        Books createBook = booksService.createBooks(books);
        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Books> updateBooks(@PathVariable Long id, @RequestBody Books bookDetails) {
        Books updateBook = booksService.updateBooks(id, bookDetails);
        return ResponseEntity.ok(updateBook);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Books> deleteBooks(@PathVariable Long id) {
        booksService.deleteBooks(id);
        return ResponseEntity.noContent().build();
    }
}
