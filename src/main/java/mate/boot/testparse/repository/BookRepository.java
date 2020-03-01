package mate.boot.testparse.repository;

import mate.boot.testparse.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
