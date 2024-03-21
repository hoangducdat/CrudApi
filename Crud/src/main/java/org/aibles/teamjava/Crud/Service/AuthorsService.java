package org.aibles.teamjava.Crud.Service;

import org.aibles.teamjava.Crud.Entity.Authors;

import java.util.List;
import java.util.Optional;

public interface AuthorsService {
    List<Authors> getAllAuthors();
    Authors getAuthorById(Long id);
    Authors createAuthors(Authors author);
    Authors updateAuthors(Long id, Authors authorDetails);
    void deleteAuthors(Long id);
}
