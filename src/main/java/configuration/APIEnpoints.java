package configuration;

public class APIEnpoints {
	
	public static final class allAPIEndpoints {
		// GET
//		public static final String GET_LIST_OF_USERS = "/api/users?page=2";
//		public static final String GET_SINGLE_USER = "/api/users/2";
		public static final String GET_LIST_OF_USERS = "/posts";
		public static final String GET_SINGLE_USER = "/posts/1";
		
		// POST
		public static final String CREATE_SINGLE_USER = "/posts";
		
		// UPDATE
		public static final String PUDATE_SINGLE_USER = "/posts";
		
		// DELETE
		public static final String DELETE_SINGLE_USER = "/posts/2";
	}

}
