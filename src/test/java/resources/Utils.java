package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	static RequestSpecification req;

	public RequestSpecification RequestBuilder () throws IOException

	{
		
		if (req==null)
		{
			PrintStream log = new PrintStream(new FileOutputStream ("Log_File.txt"));
			req =new RequestSpecBuilder().setBaseUri(globalvariables("baseURI")).addQueryParam("key", "qaclick123")
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON).build();
			return req;

		}
		return req;
	}

	
	
	public String globalvariables(String ReadingValue) throws IOException
	{
		FileInputStream fis =new FileInputStream("C:\\Users\\admin\\workspace\\API_Framework\\src\\test\\java\\resources\\Global.properties");  

		Properties prop =new Properties();  
		prop.load(fis);  
		return prop.getProperty(ReadingValue);

	}
	public String getjsonvalue(Response response,String RequieredValue)
	{
		String FinalResponse = response.asString();
		JsonPath JString  = new JsonPath(FinalResponse);
		return JString.get(RequieredValue).toString();
	}
}
