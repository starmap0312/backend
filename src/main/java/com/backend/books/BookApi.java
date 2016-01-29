package com.backend.books;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.glassfish.jersey.server.JSONP;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/items")
@Produces(MediaType.APPLICATION_JSON)
public class BookApi {

    private static final String ITEMS_URL = "/api/v1/items";

    @GET
    @JSONP(queryParam = "callback")
    public String getAllBooks(@QueryParam("offset") int offset,
                              @QueryParam("count") int count,
                              @QueryParam("callback") String callback) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        List<Book> books = BookDAO.getInstance().getAllBooks(offset, count);
        return mapper.writeValueAsString(books);
    }

    @DELETE
    @JSONP(queryParam = "callback")
    public void deleteAllBooks() throws Exception {
        BookDAO.getInstance().deleteAllBooks();
    }

    @GET
    @Path("/{id}")
    @JSONP(queryParam = "callback")
    public String getBook(@PathParam("id") int id) throws Exception {
        Book book = BookDAO.getInstance().getBook(id);
        return new ObjectMapper().writeValueAsString(book);
    }

    @PUT
    @JSONP(queryParam = "callback")
    public void putUser(String bookJson) throws Exception {
        Book book = new ObjectMapper().readValue(bookJson, Book.class);
        BookDAO.getInstance().saveOrUpdateBook(book);
    }

    @DELETE
    @Path("/{id}")
    @JSONP(queryParam = "callback")
    public void deleteBook(@PathParam("id") int id) throws Exception {
        BookDAO.getInstance().deleteBook(id);
    }

}

