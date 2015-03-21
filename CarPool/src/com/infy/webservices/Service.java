package com.infy.webservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.infy.database.Dbhelper;
import com.infy.entity.User;
import com.sun.jersey.api.json.JSONJAXBContext;

@Path("/")
public class Service {

	@Provider
	public static class JAXBContextResolver implements
			ContextResolver<JAXBContext> {

		@SuppressWarnings("unused")
		private JAXBContext context;
		@SuppressWarnings("unchecked")
		private Class[] types = {User.class};

		@SuppressWarnings("deprecation")
		public JAXBContextResolver() throws Exception {
			Map<String, Object> props = new HashMap<String, Object>();
			props.put(JSONJAXBContext.JSON_NOTATION, "MAPPED_JETTISON");
			props.put(JSONJAXBContext.JSON_ROOT_UNWRAPPING, Boolean.FALSE);
			this.context = new JSONJAXBContext(types, props);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see javax.ws.rs.ext.ContextResolver#getContext(java.lang.Class)
		 */
		@SuppressWarnings("deprecation")
		public JAXBContext getContext(Class<?> objectType) {

			JAXBContext jaxb = null;
			for (int i = 0; i < types.length; i++) {
				if (types[i].equals(objectType)) {
					Map<String, Object> props = new HashMap<String, Object>();
					props.put(JSONJAXBContext.JSON_NOTATION, "MAPPED_JETTISON");
					props.put(JSONJAXBContext.JSON_ROOT_UNWRAPPING,
							Boolean.FALSE);
					try {
						jaxb = new JSONJAXBContext(types, props);

					} catch (JAXBException e) {

					}
					break;
				}
			}
			return jaxb;
		}
	}

	private final static Logger logger = Logger.getLogger(Service.class);

	/**
	 * Home Page of the Web Services
	 */
	@GET
	@Path("/home")
	@Produces(MediaType.APPLICATION_JSON)
	public String home() {
		// First Web-Service to display the Welcome message
		// of the application.
		// TODO - Home

		System.out.println("WebService Working");
		logger.info("WebService Working");
		return " Welcome to Carpool Middleware Web services - Ver 1 ";
	}

	@POST
	@Path("/insertUser")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public String setUser(String request) throws Exception {
		
		logger.info("Request:"+request);
		System.out.println("Request:"+request);

		try {
			Gson gson = new Gson();
			User user = new User();
			user = gson.fromJson(request, User.class);

			Dbhelper dbhelper = new Dbhelper();
			String response = dbhelper.setUser(user);
			return response;

		} catch (Exception ex) {

			logger.info("setUser:Service.java have errors: " + ex.getMessage());
			return "Failure";
		}
	}

}
