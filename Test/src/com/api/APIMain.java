package com.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIMain {

	public static void main (String[] args) throws IOExecption, InterruptedExeception {
		var url = "https://covid19.mathdro.id/api";
		
		// http request created using builder methods
		// Get method to print response body
		// URI uniform resource identifier: String identifier that refers to a resource on the internet
		// URL find the location of the resource on the web
		var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		// http client send a request
		// new builder is static method here & build method is to deliver the data
		var client = HttpClient.newBuilder().build();
		
		HttpResponse<String> response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace(); // it handle the exception or error 
		}
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}
				
}
	
