package Resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecs {
	
	public static RequestSpecification req;
	
	public RequestSpecification InitialRequestSpec() throws FileNotFoundException
	{
		if(req==null)
		{
			PrintStream pt = new PrintStream(new FileOutputStream("logging.txt"));
			req = new RequestSpecBuilder().setBaseUri("http://localhost:8080/")
		    		.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(pt))
		    		.addFilter(ResponseLoggingFilter.logResponseTo(pt))
		    		.build();
			return req;
		}
		return req;
	}

}
