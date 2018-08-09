package com.jnj.EDG.repository;

import com.jnj.EDG.model.Book;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BookRepository extends CrudRepository<Book, String> {

    @Trace
    Collection<Book> findBookBybookName(String bookName);


    @Query("SELECT * FROM /Book")
    Collection<Book> findAllBooks();



    //@Query("SELECT * FROM /Book p WHERE p.email LIKE $1")
    //Collection<Book> getBooksByEmailLike(String email);


}
