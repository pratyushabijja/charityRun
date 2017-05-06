package com.spicinemas.notification;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NotificationUtil {
	
	@Value("${authorization.key}")
	String firebaseAuthorizationKey;
	
	@Value("${notification.endpoint}")
	String firebaseNotificationEndpoint;

	public void sendDummyNotification(String firebaseDeviceToken, String movieId) throws Exception{
		
		URL url = new URL(firebaseNotificationEndpoint);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + firebaseAuthorizationKey);
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();

		json.put("to", firebaseDeviceToken.trim());
		JSONObject info = new JSONObject();
		info.put("title", "Movie Bonanza"); 
		info.put("body", "Book Baahubali: The Conclusion's tickets now at https://spicine.ma/baahubali2?uid=m1"); // Notification
		// body
		json.put("notification", info);
		try
		{
			OutputStreamWriter wr = new OutputStreamWriter(
				   conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader(
				   (conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null)
			{
				System.out.println(output);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("GCM Notification is sent successfully");
		
	}

}
