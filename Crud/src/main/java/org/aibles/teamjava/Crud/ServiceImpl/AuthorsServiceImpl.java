package org.aibles.teamjava.Crud.ServiceImpl;

import org.aibles.teamjava.Crud.Entity.Authors;
import org.aibles.teamjava.Crud.Repository.AuthorsRepository;
import org.aibles.teamjava.Crud.Service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AuthorsServiceImpl implements AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;
    @Override
    public List<Authors> getAllAuthors() {
        return authorsRepository.findAll();
    }

    @Override
    public Authors getAuthorById(Long id) {
        return authorsRepository.findById(id).orElse(null);
    }

    @Override
    public Authors createAuthors(Authors author) {
        return authorsRepository.save(author);
    }

    @Override
    public Authors updateAuthors(Long id, Authors authorDetails) {
        return authorsRepository.save(authorDetails);
    }

    @Override
    public void deleteAuthors(Long id) {
        authorsRepository.deleteById(id);
    }

}
