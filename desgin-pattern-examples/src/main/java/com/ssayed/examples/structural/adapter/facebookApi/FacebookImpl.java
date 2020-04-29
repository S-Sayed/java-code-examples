package com.ssayed.examples.structural.adapter.facebookApi;

import java.time.LocalDateTime;

public class FacebookImpl implements FacebookI {

	@Override
	public FacebookResponse loadAllPosts(String username) {
		return mockFacebookResponse(username);
	}

	private FacebookResponse mockFacebookResponse(String username) {
		FacebookResponse response = new FacebookResponse();
		for (int i = 1; i < 10; i++)
			response.getPosts().add(new FacebookResponse.Post(LocalDateTime.now().withDayOfMonth(i), "Post #" + i));

		return response;
	}
}