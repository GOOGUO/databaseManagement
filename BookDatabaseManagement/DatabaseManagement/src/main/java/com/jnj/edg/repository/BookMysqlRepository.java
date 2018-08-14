package com.jnj.edg.repository;
/*
/*
Author;AlexLi
 */


import com.jnj.edg.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookMysqlRepository extends JpaRepository<Book, String> {

    List<Book> findByBookName(String bookName);

}
