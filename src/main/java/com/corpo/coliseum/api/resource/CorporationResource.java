package com.corpo.coliseum.api.resource;

import com.corpo.coliseum.api.resource.input.CorporationInput;
import com.corpo.coliseum.domain.service.CorporationService;
import com.corpo.coliseum.api.dto.CorporationDTO;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
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

    @Inject
    CorporationService corporationService;

    @GET
    public List<CorporationDTO> getAll() {
        return corporationService.getAll();
    }

    @POST
    public Response create(@Valid CorporationInput corporationInput) {
        corporationService.create(corporationInput);
        return Response.status(201).build();
    }
}
