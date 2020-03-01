package mate.boot.testparse.controller;

import mate.boot.testparse.entity.Book;
import mate.boot.testparse.entity.dto.BookRequestDto;
import mate.boot.testparse.entity.dto.BookResponseDto;
import mate.boot.testparse.service.BookService;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookResponseDto add(@RequestBody @Valid BookRequestDto bookRequestDto) {
        Book book = entityFromRequestDto(bookRequestDto);
        return responseDtoFromEntity(bookService.add(book));
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        bookService.deleteById(id);
    }

    @GetMapping
    public List<BookResponseDto> getAll() {
        return bookService.findAll()
                .stream()
                .map(this::responseDtoFromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public BookResponseDto getById(@PathVariable Long id) {
        return responseDtoFromEntity(bookService.findById(id));
    }

    @PutMapping
    public BookResponseDto update(@RequestParam Long id,
                                  @RequestBody @Valid BookRequestDto bookRequestDto) {
        return responseDtoFromEntity(bookService.update(id, entityFromRequestDto(bookRequestDto)));
    }

    private BookResponseDto responseDtoFromEntity(Book book) {
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setDescription(book.getDescription());
        bookResponseDto.setPrice(book.getPrice());
        return bookResponseDto;
    }

    private Book entityFromRequestDto(BookRequestDto bookRequestDto) {
        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setDescription(bookRequestDto.getDescription());
        book.setPrice(bookRequestDto.getPrice());
        return book;
    }
}
