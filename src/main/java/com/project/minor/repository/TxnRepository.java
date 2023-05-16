package com.project.minor.repository;

import com.project.minor.model.Book;
import com.project.minor.model.Student;
import com.project.minor.model.Transaction;
import com.project.minor.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TxnRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTopByBookAndStudentAndTransactionTypeOrderByTransactionDateDesc(Book book, Student student,
                                                                                          TransactionType transactionType);
}
