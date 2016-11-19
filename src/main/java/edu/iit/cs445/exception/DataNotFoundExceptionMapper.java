package edu.iit.cs445.exception;

import edu.iit.cs445.entitites.NullObject;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by YongYang on 11/6/16.
 */

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {
    public Response toResponse(DataNotFoundException e) {
        return Response.status(404).entity(e.getMessage()).build();
    }
}
