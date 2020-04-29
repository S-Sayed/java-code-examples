package com.ssayed.examples.structural.adapter.handlers;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ssayed.examples.structural.adapter.model.Table;
import com.ssayed.examples.structural.adapter.twitterApi.TwitterI;
import com.ssayed.examples.structural.adapter.twitterApi.TwitterImpl;
import com.ssayed.examples.structural.adapter.twitterApi.TwitterResponse;

public class TwitterHandler {
	TwitterI twitterApi = new TwitterImpl();

	public Table getTweets(String userName) {
		TwitterResponse res = twitterApi.loadAllTweets(userName);
		return convertResponseToTable(res);
	}

	private Table convertResponseToTable(TwitterResponse res) {
		Table table = new Table();
		for (TwitterResponse.Tweet tweet : res.getTweets()) {
			Map<Table.Column, String> row = new LinkedHashMap<>();
			row.put(new Table.Column("Date"), tweet.getPostedDate().toString());
			row.put(new Table.Column("Tweet"), tweet.getText());
			table.getData().add(row);
		}

		return table;
	}
}