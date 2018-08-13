package com.jnj.EDG.service;

import com.jnj.EDG.entity.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookService {


    //增加书籍的方法
     public  String addBook(@RequestParam  String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor);

    //通id删除书籍的方法
    public void deleteById(String id);

    //删除所有书籍
    public void  deleteAllBook();

    //更新书籍的方法
    public String updateBook(@RequestParam  String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor);

    //查找所有书籍的方法
    public List<Book> findAll();

    //通过bookName查找书籍的方法
    public List<Book> findByBookName(String bookName);

    //通过id查找书籍
    public String findById(String id);

}
