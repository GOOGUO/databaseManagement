package com.jnj.edg.service;

import com.jnj.edg.entity.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

public interface BookService {


    //增加书籍的方法
     public  String addBook(@RequestParam  String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) throws IOException, ClassNotFoundException;

    //通id删除书籍的方法
    public void deleteById(String id) throws IOException, ClassNotFoundException;

    //删除所有书籍
    public void  deleteAllBook() throws IOException;

    //更新书籍的方法
    public String updateBook(@RequestParam  String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) throws IOException, ClassNotFoundException;

    //查找所有书籍的方法
    public List<Book> findAll() throws IOException, ClassNotFoundException;

    //通过bookName查找书籍的方法
    public List<Book> findByBookName(String bookName) throws IOException, ClassNotFoundException;

    //通过id查找书籍
    public String findById(String id) throws IOException, ClassNotFoundException;

}
