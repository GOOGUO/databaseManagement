package com.jnj.EDG.service;

import com.jnj.EDG.entity.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class FileBookServicelmpl implements BookService {
    String filePath = "C:\\somethings\\EDG\\P1-databaseManagement\\data\\fileManagement.file";

    //增加书籍的方法
    public String addBook(@RequestParam(value = "bookName", required = true) String bookName,
                          @RequestParam(value = "author", required = true) String author,
                          @RequestParam(value = "publisher", required = true) String publisher,
                          @RequestParam(value = "ISBN", required = true) String ISBN,
                          @RequestParam(value = "ASIN", required = true) String ASIN,
                          @RequestParam(value = "category", required = true) String category,
                          @RequestParam(value = "vendor", required = true) String vendor) throws IOException, ClassNotFoundException {
        //System.out.println(bookName);

        Book book = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        if (book.getId() == null) {
            //缺无主键操作
            return "未发现主键,未添加书籍";
        } else {
            //System.out.println("#########=================book" + book);
            File file = new File(filePath);
            List<Book> bookList = new ArrayList<>();
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() != 0) {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
                bookList = (List<Book>) is.readObject();
                is.close();
            }
            bookList.add(book);
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(bookList);
            os.close();
            return book.toString();
        }
    }

    //通id删除书籍的方法
    public void deleteById(String id) throws IOException, ClassNotFoundException {
        List<Book> bookResult;
        List<Book> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<Book>) is.readObject();
        is.close();

        bookResult = bookList.stream().filter(b -> !(b.getId().equals(id))).collect(Collectors.toList());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
        os.writeObject(bookResult);
        os.close();

    }

    //删除所有书籍
    public void deleteAllBook() throws IOException {
        File file = new File(filePath);
        List<Book> bookList = new ArrayList<>();

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(bookList);
        os.close();
    }

    //更新书籍的方法
    public String updateBook(@RequestParam(value = "bookName", required = false) String bookName,
                             @RequestParam(value = "author", required = false) String author,
                             @RequestParam(value = "publisher", required = false) String publisher,
                             @RequestParam(value = "ISBN", required = false) String ISBN,
                             @RequestParam(value = "ASIN", required = false) String ASIN,
                             @RequestParam(value = "category", required = false) String category,
                             @RequestParam(value = "vendor", required = false) String vendor) throws IOException, ClassNotFoundException {
        //System.out.println(bookName);

        Book book = new Book(bookName, author, publisher, ISBN, ASIN, category, vendor);
        //System.out.println("#########=================book" + book);
        deleteById(book.getId());
        addBook(bookName, author, publisher, ISBN, ASIN, category, vendor);
        return book.toString();
    }

    //查找所有书籍的方法
    public List<Book> findAll() throws IOException, ClassNotFoundException {
        List<Book> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<Book>) is.readObject();
        is.close();

        return bookList;
    }

    //通过bookName查找书籍的方法
    public List<Book> findByBookName(String bookName) throws IOException, ClassNotFoundException {
        List<Book> books;
        List<Book> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<Book>) is.readObject();
        is.close();

        books = bookList.stream().filter(b -> b.getBookName().equals(bookName)).collect(Collectors.toList());

        return books;
    }


    //通过id查找书籍
    public String findById(String id) throws IOException, ClassNotFoundException {
        Book book;
        List<Book> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<Book>) is.readObject();
        is.close();

        book = bookList.stream().filter(b -> b.getId().equals(id)).collect(Collectors.toList()).get(0);

        return book.toString();
    }
}
    /*
    @Override
    public Collection<BookF> findAllBooks() throws IOException, ClassNotFoundException {
        BookF book = null;
        List<BookF> bookList = new ArrayList<>();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<BookF>) is.readObject();
        is.close();
        return bookList;
    }

    @Override
    public BookF findBookByid(String id) throws IOException, ClassNotFoundException {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        BookF book;
        List<BookF> bookList = new ArrayList<>();
        bookList = (List<BookF>) is.readObject();
        System.out.println(bookList);
        book = bookList.stream().filter(b -> b.getId().equals(id)).collect(Collectors.toList()).get(0);
        is.close();

        return book;
    }

    @Override
    public Collection<BookF> findBookByBookName(String bookName) throws IOException, ClassNotFoundException {
        List<BookF> books;
        List<BookF> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<BookF>) is.readObject();
        is.close();

        books = bookList.stream().filter(b -> b.getBookName().equals(bookName)).collect(Collectors.toList());
        System.out.println(books);


        return books;
    }

    @Override
    public Collection<BookF> findBookByauthor(String boauthor) {
        return null;
    }

    @Override
    public Collection<BookF> findBookBypublisher(String publisher) {
        return null;
    }

    @Override
    public BookF findBookByISBN(String bookISBN) {
        return null;
    }

    @Override
    public BookF findBookByASIN(String bookASIN) {
        return null;
    }

    @Override
    public Collection<BookF> findBookBycategory(String category) {
        return null;
    }

    @Override
    public Collection<BookF> findBookByvendor(String bovendor) {
        return null;
    }

    @Override
    public Collection<BookF> addBook(BookF book) throws IOException, ClassNotFoundException {
        System.out.println(book);
        File file = new File(filePath);
        List<BookF> bookList = new ArrayList<>();
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.length() != 0){
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(file));
            bookList = (List<BookF>) is.readObject();
        }
        bookList.add(book);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        os.writeObject(bookList);
        os.close();
        return bookList;
    }

    @Override
    public String deleteAllBooks() throws IOException {
        File file = new File(filePath);
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file));
        List<BookF> bookList = new ArrayList<>();
        os.writeObject(bookList);
        os.close();
        return "Delete all boos, succeed!";
    }

    @Override
    public List<BookF> deleteBookByid(String id) throws IOException, ClassNotFoundException {
        List<BookF> bookResult;
        List<BookF> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<BookF>) is.readObject();
        is.close();

        bookResult = bookList.stream().filter(b -> !(b.getId().equals(id))).collect(Collectors.toList());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
        os.writeObject(bookResult);
        os.close();

        return bookResult;
    }
    @Override
    public List<BookF> updateBookWithBookName(String id, String bookName, String bookNameChanged) throws IOException, ClassNotFoundException {
        List<BookF> books;
        List<BookF> bookList = new ArrayList<>();

        ObjectInputStream is = new ObjectInputStream(new FileInputStream(filePath));
        bookList = (List<BookF>) is.readObject();
        is.close();

        bookList.stream()
                .filter(b -> b.getId().equals(id) && b.getBookName().equals(bookName))
                .forEach(b -> b.setBookName(bookNameChanged));
        books =  bookList.stream()
                .filter(b -> b.getId().equals(id) && b.getBookName().equals(bookNameChanged))
                .collect(Collectors.toList());

        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filePath));
        os.writeObject(bookList);
        os.close();

        return books;
    }
}
*/