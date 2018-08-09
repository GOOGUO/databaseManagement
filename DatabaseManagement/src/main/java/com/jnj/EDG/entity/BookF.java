package com.jnj.EDG.entity;

import java.io.Serializable;

public class BookF implements Serializable{
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

        String BookFname;

        @LuceneIndexed
        String publish;*/
    private String id;
    private String bookName;
    private String author;
    private String publisher;
    private String ISBN;
    private String ASIN;
    private String category;
    private String vendor;
    private String borrowDate;
    private String backDate;
    private int bookNumber ;


    public BookF(String bookName, String author, String publisher, String ISBN, String ASIN, String category, String vendor) {
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
