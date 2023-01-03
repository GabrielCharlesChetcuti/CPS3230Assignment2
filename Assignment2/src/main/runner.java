package main;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONObject;

public class runner {

		public void incorrectLogin()
		{
			System.out.println("Incorrect Login");
		}
		
		public void correctLogin()
		{	
			System.out.println("Correct Login");
		}
		
		public void viewAlerts(int alerts)
		{
				System.out.println("Event Log returned: " +alerts + "\nAlerts have been viewed.");
		}
		
		public void purpouselyLoggedOut()
		{	
			System.out.println("You have Logged Out.");
		}
		
		
		public void login() throws IOException
	    {
	        BufferedReader reader;
	        String line;
	        StringBuilder APIreply = new StringBuilder();
	        int alerts = 0;
	        int LoggedIn = 0;
	        int LoggedOut = 0;
	        int ViewedAlerts = 0;
	        String urlString = "https://api.marketalertum.com/EventsLog/b8f8d062-5baa-4d7e-8958-ec836a8e26cb";
	               
	        URL url = new URL(urlString);
	        URLConnection conn = url.openConnection();


		        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		        while ((line = reader.readLine()) != null) 
		        {
		        	APIreply.append(line);
		        }
		        
		        reader.close();
		        
	        String jsonString = APIreply.toString();
	        
	        JSONArray JSONArray = new JSONArray(jsonString);
		
	        for (int i=0; i<JSONArray.length(); i++)
	        {
	            JSONObject currentObject = JSONArray.getJSONObject(i); 
	            
	            alerts = currentObject.getInt("eventLogType");
	            
	            if(alerts == 5)
	            {
	            	LoggedIn++;
	            }
	            if(alerts == 6)
	            {
	            	LoggedOut++;
	            }
	            if(alerts == 7)
	            {
	            	ViewedAlerts++;
	            }
	        }
	        
	        if(LoggedIn >= 1)
	        {
	        	correctLogin();
	        	
	        	if(ViewedAlerts >= 1)
	        	{
	        		viewAlerts(alerts);
	        	}
	        	if(LoggedOut >= 1)
	        	{
	        		purpouselyLoggedOut();
	        	}
	        }
	        
	        if(LoggedIn == 0)
	        {
	        	incorrectLogin();
	        }
	        
	    }

	public static void main(String[] args) throws IOException {
		runner run = new runner();

	       run.login();
	}

}
