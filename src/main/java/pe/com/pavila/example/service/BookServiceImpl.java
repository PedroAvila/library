package pe.com.pavila.example.service;

import org.springframework.stereotype.Service;

import pe.com.pavila.example.dto.CreateBookCommand;
import pe.com.pavila.example.dto.CreateBookResult;
import pe.com.pavila.example.entity.Book;
import pe.com.pavila.example.repository.AuthorRepository;
import pe.com.pavila.example.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public CreateBookResult create(CreateBookCommand command) {
        var book = new Book();
        boolean existsTitle = bookRepository.existsByTitle(command.title());
        if (existsTitle)
            throw new RuntimeException("Title exists");

        var author = authorRepository.findById(command.authorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));

        book.setTitle(command.title());
        book.setDescription(command.description());
        book.setAuthor(author);

        bookRepository.save(book);

        return new CreateBookResult(book.getId(), book.getTitle(), book.getDescription(), book.getAuthor().getId());
    }
}
