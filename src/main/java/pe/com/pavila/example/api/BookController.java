package pe.com.pavila.example.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.pavila.example.dto.CreateBookCommand;
import pe.com.pavila.example.dto.CreateBookResult;
import pe.com.pavila.example.service.BookService;

@Controller
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<CreateBookResult> create(@RequestBody CreateBookCommand dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(dto));
    }

}
