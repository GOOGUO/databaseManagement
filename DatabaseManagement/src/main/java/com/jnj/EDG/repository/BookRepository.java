package com.jnj.EDG.repository;

import com.jnj.EDG.model.Book;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BookRepository extends CrudRepository<Book, Integer> {

    @Trace
    Collection<Book> findByName(String name);
    
    //@Query("SELECT * FROM /Book p WHERE p.email LIKE $1")
    //Collection<Book> getBooksByEmailLike(String email);


}
