package com.ada.teste.projetofinal.repositories;

import com.ada.teste.projetofinal.model.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRepositoryInMemorie extends R2dbcRepository<Book, Long> {
}
