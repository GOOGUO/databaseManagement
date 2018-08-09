package com.jnj.maven.service;
/*
Author;AlexLi
Description:bookService的实现类
 */
import com.jnj.maven.entity.Book;
import com.jnj.maven.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;


    //查找所有书籍的方法
    @Override
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }
    //通过bookName查找书籍的方法

    public List<Book> findByBookName(String bookName)
    {
        return bookRepository.findByBookName(bookName);
   }
    //保存书籍的方法
    @Override
    public void saveBook(Book book)
    {
        bookRepository.save(book);
    }

   //通过id删除书籍的方法
    @Override
    public void deleteById(long id)
    {
        bookRepository.deleteById(id);
    }
    //更新书籍的方法
    @Override
    public void updateBook(Book book) {

       bookRepository.saveAndFlush(book);

    }


}
