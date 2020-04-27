package step_definitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before ("@DeletePlace")
	public void deleteprecondition() throws Throwable 
	{

		StepDefinition m = new StepDefinition();
		if (StepDefinition.DynPlaceID==null)
		{
			m.add_plcae_payload_with_something_something_something("Garuda","Telugu", "911");
			m.user_calls_something_with_something_http_request("AddPlaceAPI","POST");
			m.veriy_whether_the_place_something_is_created_using_something("Garuda", "GetplaceAPI");
		}
	}
}
