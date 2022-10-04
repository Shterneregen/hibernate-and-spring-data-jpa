package random.jpaspringdatajpa.dao;

import random.jpaspringdatajpa.domain.Book;

import java.util.List;

public interface BookDao {

    List<Book> findAllBooks(int pageSize, int offset);

    List<Book> findAllBooks();

    Book getById(Long id);

    Book findBookByTitle(String title);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);
}
