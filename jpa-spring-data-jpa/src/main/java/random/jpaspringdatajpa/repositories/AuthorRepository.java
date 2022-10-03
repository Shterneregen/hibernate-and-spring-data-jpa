package random.jpaspringdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaspringdatajpa.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
