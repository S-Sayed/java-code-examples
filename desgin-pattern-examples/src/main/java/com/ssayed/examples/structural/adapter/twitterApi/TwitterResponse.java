package com.ssayed.examples.structural.adapter.twitterApi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TwitterResponse {
	private List<Tweet> tweets = new ArrayList<>();

	public static class Tweet {
		private LocalDateTime postedDate;
		private String text;

		public Tweet(LocalDateTime postedDate, String text) {
			this.postedDate = postedDate;
			this.text = text;
		}

		public LocalDateTime getPostedDate() {
			return postedDate;
		}

		public String getText() {
			return text;
		}
	}

	public List<Tweet> getTweets() {
		return tweets;
	}
}