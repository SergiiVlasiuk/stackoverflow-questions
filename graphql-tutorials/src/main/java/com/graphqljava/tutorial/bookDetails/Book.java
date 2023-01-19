package com.graphqljava.tutorial.bookDetails;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class Book {

    private String id;
    private String name;
    private int pageCount;
    private String authorId;
    private LocalDate productionDate;

    private static List<Book> books = Arrays.asList(
            Book.builder()
                    .id("book-1")
                    .name("Harry Potter and the Philosopher's Stone")
                    .pageCount(223)
                    .authorId("author-1")
                    .productionDate(LocalDate.of(2017, 1, 13))
                    .build(),
            Book.builder()
                    .id("book-2")
                    .name("Moby Dick")
                    .pageCount(635)
                    .authorId("author-2")
                    .productionDate(LocalDate.of(2016, 9, 23))
                    .build(),
            Book.builder()
                    .id("book-3")
                    .name("Interview with the vampire")
                    .pageCount(371)
                    .authorId("author-3")
                    .productionDate(LocalDate.of(2002, 05, 01))
                    .build()
    );

    public static Book getById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getAuthorId() {
        return authorId;
    }
}