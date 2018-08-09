package com.jnj.maven.service;

import com.jnj.maven.entity.Book;

import java.util.List;

public interface BookService {
    //查找所有书籍的方法
    public List<Book> findAll();

    //保存书籍的方法
    public void saveBook(Book book);

    //删除书籍的方法
    public void deleteById(long id);

    //通过bookName查找书籍的方法
    public List<Book> findByBookName(String bookName);

    //更新书籍的方法
    public void updateBook(Book book);

}
