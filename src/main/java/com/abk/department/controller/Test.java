package com.abk.department.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Test {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");
		headers.set("X-COM-LOCATION", "USA");
		headers.setContentType(MediaType.APPLICATION_JSON);
		// headers.set("content-type", MediaType.APPLICATION_JSON);

		HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
		for (Integer i = 0; i < 100; i++) {
			String url = "http://localhost:9999/department/departments/{id}";
			ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, i);
			System.out.println(result.getBody());
		}
	}
}