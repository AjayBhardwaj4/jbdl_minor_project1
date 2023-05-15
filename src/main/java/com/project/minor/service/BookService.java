package com.project.minor.service;

import com.project.minor.model.Author;
import com.project.minor.model.Book;
import com.project.minor.model.Request.BookCreateRequest;
import com.project.minor.repository.AuthorRepository;
import com.project.minor.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public void create(BookCreateRequest bookCreateRequest) {
        Book book = bookCreateRequest.toBook();
        Author author = book.getAuthor();

        Author authorFromDB = authorRepository.findByEmail(author.getEmail());

        if(authorFromDB == null){
            authorFromDB = authorRepository.save(author);
        }

        book.setAuthor(authorFromDB);
        bookRepository.save(book);
    }
}
