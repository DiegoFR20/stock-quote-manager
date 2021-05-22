package com.stockquotemanager.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		try {
			HttpPost request = new HttpPost("http://localhost:8080/notification");
			StringEntity params = new StringEntity("{\"host\":\"localhost\",\"port\":\"8081\"}");
			request.addHeader("content-type", "application/x-www-form-urlencoded");
			request.setEntity(params);
			
			httpClient.execute(request);
		} catch(Exception e) {
			throw new Exception();
		}
	}
}