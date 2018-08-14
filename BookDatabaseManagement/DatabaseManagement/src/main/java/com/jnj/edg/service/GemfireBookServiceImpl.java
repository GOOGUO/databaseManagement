package com.jnj.edg.service;
/*
Author:chen shanshan
Description:BookService的实现类（gemfire）
 */

import com.jnj.edg.entity.Book;
import com.jnj.edg.exception.BookNotFoundException;
import com.jnj.edg.repository.BookGemfireRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Service("GemfireBookServiceImpl")

@Transactional

public class GemfireBookServiceImpl implements BookService {
    @Autowired
    private BookGemfireRepository bookRepository;

    final Logger log = Logger.getLogger(GemfireBookServiceImpl.class);

    public String addBook(@RequestParam(value = "bookName", required = true) String bookName,
                          @RequestParam(value = "author", required = true) String author,
                          @RequestParam(value = "publisher", required = true) String publisher,
                          @RequestParam(value = "ISBN", required = true) String ISBN,
                          @RequestParam(value = "ASIN", required = true) String ASIN,
                          @RequestParam(value = "category", required = true) String category,
                          @RequestParam(value = "vendor", required = true) String vendor) {
        Book book = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        if (book.getId() == null || book.getAuthor() == "" || book.getPublisher() == "" || book.getBookName() == "") {
           log.error("record param--" + "Id:" + book.getId() + ";bookName:" + book.getBookName() + ";author:" +
                   book.getAuthor() + ";publisher:" + book.getPublisher() + ";ISBN:" + book.getISBN() + ";ASIN:" +
                   book.getASIN() + ";category:" + book.getCategory() + ";vendor:" + book.getVendor());
            log.error("数据添加失败");
            throw new BookNotFoundException("add book error" + ISBN);
        } else {
            bookRepository.save(book);
            return "add book successful: \n" + book.toString();
        }
    }

    public void deleteById(@PathVariable String id) {

        bookRepository.deleteById(id);
    }

    public void deleteAllBook() {
        bookRepository.deleteAll();
    }

    public String updateBook(@RequestParam(value = "bookName", required = true) String bookName,
                             @RequestParam(value = "author", required = true) String author,
                             @RequestParam(value = "publisher", required = true) String publisher,
                             @RequestParam(value = "ISBN", required = true) String ISBN,
                             @RequestParam(value = "ASIN", required = true) String ASIN,
                             @RequestParam(value = "category", required = true) String category,
                             @RequestParam(value = "vendor", required = true) String vendor) {
        Book b = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        bookRepository.save(b);
        return "update book successful: \n" + b.toString();
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByBookName(@PathVariable String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    public String findById(@PathVariable String id) {
        return bookRepository.findBookById(id).toString();
    }

}
