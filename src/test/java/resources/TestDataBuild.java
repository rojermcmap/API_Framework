package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {

	public AddPlace AddPlacePayload(String adddress,String language,String phone)
	{
		AddPlace p =new AddPlace();
		p.setAccuracy(50);
		p.setAddress(adddress);
		p.setLanguage(language);
		p.setPhone_number(phone);
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Frontline house");

		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);

		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);

		p.setLocation(l);
		return p;
	}


	public String DeletePlacePayload(String PlaceID)
	{
		return ("{\r\n\"place_id\":\""+PlaceID+"\"\r\n\t\r\n}");
	}

}