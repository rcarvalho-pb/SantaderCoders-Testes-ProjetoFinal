package com.ada.teste.projetofinal.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
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
    public BigDecimal price;
    @Min(value = 100, message = "The minimum number of pages is 100")
    private Integer pages;

    private LocalDateTime publicationDate;

}
