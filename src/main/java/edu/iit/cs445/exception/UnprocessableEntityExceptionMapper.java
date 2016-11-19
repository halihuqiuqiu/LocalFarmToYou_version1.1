package edu.iit.cs445.exception;

import edu.iit.cs445.entitites.NullObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by YongYang on 11/17/16.
 */
@Provider
public class UnprocessableEntityExceptionMapper implements ExceptionMapper<UnprocessableEntityException> {
    public Response toResponse(UnprocessableEntityException e) {
        return Response.status(422).entity(e.getMessage()).build();
    }

}
