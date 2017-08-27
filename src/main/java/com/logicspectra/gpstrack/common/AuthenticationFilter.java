package com.logicspectra.gpstrack.common;

import java.io.IOException;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;

import com.logicspectra.gpstrack.resource.UserResource;
import com.logicspectra.gpstrack.server.GPSTrackRepository;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

	@Inject
	private GPSTrackRepository repository;
	
	private static final Logger logger = Logger.getLogger(AuthenticationFilter.class.getName());

	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Headers are multi-valued Map
		// Do we need to check, we may get multiple ',' separated values
		// other option is to get all headers and get first values
		String authHeader = requestContext.getHeaderString("authorization");

		if (authHeader == null || authHeader.isEmpty()) {
			throw new WebApplicationException("UnAuthorization Exception");
		}
		String[] auth = decodeBasicAuthentication(authHeader);
		
		logger.info("UserName : "+auth[0]+" ,Password : "+auth[1]);
		
		String requestedAction = requestContext.getMethod();
		if ("get".equalsIgnoreCase(requestedAction))
			requestedAction = "read";
		else
			requestedAction = "update";
		
		String password = getUserPassword(auth[0]);
		logger.info("Password from db :"+password);
        if (password == null)
        	throw new WebApplicationException("UnAuthorization Exception");
        if (!basicAuthenticate(password, auth))
        	throw new WebApplicationException("UnAuthorization Exception");

	}

	private String[] decodeBasicAuthentication(String authHeader) {
		String auth = authHeader.replaceFirst("[B|b]asic ", "");
		byte[] decodedBytes = DatatypeConverter.parseBase64Binary(auth);
		String[] userPass = new String(decodedBytes).split(":", 2);
		return userPass;
	}

	private boolean basicAuthenticate(String password, String[] decodedAuth) {
		try {
			if (password == null || decodedAuth == null) {
				logger.info("Invalid Password");
				return false;
			}
			if (decodedAuth[1].equals(decryptPassword(password)))
				return true;
		} catch (Exception authenticatePassword) {
			logger.info("Invalid Password");
		}
		return false;
	}

	private String decryptPassword(String password) {
		logger.info(" Password received is :"+ password);
		return password;
	}
	
	private String getUserPassword(String userName) {
		logger.info("searching user with emailid :"+userName); 
		//get password from data base
		UserResource user =repository.getUser(userName);
		logger.info("User Found : :"+user); 
		return user.getPassword();
    }

}
