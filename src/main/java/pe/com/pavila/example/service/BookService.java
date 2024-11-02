package pe.com.pavila.example.service;

import pe.com.pavila.example.dto.CreateBookCommand;
import pe.com.pavila.example.dto.CreateBookResult;

public interface BookService {

    CreateBookResult create(CreateBookCommand command);

}
