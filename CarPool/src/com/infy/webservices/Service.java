package com.infy.webservices;

@Path(/)
public class Service {

	@Provider
	public static class JAXBContextResolver implements
			ContextResolver<JAXBContext> {

		@SuppressWarnings("unused")
		private JAXBContext context;
		@SuppressWarnings("unchecked")
		private Class[] types = { AdminRequest.class, AdminResponse.class,
				AssetDetailsResponse.class, AvailableRequest.class,
				AvailableResponse.class, AssetHistoryRequest.class,
				AssetHistoryResponse.class, RegisteredAssetRequest.class,
				RegisteredAssetResponse.class, TrackerRequest.class,
				TrackerResponse.class, UnavailableRequest.class,
				UnavailableResponse.class, UserListResponse.class,AssetListResponse.class,AssetDetailsRequest.class,
				UpdateRowResponse.class};

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

	private final static Logger logger = Logger.getLogger(WebServices.class);

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

		System.out.println("\nMobility Asset Tracker Home !");
		logger.info("Mobility Asset Tracker !");
		return " Welcome to the Mobility Asset Tracker Web Services - Ver 1 ! :)";
	}

	@GET
	@Path("/getUsersList")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsersList() {
		// Fetches the List of Users and send it as a response.
		// TODO - User List
		try {
			Dbhelper dbHelper = new Dbhelper();
			List<UserListResponse> userList = null;
			try {
				userList = dbHelper.getUsersList();

			} catch (Exception e) {

				System.out.println("\nException in getting User List. - "
						+ e.getMessage());
				e.printStackTrace();
				logger.info("Exception in getting User List. - "
						+ e.getMessage());
			}

			Gson gson = new Gson();
			String response =  gson.toJson(userList);
			System.out.println("\nUserlist : " + response);
			return response;
		} catch (Exception e) {

			System.out.println("Exception Thrown");
			return null;
		}

	}

	@POST
	@Path("/updateTracker")
	@Consumes(MediaType.WILDCARD)
	@Produces(MediaType.APPLICATION_JSON)
	public String getTrackerResponse(String request) throws Exception {
		
		// Fetches the returnCode and updates the device entry information
		// in the Tracker table in the Database.
		// TODO - Tracker
		try {
			Gson gson = new Gson();
			TrackerRequest trackerRequest = new TrackerRequest();
			trackerRequest = gson.fromJson(request, TrackerRequest.class);
			TrackerResponse trackerResponse = new TrackerResponse();

			Dbhelper dbhelper = new Dbhelper();
			String retCode = dbhelper.getTrackerResponse(trackerRequest);

			if (retCode.equals("111")) {
				trackerResponse
						.setRetCode("Device Entry Completed Successfully!");
			} else {
				trackerResponse
						.setRetCode("Device Entry UnSuccessful! Please Try Again.");
				System.out.println("else");
			}

			return trackerResponse.getRetCode();
		} catch (Exception e) {

			System.out.println("Exception Thrown");
			return null;
		}
	}
	
	
}
