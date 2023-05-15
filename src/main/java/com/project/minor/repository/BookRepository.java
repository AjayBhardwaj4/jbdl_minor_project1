package com.project.minor.repository;

import com.project.minor.model.Book;
import com.project.minor.model.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByName(String name);

    List<Book> findByAuthor_Name(String authorName);

    List<Book> findByGenre(BookGenre genre);
}