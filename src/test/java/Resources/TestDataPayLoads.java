package Resources;

import PayLoad.Fields;
import PayLoad.NewIssue;
import PayLoad.Project;
import PayLoad.UserCreds;
import PayLoad.issuetype;

public class TestDataPayLoads {
	
	public UserCreds LoginDetails()
	{
		 UserCreds login = new UserCreds();
		    login.setUsername("balaji761995");
		    login.setPassword("Jun2020@");
		    return login;
	}
	
	public PayLoad.NewIssue NewIssue()
	{
		NewIssue is = new NewIssue();
	    Fields fl = new Fields();
	    Project pro = new Project();
	    pro.setKey("TP");
	    issuetype iss = new issuetype();
	    iss.setName("Bug");
	    fl.setProject(pro);
	    fl.setSummary("REST ye merry gentlemen.");
	    fl.setDescription("Creating of an issue using project keys and issue type names using the REST API");
	    fl.setIssuetype(iss);
	    is.setFields(fl);
	    
	    return is;
	}

}
