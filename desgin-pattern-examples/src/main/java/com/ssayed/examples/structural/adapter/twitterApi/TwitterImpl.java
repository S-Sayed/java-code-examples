package com.ssayed.examples.structural.adapter.twitterApi;

import java.time.LocalDateTime;

public class TwitterImpl implements TwitterI {

	@Override
	public TwitterResponse loadAllTweets(String username) {
		return mockTwitterResponse(username);
	}

	private TwitterResponse mockTwitterResponse(String username) {
		TwitterResponse response = new TwitterResponse();
		for (int i = 1; i < 10; i++)
			response.getTweets().add(new TwitterResponse.Tweet(LocalDateTime.now().withMonth(i), "tweet #" + i));

		return response;
	}
}
