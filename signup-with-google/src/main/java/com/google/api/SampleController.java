package com.google.api;


import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	//edit properties file to add client id and secret key
	@GetMapping("/")
	public Object currentUser(OAuth2AuthenticationToken  auth2AuthenticationToken) {
		return auth2AuthenticationToken.getPrincipal().getAttributes();
//		return "logged in successfully";
	}
}