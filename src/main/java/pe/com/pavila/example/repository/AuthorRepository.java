package pe.com.pavila.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.pavila.example.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Boolean existsByName(String name);

}
