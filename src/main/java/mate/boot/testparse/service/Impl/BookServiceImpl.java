package mate.boot.testparse.service.Impl;

import mate.boot.testparse.entity.Book;
import mate.boot.testparse.repository.BookRepository;
import mate.boot.testparse.service.BookService;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book " +
                "not found with id " + id));
    }

    @Override
    public Book update(Long id, Book book) {
        Optional<Book> byId = bookRepository.findById(id);
        if (byId.isPresent()) {
            Book foundedBook = new Book();
            foundedBook.setPrice(book.getPrice());
            foundedBook.setDescription(book.getDescription());
            foundedBook.setTitle(book.getTitle());
            return bookRepository.save(foundedBook);
        } else {
            return bookRepository.save(book);
        }
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
