package com.corpoapp.corpoevent.exceptions.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserExceptionMapper implements ExceptionMapper<UserException> {

    @Override
    public Response toResponse(UserException exception) {
        return Response.status(Response.Status.BAD_REQUEST).
                header("reason", exception.getMessage()).
                build();
    }
}
