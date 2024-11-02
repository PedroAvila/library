package pe.com.pavila.example.dto;

public record CreateBookCommand(String title, String description, Long authorId) {

}
