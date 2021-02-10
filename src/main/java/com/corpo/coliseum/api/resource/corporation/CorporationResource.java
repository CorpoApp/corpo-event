package com.corpo.coliseum.api.resource.corporation;

import com.corpo.coliseum.api.dto.CorporationDTO;
import com.corpo.coliseum.api.mapper.exception.UserException;
import com.corpo.coliseum.domain.entity.Corporation;
import com.corpo.coliseum.domain.exception.ModelNotFoundException;
import com.corpo.coliseum.domain.service.CorporationService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.stream.Collectors;

@Path("/corporation")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorporationResource {

    @Inject
    CorporationService corporationService;

    @Inject
    ModelMapper modelMapper;

    @GET
    @Path("/all")
    public Response getAll() {
        final List<CorporationDTO> corporations =  corporationService.getAll()
                .stream()
                .map(corporation -> modelMapper.map(corporation, CorporationDTO.class))
                .collect(Collectors.toList());
        return Response.ok(corporations).build();
    }

    @GET
    public Response findByName(@QueryParam("name") String name) throws ModelNotFoundException {
        CorporationDTO corporationDTO = modelMapper.map(corporationService.findByName(name), CorporationDTO.class);
        return Response.ok(corporationDTO).build();
    }

    @POST
    public Response create(@Valid CorporationDTO corporationDTO, @Context UriInfo uriInfo) {
        corporationService.create(modelMapper.map(corporationDTO, Corporation.class));
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(corporationDTO.getName());
        return Response.created(uriBuilder.build()).build();
    }

    @DELETE
    public Response delete(@QueryParam("name") String name) throws ModelNotFoundException {
        corporationService.remove(name);
        return Response.noContent().build();
    }

    @PATCH
    @Path("/register")
    public Response register(@Valid RegisterUserToCorportationInput registerUserToCorportationInput) throws ModelNotFoundException, UserException {
        corporationService.register(registerUserToCorportationInput);
        return Response.ok().build();
    }
}
