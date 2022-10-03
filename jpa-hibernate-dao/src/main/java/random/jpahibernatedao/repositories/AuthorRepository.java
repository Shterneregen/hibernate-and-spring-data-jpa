package random.jpahibernatedao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpahibernatedao.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
