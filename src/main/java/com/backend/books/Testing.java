package com.backend.books;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.grizzly.http.server.HttpServer;

public class Testing {

    public static void main(String[] args) {

        HttpServer server = new Server().startServer();

        // add a book to the database
        Book book = new Book(1);
        book.setTitle("MyTitle");
        book.setPrice(1.23);
        BookDAO bookDAO = BookDAO.getInstance();
        bookDAO.saveOrUpdateBook(book);

        // set up RESTful URL path
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:9000/api/");
        WebTarget itemsTarget = target.path("v1/items");

        // RESTful queries
        System.out.println(System.getProperty("simple.message") + args[0] + " from Testing.");
        System.out.println(Integer.toString(itemsTarget.request().head().getStatus()));
        System.out.println(itemsTarget.request().get().getMediaType().toString());
        System.out.println(itemsTarget.request().get(String.class));

        // wait for a period of time to prolong the RESTful service
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {

        }

        // delete the book from the database and shutdown the server
        bookDAO.deleteAllBooks();
        server.shutdown();
    }

}
