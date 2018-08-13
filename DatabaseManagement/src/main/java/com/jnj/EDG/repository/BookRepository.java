package com.jnj.EDG.repository;

import com.jnj.EDG.entity.Book;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BookRepository extends JpaRepository<Book,String> {

  List<Book> findByBookName(String bookName);





}
