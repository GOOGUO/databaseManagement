package com.jnj.edg.repository;
/*
/*
Author;chen shanshan
 */

import com.jnj.edg.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookGemfireRepository extends JpaRepository<Book, String> {


    List<Book> findBookById(String id);


    List<Book> findByBookName(String bookName);
}
