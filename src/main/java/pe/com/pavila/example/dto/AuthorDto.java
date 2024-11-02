package pe.com.pavila.example.dto;

import java.util.List;

public record AuthorDto(Long id, String name, List<BookDto> books) {

}
