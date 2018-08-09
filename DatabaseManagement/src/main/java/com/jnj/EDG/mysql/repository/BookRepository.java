package com.jnj.maven.repository;

import com.jnj.maven.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BookRepository extends JpaRepository<Book,Long> {

   List<Book> findByBookName(String bookName);

   List<Book> findById(long id);



}
