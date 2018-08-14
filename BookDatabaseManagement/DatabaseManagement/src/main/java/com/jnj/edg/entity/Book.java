package com.jnj.edg.entity;
/*
Author：公用的实体类
Description：创建了一个实体类
 */

import org.springframework.data.gemfire.mapping.annotation.Region;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.io.Serializable;

@Region
@Entity
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    String id;
    @Column(name = "bookName")
    String bookName;
    @Column(name = "author")
    String author;
    @Column(name = "publish")
    String publisher;
    @Column(name = "ISBN")
    String ISBN;
    @Column(name = "ASIN")
    String ASIN;
    @Column(name = "category")
    String category;
    @Column(name = "vendor")
    String vendor;
    @Column(name = "borrowDate")
    String borrowDate;
    @Column(name = "backDate")
    String backDate;
    @Column(name = "bookNumber")
    int bookNumber;

    public Book() {

    }

    public Book(String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) {
        if (ISBN.isEmpty()) {
            if (ASIN.isEmpty()) {
                System.out.println("Key is not found!");
                id = null;
            } else {
                id = ASIN;
            }
        } else {
            id = ISBN;
        }
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.ASIN = ASIN;
        this.category = category;
        this.vendor = vendor;
        this.borrowDate = null;
        this.backDate = null;
        this.bookNumber = 1;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getASIN() {
        return ASIN;
    }

    public void setASIN(String ASIN) {
        this.ASIN = ASIN;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", ASIN='" + ASIN + '\'' +
                ", category='" + category + '\'' +
                ", vendor='" + vendor + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", backDate='" + backDate + '\'' +
                ", bookNumber='" + bookNumber + '\'' +
                '}';
    }
}
