package com.jnj.EDG.repository;

import com.jnj.EDG.entity.BookM;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface BookRepository extends JpaRepository<BookM,Long> {

   List<BookM> findByBookName(String bookName);

   List<BookM> findById(long id);



}
