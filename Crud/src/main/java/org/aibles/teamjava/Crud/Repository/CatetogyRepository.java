package org.aibles.teamjava.Crud.Repository;

import org.aibles.teamjava.Crud.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatetogyRepository extends JpaRepository<Category, Long> {
}
