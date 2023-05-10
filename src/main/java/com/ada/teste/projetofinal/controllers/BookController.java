package com.ada.teste.projetofinal.controllers;

import com.ada.teste.projetofinal.model.Book;
import com.ada.teste.projetofinal.services.BookService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.Serializable;
import java.time.LocalDateTime;

@RestController
//@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "books")
public class BookController implements Serializable {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping(value = "all-books")
    public Flux<Book> findAll(){
        return Flux.defer(service::findAllBooks)
                .subscribeOn(Schedulers.parallel());
    }

    @GetMapping(value = "search/{id}")
    public Mono<Book> findById(@PathVariable Long id){
        return Mono.defer(() -> {
            return service.findBookById(id);
        }).subscribeOn(Schedulers.parallel());
    }

    @PostMapping(value = "save")
    public Mono<Book> saveBook(@RequestBody Book book){
        return Mono.defer(() -> {
            book.setPublicationDate(LocalDateTime.now());
            return service.save(book);
        }).subscribeOn(Schedulers.parallel());
    }

    @PostMapping(value = "remove/{id}")
    public Mono<Void> deleteBookById(@PathVariable Long id){
        return Mono.defer(() -> {
            return service.removeBook(id);
        }).subscribeOn(Schedulers.parallel());
    }
}
