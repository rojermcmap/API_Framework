package resources;

public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"),
	DeleteplaceAPI("/maps/api/place/delete/json"),
	GetplaceAPI("/maps/api/place/get/json");
	
	String ResourcesValue;
	
	APIResources(String fromUser)
	{
		this.ResourcesValue = fromUser;
	}
	
	public String Resources()
	
	{
		return ResourcesValue;
	}
	
}
