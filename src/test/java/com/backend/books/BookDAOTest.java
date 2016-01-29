package com.backend.books;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class BookDAOTest extends CommonTest {

    @Before
    public void beforeBookDAOTest() {
        bookDAO.saveOrUpdateBook(book);
    }

    @After
    public void afterBookDAOTest() {
        bookDAO.deleteAllBooks();
    }

    @Test
    public void getAllBooksShouldReturnAllBooks() {
        assertThat(bookDAO.getAllBooks().size(), is(equalTo(1)));
    }

    @Test
    public void deleteAllBooksShouldDeleteAllBooks() {
        bookDAO.deleteAllBooks();
        assertThat(bookDAO.getAllBooks().size(), is(equalTo(0)));
    }

    @Test
    public void getAllBooksShouldReturnsBooksWithId() {
        Book actual = bookDAO.getAllBooks().get(0);
        assertThat(actual.getId(), is(equalTo(id)));
    }

    @Test
    public void getAllBooksShouldReturnsBooksWithTitle() {
        Book actual = bookDAO.getAllBooks().get(0);
        assertThat(actual.getTitle(), is(equalTo(title)));
    }

    @Test
    public void getBookShouldReturnBookWithTheSpecifiedId() {
        Book actual = bookDAO.getBook(id);
        assertThat(actual, is(equalTo(actual)));
    }

    @Test
    public void getBookShouldReturnNullIfIdDoesNotExist() {
        Book actual = bookDAO.getBook(123);
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void saveOrUpdateBookShouldSaveTheNewBook() {
        int actualId = 123;
        book.setId(actualId);
        bookDAO.saveOrUpdateBook(book);
        assertThat(bookDAO.getAllBooks().size(), is(equalTo(2)));
        assertThat(bookDAO.getBook(actualId), is(equalTo(book)));
    }

    @Test
    public void saveOrUpdateBookShouldUpdateExistingBook() {
        book.setPrice(12.34);
        bookDAO.saveOrUpdateBook(book);
        assertThat(bookDAO.getAllBooks().size(), is(equalTo(1)));
        assertThat(bookDAO.getBook(id), is(equalTo(book)));
    }

    @Test
    public void deleteBookShouldReturnDeletedBook() {
        Book actual = bookDAO.deleteBook(id);
        assertThat(actual, is(equalTo(book)));
    }

    @Test
    public void deleteBookShouldReturnNullIfBookDoesNotExist() {
        Book actual = bookDAO.deleteBook(123);
        assertThat(actual, is(nullValue()));
    }

    @Test
    public void deleteBookShouldDeleteSpecifiedBook() {
        bookDAO.deleteBook(id);
        assertThat(bookDAO.getAllBooks().size(), is(equalTo(0)));
    }

}
