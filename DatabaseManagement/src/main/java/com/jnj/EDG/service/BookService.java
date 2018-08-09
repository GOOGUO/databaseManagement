package com.jnj.EDG.service;

import com.jnj.EDG.entity.BookM;

import java.util.List;

public interface BookService {
    //查找所有书籍的方法
    public List<BookM> findAll();

    //保存书籍的方法
    public void saveBook(BookM bookM);

    //删除书籍的方法
    public void deleteById(long id);

    //通过bookName查找书籍的方法
    public List<BookM> findByBookName(String bookName);

    //更新书籍的方法
    public void updateBook(BookM bookM);

}
