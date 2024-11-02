package pe.com.pavila.example.service;

import pe.com.pavila.example.dto.CreateAuthorCommand;
import pe.com.pavila.example.dto.CreateAuthorResult;
import pe.com.pavila.example.dto.GetAuthorResult;

public interface AuthorService {

    GetAuthorResult getAll();

    CreateAuthorResult create(CreateAuthorCommand command);

}
