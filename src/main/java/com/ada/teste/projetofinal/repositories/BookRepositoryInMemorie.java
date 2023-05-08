package com.ada.teste.projetofinal.repositories;

import com.ada.teste.projetofinal.model.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface BookRepositoryInMemorie extends ReactiveCrudRepository<Book, Long> {
}
