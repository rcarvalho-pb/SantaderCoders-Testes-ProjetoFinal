package com.ada.teste.projetofinal.model;

import com.ada.teste.projetofinal.validators.DateValidation;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Book {

    @Id
    @NotBlank(message = "ISBN is mandatory")
    @NonNull
    private Long isbn;
    @NonNull
    private String title;
    @NonNull
    @Size(max = 500, message = "Must be less than 500 characters.")
    public String bookSummary;
    public String resume;
    @Min(value = 20, message = "The minimum value of a book is $ 20.00")
    public Double price;
    @Min(value = 100, message = "The minimum number of pages is 100")
    private Integer pages;
    @DateValidation
    @NotNull
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
