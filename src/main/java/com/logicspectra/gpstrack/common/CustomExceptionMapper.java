/**
 * 
 */
package com.logicspectra.gpstrack.common;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * 
 *
 */
@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception>
{

	public Response toResponse(Exception exception) {
		exception.printStackTrace();
		String message = exception.toString();
	    return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(message).type(MediaType.TEXT_PLAIN_TYPE).build();
	}
//
//  @Override
//  public Response toResponse(Exception exception)
//  {
//
//    Response.Status status = null;
//    String message = null;
//
//    if (exception instanceof InvalidParameterException)
//    {
//      status = Response.Status.BAD_REQUEST;
//    } if (exception instanceof ApplicationException) 
//    {
//      status = Response.Status.BAD_GATEWAY;
//    }
//    else
//    {
//      status = Response.Status.SERVICE_UNAVAILABLE;
//    }
//
//    message = exception.toString();
//    return Response.status(status).entity(message).type(MediaType.TEXT_PLAIN_TYPE).build();
//
//  }
}
