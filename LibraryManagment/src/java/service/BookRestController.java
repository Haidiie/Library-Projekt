/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.BookManagmentInterface;
import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Heidar
 */
@Stateless
@Path("entity.Book")
public class BookRestController {
    
    @Inject
    BookManagmentInterface bdao;
    
    @POST
    @Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createBook(Book b){
        bdao.addBook(b);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getAllBooks() {
        return bdao.getAllBooks();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Book b){
        bdao.updateBook(b);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Book find(@PathParam("id") Integer id) {
        return bdao.findById(id);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void remove(@PathParam("id") Integer id, Book b) {
        bdao.removeBook(b);
    }
    
}