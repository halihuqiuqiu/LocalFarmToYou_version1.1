package edu.iit.cs445.exception;

import edu.iit.cs445.entitites.NullObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by YongYang on 11/6/16.
 */

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    public Response toResponse(Throwable throwable) {

        return Response.status(500).entity(throwable.getMessage()).build();
    }
}
