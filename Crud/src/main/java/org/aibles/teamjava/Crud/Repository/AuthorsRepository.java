package org.aibles.teamjava.Crud.Repository;

import org.aibles.teamjava.Crud.Entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorsRepository extends JpaRepository<Authors, Long> {
}
