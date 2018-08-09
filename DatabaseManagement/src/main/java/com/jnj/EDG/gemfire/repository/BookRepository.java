package com.jnj.EDG.repository;

import com.jnj.EDG.model.Book;
import org.springframework.data.gemfire.repository.Query;
import org.springframework.data.gemfire.repository.query.annotation.Trace;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface BookRepository extends CrudRepository<Book, String> {

//    @Trace
//    Collection<Book> findBookByISBN(String ISBN);

//    @Trace
//    Collection<Book> findBookByASIN(String ASIN);

    @Trace
    Collection<Book> findBookByAuthor(String author);

//    @Trace
//    Collection<Book> findBookByBookName(String bookName);

    @Trace
    Collection<Book> findBookByPublisher(String publisher);

    @Trace
    Collection<Book> findBookByBookNumber(int bookNumber);

    @Query("SELECT * FROM /Book")
    Collection<Book> findAllBooks();

    @Query("SELECT * FROM /Book b WHERE b.ISBN LIKE $1")
    Collection<Book> findBookByISBN(String ISBN);

    @Query("SELECT * FROM /Book b WHERE b.ASIN LIKE $1")
    Collection<Book> findBookByASIN(String ASIN);

    @Query("SELECT * FROM /Book b WHERE b.bookName LIKE $1")
    Collection<Book> findBookByBookName(String bookName);
//
//    @Query("SELECT * FROM /Book b WHERE b.author LIKE $1")
//    Collection<Book> findBooksByAuthorLike(String author);
//
//    @Query("SELECT * FROM /Book b WHERE b.bookname LIKE $1")
//    Collection<Book> findBooksByBookNameLike(String bookName);
//
//    @Query("SELECT * FROM /Book b WHERE b.publish LIKE $1")
//    Collection<Book> findBooksByPublisherLike(String publisher);


    //@Query("SELECT * FROM /Book p WHERE p.email LIKE $1")
    //Collection<Book> getBooksByEmailLike(String email);


}
