Feature: Google_Place

@add-and-Getplace @Regression @Smoke
Scenario Outline: Add Place
Given Add Plcae Payload with "<Address>" "<Language>" "<Phone>"
When user calls "AddPlaceAPI" with "post" HTTP request
Then the API call got success with status code 200
And "status" in response is "OK"
And "scope" in response is "APP"
And veriy whether the place "<Address>" is created using "GetplaceAPI"

Examples:
	|Address|Language|Phone|
	|Pondiq	|Tamil	 |12345|
	|Valasi	|English |999  |
	
@DeletePlace @Regression 
Scenario:
Given Delete place payload
When user calls "DeleteplaceAPI" with "post" HTTP request
Then the API call got success with status code 200
And "status" in response is "OK"