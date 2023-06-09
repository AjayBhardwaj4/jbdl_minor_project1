package com.project.minor.controller;

import com.project.minor.model.Book;
import com.project.minor.model.request.BookCreateRequest;
import com.project.minor.model.request.BookFilterType;
import com.project.minor.model.response.BookSearchResponse;
import com.project.minor.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        bookService.create(bookCreateRequest);
    }

    @GetMapping("/books/search")
    public List<BookSearchResponse> findBooks(@RequestParam("filter") BookFilterType bookFilterType,
                                              @RequestParam("value")String value) {
        return bookService.find(bookFilterType, value)
                .stream()
                .map(Book::toBookSearchResponse)
                .collect(Collectors.toList());
    }

}
