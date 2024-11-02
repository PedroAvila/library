package pe.com.pavila.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pe.com.pavila.example.dto.AuthorDto;
import pe.com.pavila.example.dto.BookDto;
import pe.com.pavila.example.dto.CreateAuthorCommand;
import pe.com.pavila.example.dto.CreateAuthorResult;
import pe.com.pavila.example.dto.GetAuthorResult;
import pe.com.pavila.example.entity.Author;
import pe.com.pavila.example.repository.AuthorRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public GetAuthorResult getAll() {
        List<AuthorDto> authorDTOs = authorRepository.findAll().stream()
                .map(author -> new AuthorDto(
                        author.getId(),
                        author.getName(),
                        author.getBooks().stream()
                                .map(book -> new BookDto(book.getId(), book.getTitle(), book.getDescription()))
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());

        return new GetAuthorResult(authorDTOs);
    }

    @Override
    public CreateAuthorResult create(CreateAuthorCommand command) {

        var author = new Author();
        boolean existsName = authorRepository.existsByName(command.name());
        if (existsName)
            throw new RuntimeException("Name exists");

        author.setName(command.name());

        authorRepository.save(author);

        return new CreateAuthorResult(author.getId(), author.getName());
    }
}
