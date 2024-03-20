package org.aibles.teamjava.Crud.ServiceImpl;

import org.aibles.teamjava.Crud.Entity.Books;
import org.aibles.teamjava.Crud.Repository.BookRepository;
import org.aibles.teamjava.Crud.Service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Books getBooksById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Books createBooks(Books books) {
        return bookRepository.save(books);
    }

    @Override
    public Books updateBooks(Long id, Books booksDetails) {
        return bookRepository.save(booksDetails);
    }

    @Override
    public void deleteBooks(Long id) {
        bookRepository.deleteById(id);

    }

}
