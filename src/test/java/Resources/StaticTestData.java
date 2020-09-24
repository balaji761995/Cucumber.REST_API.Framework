package Resources;

public enum StaticTestData {
	
	AuthAPI("rest/auth/1/session"),
	NewIssueAPI("rest/api/2/issue/");
	
	private String resource;
	
	StaticTestData(String resource)
	{
		this.resource = resource;
	}
	
	public String getData()
	{
		return resource;
	}

}
