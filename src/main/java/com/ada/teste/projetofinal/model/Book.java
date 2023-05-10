package com.ada.teste.projetofinal.model;

import com.ada.teste.projetofinal.validators.DateValidation;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class Book {

    @Id
    private Long isbn;
    private String title;
    public String bookSummary;
    public String resume;
    public Double price;
    private Integer pages;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime publicationDate;

    public Book(){

    }

    public Book(Long isbn, String title, String bookSummary, String resume, Double price, Integer pages, LocalDateTime publicationDate){
        this.isbn = isbn;
        this.title = title;
        this.bookSummary = bookSummary;
        this.resume = resume;
        this.price = price;
        this.pages = pages;
        this.publicationDate = publicationDate;
    }
}
