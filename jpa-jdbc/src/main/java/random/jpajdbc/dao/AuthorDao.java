package random.jpajdbc.dao;

import random.jpajdbc.domain.Author;

public interface AuthorDao {
    Author getById(Long id);

    Author findAuthorByName(String firstName, String lastName);
}
