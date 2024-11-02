package pe.com.pavila.example.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.pavila.example.dto.CreateAuthorCommand;
import pe.com.pavila.example.dto.CreateAuthorResult;
import pe.com.pavila.example.dto.GetAuthorResult;
import pe.com.pavila.example.service.AuthorService;

@Controller
@RequestMapping("authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<GetAuthorResult> getAll() {
        return ResponseEntity.ok(authorService.getAll());
    }

    @PostMapping
    public ResponseEntity<CreateAuthorResult> create(@RequestBody CreateAuthorCommand dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.create(dto));
    }
}
