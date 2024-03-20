package org.aibles.teamjava.Crud.Repository;

import org.aibles.teamjava.Crud.Entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Books,Long> {

}
