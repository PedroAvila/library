package pe.com.pavila.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.pavila.example.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Boolean existsByTitle(String title);
}
