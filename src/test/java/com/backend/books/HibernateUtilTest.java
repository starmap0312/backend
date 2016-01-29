package com.backend.books;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.hibernate.Session;

public class HibernateUtilTest {

    @Test
    public void getSessionFactoryShouldNotBeNull() {
        assertThat(HibernateUtil.getSessionFactory().openSession(), notNullValue());
    }

    @Test
    public void getSessionFactoryShouldBeAbleToOpenAndCloseSession() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        assertThat(session.isConnected(), is(true));
        session.close();
        assertThat(session.isConnected(), is(false));
    }

}
