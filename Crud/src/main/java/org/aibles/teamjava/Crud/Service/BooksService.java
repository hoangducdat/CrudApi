package org.aibles.teamjava.Crud.Service;

import org.aibles.teamjava.Crud.Entity.Books;

import java.util.List;

public interface BooksService {
    List<Books> getAllBooks();
    Books getBooksById(Long id);
    Books createBooks(Books books);
    Books updateBooks(Long id, Books booksDetails);
    void deleteBooks(Long id);


}
