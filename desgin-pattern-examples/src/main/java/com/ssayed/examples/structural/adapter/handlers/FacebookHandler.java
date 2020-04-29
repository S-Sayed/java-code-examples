package com.ssayed.examples.structural.adapter.handlers;

import java.util.LinkedHashMap;
import java.util.Map;

import com.ssayed.examples.structural.adapter.facebookApi.FacebookI;
import com.ssayed.examples.structural.adapter.facebookApi.FacebookImpl;
import com.ssayed.examples.structural.adapter.facebookApi.FacebookResponse;
import com.ssayed.examples.structural.adapter.model.Table;

public class FacebookHandler {
	FacebookI facebookApi = new FacebookImpl();

	public Table getPosts(String userName) {
		FacebookResponse res = facebookApi.loadAllPosts(userName);
		return convertResponseToTable(res);
	}

	private Table convertResponseToTable(FacebookResponse res) {
		Table table = new Table();
		for (FacebookResponse.Post post : res.getPosts()) {
			Map<Table.Column, String> row = new LinkedHashMap<>();
			row.put(new Table.Column("Date"), post.getPostedDate().toString());
			row.put(new Table.Column("Post"), post.getText());
			table.getData().add(row);
		}

		return table;
	}
}