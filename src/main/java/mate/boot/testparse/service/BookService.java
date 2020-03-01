package mate.boot.testparse.service;

import mate.boot.testparse.entity.Book;

import java.util.List;

public interface BookService {

    Book add(Book book);

    List<Book> findAll();

    Book findById(Long id);

    Book update(Long id, Book book);

    void deleteById(Long id);
}
