package edu.craptocraft;

import java.net.URI;
import java.util.List;
import edu.craptocraft.repository.Developer;
import io.smallrye.common.constraint.NotNull;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/dev")
public class GreetingResource {

    // @GET
    // @Path("{id}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Developer getDev(@PathParam("id") Long id) {
    // return Developer.findById(id);
    // }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Developer> getAllDevs() {
        return Developer.findAll().list();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Developer findByName(@PathParam("name") String name) {
        return Developer.find("name", name).firstResult();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}/{age}")
    public Developer findByNameAndAge(@NotNull @PathParam("name") String name, @PathParam("age") Integer age) {
        // Developer.find("query").page()
        return Developer.find("name = ?1 and age = ?2", name, age).firstResult();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDev(Developer dev) {

        dev.persist();
        return Response.created(URI.create("/dev/" + dev.id))
                .build();
    }
}
