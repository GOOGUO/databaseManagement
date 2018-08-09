/*
package com.jnj.EDG.controller;
*/
/*
Author;AlexLi
Description;BookController调用BookService，注意下这里的BookController使用@RestController注解来标注，另外URL路径命名按照RESTful风格来命名；


 *//*


import com.jnj.EDG.entity.BookM;
import com.jnj.EDG.repository.BookRepository;
import com.jnj.EDG.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "MySQL/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookRepository bookRepository;
    //添加书籍信息
    @RequestMapping(value = "/add",method=RequestMethod.GET)
            public String addBook(@RequestParam(value = "id", required = true) Long id,
                                   @RequestParam(value = "bookName", required = true) String bookName,
                                   @RequestParam(value = "author", required = true) String author,
                                   @RequestParam(value = "Publisher", required = true) String Publisher,
                                   @RequestParam(value = "ISBN", required = true) String ISBN,
                                   @RequestParam(value = "ASIN", required = true) String ASIN,
                                   @RequestParam(value = "Category", required = true) String Category,
                                   @RequestParam(value = "vendor", required = true) String vendor,
                                   @RequestParam(value = "borrowDate", required = true) String borrowDate,
                                   @RequestParam(value = "backDate", required = true) String backDate,
                                   @RequestParam(value = "borrowNumber", required = true) String borrowNumber){

        BookM bookM = new BookM(id,bookName,author,Publisher,ISBN,ASIN,Category,vendor,borrowDate,backDate,borrowNumber);
        bookService.saveBook(bookM);
        return bookM.toString();
    }
    //根据id更新书籍信息
    @RequestMapping(value = "/update/id",method=RequestMethod.GET)
    public String updateBook(@RequestParam(value = "id", required = true) Long id,
                              @RequestParam(value = "bookName", required = true) String bookName,
                              @RequestParam(value = "author", required = true) String author,
                              @RequestParam(value = "Publisher", required = true) String Publisher,
                              @RequestParam(value = "ISBN", required = true) String ISBN,
                              @RequestParam(value = "ASIN", required = true) String ASIN,
                              @RequestParam(value = "Category", required = true) String Category,
                              @RequestParam(value = "vendor", required = true) String vendor,
                              @RequestParam(value = "borrowDate", required = true) String borrowDate,
                              @RequestParam(value = "backDate", required = true) String backDate,
                              @RequestParam(value = "borrowNumber", required = true) String borrowNumber){

        BookM bookM = new BookM(id,bookName,author,Publisher,ISBN,ASIN,Category,vendor,borrowDate,backDate,borrowNumber);
        bookService.updateBook(bookM);
        return "更新成功";
    }


    //通过id删除书籍信息
    @RequestMapping(value = "/delete/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteById(id);
        return "第"+id+"条书籍信息已删除";
    }
    //批量删除书籍信息
    @RequestMapping(value = "/deleteAll")
    public String deleteAllBook() {
        bookRepository.deleteAll();
        return "所有书籍信息已删除";
    }

    //查询全部书籍信息
    @RequestMapping(value = "/")
    public List<BookM> getBooks() {
        return bookService.findAll();
    }
    //通过id查询书籍信息
    @RequestMapping(value = "/search/id/{id}")
    public List<BookM> getBookById(@PathVariable long id) {
        List<BookM> book1 = bookRepository.findById(id);
        return book1;
    }
    //通过bookName查询书籍信息
    @RequestMapping(value = "/search/bookName/{bookName}")
    public List<BookM> getBookByBookName(@PathVariable String bookName) {
        List<BookM> bookM = bookService.findByBookName(bookName);
        return bookM;
    }
}


*/
