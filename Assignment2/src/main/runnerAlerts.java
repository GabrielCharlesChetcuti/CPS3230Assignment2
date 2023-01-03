package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class runnerAlerts {

	int i = 0;
	int counter = 0;
	int deleteCounter = 0;
	int event = 0;
    BufferedReader reader;
    String line;
    StringBuilder GetResponse = new StringBuilder();
    
    String URL = "https://api.marketalertum.com/EventsLog/b8f8d062-5baa-4d7e-8958-ec836a8e26cb";
    JSONArray alerts = new JSONArray();	        
    
		
	    public void Alerts() throws IOException
	    {   
	        URL url = new URL(URL);
	        URLConnection conn = url.openConnection();

	        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        while ((line = reader.readLine()) != null) 
	        {
	        	GetResponse.append(line);
	        	
	        }
	        
	        reader.close();
		        
	        
	        String JSONString = GetResponse.toString();
	        JSONArray JSONArray = new JSONArray(JSONString);
	
            for (int i=0; i<JSONArray.length(); i++)
	        {
	            JSONObject JSONObject = JSONArray.getJSONObject(i); 
	            
	            
	            event = JSONObject.getInt("eventLogType");
	            
	            alerts = JSONObject.getJSONObject("systemState").getJSONArray("alerts");
	            
		        
			    if(event == 0)
			    {
			    	counter++;
			    }
			    
			    if(event == 1)
			    {
			    	deleteCounter++;
			    }
	        }
            
            if(deleteCounter >= 1)
			{
            	succesfulDelete();
            	
            	if(alerts.isEmpty() == false)
    			{
    				PostedSuccesfully();
    				checkAlertsData(alerts);
    			}
    			else 
    			{
    				PostedUnsuccesfully();
    			} 
			}
			else
			{
				unsuccesfulDelete();
			} 
	    }
	    
	    
	    int alertTypeCounter = 0;
	    int headingCounter = 0;
	    int descriptionCounter = 0;
	    int urlCounter = 0;
	    int imageURLCounter = 0;
	    int priceInCentsCounter = 0;
	    
	    
	    public void checkAlertsData(JSONArray alerts){
	    	
	    	int alertType = 0;
            String heading = "";
            String description = "";
            String postUrl = "";
            String imageURL = "";
            int priceInCents = 0;
            String msg = "";
	    	
	    	for (i = 0; i <= alerts.length()-1; i++) 
	    	{
		         JSONObject obj = alerts.getJSONObject(i);
		            
		            alertType = obj.getInt("alertType");
		            heading = obj.getString("heading");
		            description = obj.getString("description");
		            postUrl = obj.getString("url");
		            imageURL = obj.getString("imageURL");
		            priceInCents = obj.getInt("priceInCents");
		            
		           
		           if (alertType != 0 && alertTypeCounter <= 3) {
		               alertTypeCounter++;
		           }
		           else
		           {
		        	   msg = "Wrong Alert Type Data Found.";
		        	   DataErrorOutput(msg);
		           }
		           if (!postUrl.isEmpty() && urlCounter <= 3) {
		        	   urlCounter++;
		           }
		           else
		           {
		        	   msg = "Wrong URL Data Found.";
		        	   DataErrorOutput(msg);
		           }
		           if (!heading.isEmpty() && headingCounter <= 3) {
		               headingCounter++;
		           }
		           else
		           {
		        	   msg = "Wrong Heading Data Found.";
		        	   DataErrorOutput(msg);
		           }
		           if (!description.isEmpty() && descriptionCounter <= 3) {
		               descriptionCounter++;
		           }
		           else
		           {
		        	   msg = "Wrong Description Data Found.";
		        	   DataErrorOutput(msg);
		           }
		           if (!imageURL.isEmpty() && imageURLCounter <= 3) {
		               imageURLCounter++;
		           }
		           else
		           {
		        	   msg = "Wrong Image URL Data Found.";
		        	   DataErrorOutput(msg);
		           }
		           if (priceInCents != 0 && priceInCentsCounter <= 3) {
		               priceInCentsCounter++;
		           }
		           else
		           {
		        	   msg = "Wrong Price in Cents Data Found.";
		        	   DataErrorOutput(msg);
		           }
		        }
	    	
	    	checkNumberOfAlerts();
	    }
	    
	    public void checkNumberOfAlerts()
	    {
	    	if (alertTypeCounter == 3 && headingCounter == 3 && descriptionCounter == 3 && urlCounter == 3 && imageURLCounter == 3 && priceInCentsCounter == 3 && counter == 3) 
	    	{
	    		dataPostedSuccesfully();        	
	    	} 
	        else 
	         {
	        	dataPostedUnsuccesfully();	        
	         }
	    }
	    
	    public void PostedSuccesfully(){
	    	
	    	System.out.println("Posting of data was succesful.");
	    	
	    }
	     
	    public void PostedUnsuccesfully(){
	    	
	    	System.out.println("Posting of data was unsuccesful.");
	    }
	    
	    public void dataPostedSuccesfully()
	    {
	    	System.out.println("Correct number of alerts was posted.");
	    }
	    
	    public void dataPostedUnsuccesfully()
	    {
	    	System.out.println("Incorrect number of alerts was posted");
	    }
	    
	    public void succesfulDelete()
	    {
	    	System.out.println("Delete was successful.");
	    }
	    
	    public void unsuccesfulDelete()
	    {
	    	System.out.println("Delete was not successful.");
	    }
	    
	    public void DataErrorOutput(String msg)
	    {
	    	System.out.println(msg);
	    }
	    
	    
	    public static void main(String[] args) throws IOException{
	    	
	    	runnerAlerts run = new runnerAlerts();
	    	run.Alerts();
	}
}