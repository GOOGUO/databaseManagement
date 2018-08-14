package com.jnj.EDG.service;


import com.jnj.EDG.entity.Book;

import com.jnj.EDG.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    //增加书籍的方法
    public String addBook(
            @RequestParam(value = "bookName", required = true) String bookName,
            @RequestParam(value = "author", required = true) String author,
            @RequestParam(value = "publisher", required = true) String publisher,
            @RequestParam(value = "ISBN", required = true) String ISBN,
            @RequestParam(value = "ASIN", required = true) String ASIN,
            @RequestParam(value = "Category", required = true) String Category,
            @RequestParam(value = "vendor", required = true) String vendor
    ) {
        Book book = new Book(bookName, author, publisher, ISBN, ASIN, Category, vendor);
        bookRepository.save(book);
        return book.toString();
    }

    //通过id删除书籍的方法
    @Override
    public void deleteById(String id) {
        bookRepository.findById(id);
    }

    @Override
    //删除所有的书籍
    public void deleteAllBook() {
        bookRepository.deleteAll();
    }

    //更新书籍的方法
    @Override
    public String updateBook(@RequestParam(value = "bookName", required = true) String bookName,
                           @RequestParam(value = "author", required = true) String author,
                           @RequestParam(value = "publisher", required = true) String publisher,
                           @RequestParam(value = "ISBN", required = true) String ISBN,
                           @RequestParam(value = "ASIN", required = true) String ASIN,
                           @RequestParam(value = "Category", required = true) String Category,
                           @RequestParam(value = "vendor", required = true) String vendor) {
        Book book = new Book(bookName, author, publisher, ISBN, ASIN, Category, vendor);
        bookRepository.saveAndFlush(book);
        return book.toString();

    }

    //查找所有书籍的方法
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    //通过bookName查找书籍的方法

   public List<Book> findByBookName(String bookName) {
       return bookRepository.findByBookName(bookName);
    }

    //通过id查找书籍
    public String findById(String id) {
        return bookRepository.findById(id).toString();
    }
}
