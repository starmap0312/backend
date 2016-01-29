package com.backend.books;

import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

public class CommonTest {

    protected final int id = 42;
    protected final String title = "My Life";
    protected final double price = 5.99;
    protected Book book;
    protected BookDAO bookDAO = BookDAO.getInstance();

    @Before
    public void beforeCommonTest() {
        book = new Book(id);
        book.setTitle(title);
        book.setPrice(price);
    }

    protected List<Book> insertBooks(int count) {
        List<Book> books = new ArrayList<>();
        for (int index = 1; index <= count; index++) {
            Book book = new Book(index);
            book.setTitle(title);
            book.setPrice(price);
            bookDAO.saveOrUpdateBook(book);
            books.add(book);
        }
        return books;
    }

}
