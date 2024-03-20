package org.aibles.teamjava.Crud.Controller;

import org.aibles.teamjava.Crud.Entity.Authors;

import org.aibles.teamjava.Crud.Service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/crud/author")
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;
    @GetMapping
    public List<Authors> getAllAuthors() {
        return authorsService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Authors> getAuthorById(@PathVariable Long id) {
        Optional<Authors> authors = authorsService.getAuthorById(id);
        if (authors.isPresent()) {
            return ResponseEntity.ok(authors.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public ResponseEntity<Authors> createAuthor(@RequestBody Authors newAuthor) {
        Authors createAuthor = authorsService.createAuthors(newAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Authors> updateAuthor(@PathVariable Long id , @RequestBody Authors authorDetails) {
        Authors authors= authorsService.updateAuthors(id, authorDetails);
        return ResponseEntity.ok(authors);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Authors> deleteAuthors(@PathVariable Long id) {
        authorsService.deleteAuthors(id);
        return ResponseEntity.noContent().build();
    }
}
