package com.ssayed.examples.structural.adapter;

import com.ssayed.examples.structural.adapter.handlers.FacebookHandler;
import com.ssayed.examples.structural.adapter.handlers.TwitterHandler;
import com.ssayed.examples.structural.adapter.model.SocialMediaType;
import com.ssayed.examples.structural.adapter.model.Table;

public class SocialMediaAdapter implements ActionHandler {

	// handlers that have the adaptee as composition
	TwitterHandler twitterHandler = new TwitterHandler();
	FacebookHandler facebookHandler = new FacebookHandler();

	@Override
	public Table execute(SocialMediaType socialMediaType, String username) {
		if (socialMediaType == SocialMediaType.TWITTER) {
			return twitterHandler.getTweets(username);
		} else if ((socialMediaType == SocialMediaType.FACE_BOOK)) {
			return facebookHandler.getPosts(username);
		}

		return new Table();
	}
}