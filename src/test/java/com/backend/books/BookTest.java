package com.backend.books;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BookTest {

    @Test
    public void idShouldHaveSetterAndGetter() {
        int expected = 123;
        Book book = new Book();
        book.setId(expected);
        assertThat(book.getId(), is(equalTo(expected)));
    }

    @Test
    public void equalsShouldFailIfIdIsNotTheSame() {
        Book book1 = new Book(111);
        book1.setTitle("title");
        book1.setPrice(12.34);
        Book book2 = new Book(222);
        book2.setTitle("title");
        book2.setPrice(12.34);
        assertThat(book1, is(not(equalTo(book2))));
    }

}
