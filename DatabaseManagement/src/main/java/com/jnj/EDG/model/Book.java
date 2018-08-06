package com.jnj.EDG.model;

import org.apache.geode.cache.DataPolicy;
import org.apache.geode.cache.CacheFactory;
import org.apache.geode.cache.GemFireCache;
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

    Integer ISDN;

    @Indexed
    String author;

    String bookname;

    @LuceneIndexed
    String publish;

    @PersistenceConstructor
    public Book(int ISDN, String author, String bookname, String publish) {
        this.ISDN = ISDN;
        this.author = author;
        this.bookname = bookname;
        this.publish = publish;
    }

    public int getISDN() {
        return ISDN;
    }

    public void setISDN(int ISDN) {
        this.ISDN = ISDN;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getbookname() {
        return bookname;
    }

    public void setbookname(String bookname) {
        this.bookname = bookname;
    }

    public String getpublish() {
        return publish;
    }

    public void setpublish(String publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Book2String{" +
                "ISDN=" + ISDN +
                ", author='" + author + '\'' +
                ", bookname=" + bookname +
                ", publish='" + publish + '\'' +
                '}';
    }
}
