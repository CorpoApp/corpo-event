package com.corpoapp.corpoevent.api;

import com.corpoapp.corpoevent.entity.Corporation;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/corporation")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    @GET
    public List<Corporation> getAll() {
        return Corporation.listAll();
    }

    @POST
    @Transactional
    public Response create(@QueryParam String name, @QueryParam String sport) {
        /*CorporationBuilder
                .aCorporation()
                .withName(name)
                .withSport(sport)
                .build()
                .persist();*/

        return Response.status(201).build();
    }
}
