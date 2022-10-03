package random.jpaspringdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaspringdatajpa.domain.Author;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}
