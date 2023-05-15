package com.project.minor.service;

import com.project.minor.model.Author;
import com.project.minor.model.Book;
import com.project.minor.model.BookGenre;
import com.project.minor.model.request.BookCreateRequest;
import com.project.minor.model.request.BookFilterType;
import com.project.minor.repository.AuthorRepository;
import com.project.minor.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Book> find(BookFilterType bookFilterType, String value) {
        switch (bookFilterType) {
            case NAME:
                return bookRepository.findByName(value);
            case AUTHOR_NAME:
                return bookRepository.findByAuthor_Name(value);
            case GENRE:
                return bookRepository.findByGenre(BookGenre.valueOf(value));
            default:
                return new ArrayList<>();
        }
    }
}
