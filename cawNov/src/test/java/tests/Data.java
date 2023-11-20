package tests;

public class Data 
{
	static String s;
	static String exp;
	public static String data()
	{
		
		s = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\" : \"male\"},"
				+ " {\"name\": \"George\",\"age\" : 42, \"gender\" : \"male\"},"
				+ "{\"name\": \"Sara\",  \"age\" : 42, \"gender\" : \"female\"},"
				+ "{\"name\": \"Conor\", \"age\" : 40, \"gender\" : \"male\"},"
				+ "{\"name\": \"Jennifer\",\"age\" : 42,\"gender\" : \"female\"}]";
		return s;
		
	}
	public static String expected()
	{
		 exp = "Bob,20,male,"
				+ "George,42,male,"
				+ "Sara,42,female,"
				+ "Conor,40,male,"
				+ "Jennifer,42,female,";
		return exp;
	}

}


