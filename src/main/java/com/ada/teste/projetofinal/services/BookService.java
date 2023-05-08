package com.ada.teste.projetofinal.services;

import com.ada.teste.projetofinal.model.Book;
import com.ada.teste.projetofinal.repositories.BookRepositoryInMemorie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepositoryInMemorie repository;

    public Mono<Book> save(Book book){
        return Mono.defer(() -> {
            return repository.save(book);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Book> findBookById(Long id){
        return Mono.defer(() -> {
            return repository.findById(id);
        }).subscribeOn(Schedulers.boundedElastic());
    }

    public Flux<Book> findAllBooks(){
        return Flux.defer(repository::findAll)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<Void> removeBook(Long id){
        return Mono.defer(() -> {
           return repository.deleteById(id);
        }).subscribeOn(Schedulers.boundedElastic());
    }


}
