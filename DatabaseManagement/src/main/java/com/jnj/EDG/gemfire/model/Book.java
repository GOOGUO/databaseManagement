package com.jnj.EDG.model;

import org.apache.geode.cache.DataPolicy;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.GemFireCache;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.gemfire.PartitionedRegionFactoryBean;
import org.springframework.data.gemfire.mapping.annotation.Indexed;
import org.springframework.data.gemfire.mapping.annotation.LuceneIndexed;
import org.springframework.data.gemfire.mapping.annotation.Region;

import java.io.Serializable;

@Region("Book")
public class Book {
/*    PartitionedRegionFactoryBean exampleRegion(GemFireCache gemfireCache) {

        PartitionedRegionFactoryBean<Long, Example> exampleRegion =
                new PartitionedRegionFactoryBean<>();

        exampleRegion.setDataPolicy(DataPolicy.PERSISTENT_REPLICATE);

        return exampleRegion;
    }*/


    //private static final long serialVersionUid = 1L;

    /*    Integer ISDN;

        @Indexed
        String author;

        String bookname;

        @LuceneIndexed
        String publish;*/
    @Id
    String id;
    @Indexed
    String bookName;

    String author;
    String publisher;
    String ISBN;
    String ASIN;
    String category;
    String vendor;
    String borrowDate;
    String backDate;
    int bookNumber ;


    @PersistenceConstructor
    public Book(String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) {
        if (ISBN.isEmpty()) {
            if (ASIN.isEmpty()) {
                System.out.println("Key is not found!");
                id = null;
            } else {
                //System.out.println("ISBN to id");
                id = ASIN;
            }
        } else {
            //System.out.println("ASIN to id");
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

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    public String getBookName() {
        return bookName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id='" + id + '\'' +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", ASIN='" + ASIN + '\'' +
                ", category='" + category + '\'' +
                ", vendor='" + vendor + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", backDate='" + backDate + '\'' +
                ", bookNumber=" + bookNumber +
                '}';
    }
}
