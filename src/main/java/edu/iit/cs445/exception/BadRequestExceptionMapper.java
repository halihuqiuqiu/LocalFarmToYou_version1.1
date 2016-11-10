package edu.iit.cs445.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by YongYang on 11/6/16.
 */
@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    public Response toResponse(BadRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
