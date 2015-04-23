/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.rhythmtech.cineplex.rest.ejb;

import ca.rhythmtech.cineplex.enitities.Movie;
import ca.rhythmtech.cineplex.rest.AbstractFacade;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author mdoucette
 */
@Named
@Stateless
@Path("movies")
public class MovieFacadeRest extends AbstractFacade<Movie> {

    @PersistenceContext
    EntityManager em;

    public MovieFacadeRest() {
        super(Movie.class);
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Movie> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to}); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Movie> getAll() {
        return super.getAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Movie find(@PathParam("id") Integer id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id)); //To change body of generated methods, choose Tools | Templates.
    }

    @PUT
    @Consumes({"application/xml", "application/json"})
    @Path("{id}")
    @Override
    public void edit(Movie entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    @Override
    public void create(Movie entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String getCount() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
