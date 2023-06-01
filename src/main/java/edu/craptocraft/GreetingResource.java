package edu.craptocraft;

import java.net.URI;
import java.util.List;
import edu.craptocraft.repository.Developer;
import edu.craptocraft.repository.DeveloperRepository;
import io.smallrye.common.constraint.NotNull;
import jakarta.inject.Inject;
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

    @Inject
    DeveloperRepository developerRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{name}")
    public Developer findByName(@PathParam("name") String name) {
        return developerRepository.findByName(name);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDev(Developer dev) {

        developerRepository.create(dev);
        return Response.created(URI.create("/dev/" + dev.getId()))
                .build();
    }
}
