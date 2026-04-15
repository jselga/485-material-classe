/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//IMPORTANT QUE SIGUI LA DATE DE JAVA.SQL.DATE

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Enaitz DAM
 */
public class Book {

    private String isbn;
    private String name;
    private Publisher publisher;
    private Date publishDate;
    private double price;
    private List<Chapter> chapters;

    public Book() {
    }

    public Book(String isbn, String name, Date publishDate, double price) {
        this.isbn = isbn;
        this.name = name;
        this.publishDate = publishDate;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", name=" + name + ", publisher=" + publisher
                + ", publishDate=" + publishDate + ", price=" + price + ", chapters=" + chapters + '}';
    }

}
