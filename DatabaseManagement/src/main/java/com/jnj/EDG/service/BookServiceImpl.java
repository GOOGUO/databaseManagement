package com.jnj.EDG.service;
/*
Author;AlexLi
Description:bookService的实现类
 */
import com.jnj.EDG.entity.BookM;
import com.jnj.EDG.repository.BookRepository;
import com.jnj.EDG.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;


    //查找所有书籍的方法
    @Override
    public List<BookM> findAll()
    {
        return bookRepository.findAll();
    }
    //通过bookName查找书籍的方法

    public List<BookM> findByBookName(String bookName)
    {
        return bookRepository.findByBookName(bookName);
   }
    //保存书籍的方法
    @Override
    public void saveBook(BookM bookM)
    {
        bookRepository.save(bookM);
    }

   //通过id删除书籍的方法
    @Override
    public void deleteById(long id)
    {
        bookRepository.deleteById(id);
    }
    //更新书籍的方法
    @Override
    public void updateBook(BookM bookM) {

       bookRepository.saveAndFlush(bookM);

    }


}
