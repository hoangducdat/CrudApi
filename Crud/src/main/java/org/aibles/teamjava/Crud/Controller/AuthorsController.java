package org.aibles.teamjava.Crud.Controller;

import org.aibles.teamjava.Crud.Entity.Authors;

import org.aibles.teamjava.Crud.Service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/crud/author")
public class AuthorsController {
    private static final Logger LOGGER = Logger.getLogger(AuthorsController.class.getName());
    @Autowired
    private AuthorsService authorsService;
    @GetMapping
    public List<Authors> getAllAuthors() {
        LOGGER.info("GET ALL AUTHORS");
        return authorsService.getAllAuthors();
    }
    @GetMapping("/{id}")
    public Authors getAuthorById(@PathVariable Long id) {
        LOGGER.info("GET AUTHOR BY ID");
       return authorsService.getAuthorById(id);
    }
    @PostMapping
    public ResponseEntity<Authors> createAuthor(@RequestBody Authors newAuthor) {
        LOGGER.info("CREATE AUTHOR");
        Authors createAuthor = authorsService.createAuthors(newAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAuthor);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Authors> updateAuthor(@PathVariable Long id , @RequestBody Authors authorDetails) {
        LOGGER.info("UPDATE AUTHOR");
        Authors authors= authorsService.updateAuthors(id, authorDetails);
        return ResponseEntity.ok(authors);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Authors> deleteAuthors(@PathVariable Long id) {
        LOGGER.info("DELETE AUTHOR");
        authorsService.deleteAuthors(id);
        return ResponseEntity.noContent().build();
    }
}
