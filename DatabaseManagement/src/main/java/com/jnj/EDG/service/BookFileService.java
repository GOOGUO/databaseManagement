package com.jnj.EDG.service;


import com.jnj.EDG.entity.BookF;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface BookFileService {
    Collection<BookF> findAllBooks() throws IOException, ClassNotFoundException;
    BookF findBookByid(String id) throws IOException, ClassNotFoundException;
    Collection<BookF> findBookByBookName(String bookName) throws IOException, ClassNotFoundException;
    Collection<BookF> findBookByauthor(String boauthor);
    Collection<BookF> findBookBypublisher(String publisher);
    BookF findBookByISBN(String bookISBN);
    BookF findBookByASIN(String bookASIN);
    Collection<BookF> findBookBycategory(String category);
    Collection<BookF> findBookByvendor(String bovendor);

    Collection<BookF> addBook(BookF Book) throws IOException, ClassNotFoundException;

    String deleteAllBooks() throws IOException;
    List<BookF> deleteBookByid(String id) throws IOException, ClassNotFoundException;

    List<BookF> updateBookWithBookName(String id, String bookName, String bookNameChanged) throws IOException, ClassNotFoundException;


}
