package com.ssayed.examples.structural.adapter.facebookApi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FacebookResponse {
	private List<Post> posts = new ArrayList<>();

	public static class Post {
		private LocalDateTime postedDate;
		private String text;

		public Post(LocalDateTime postedDate, String text) {
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

	public List<Post> getPosts() {
		return posts;
	}
}