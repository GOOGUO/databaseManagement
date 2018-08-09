package com.jnj.EDG.service;

import com.jnj.EDG.entity.BookF;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class BookFileServicelmpl implements BookFileService {
    String filePath = "C:\\somethings\\EDG\\P1-databaseManagement\\data\\fileManagement.file";
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
