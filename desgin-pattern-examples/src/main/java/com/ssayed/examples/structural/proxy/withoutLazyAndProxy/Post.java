package com.ssayed.examples.structural.proxy.withoutLazyAndProxy;

import java.util.ArrayList;
import java.util.List;

class Post {
	private long id;
	private String txt;
	private String postedBy;
	private List<Comment> comments = new ArrayList<Comment>();

	public Post(long id, String txt, String postedBy, List<Comment> comments) {
		this.id = id;
		this.txt = txt;
		this.postedBy = postedBy;
		this.comments = comments;
	}

	public long getId() {
		return id;
	}

	public String getTxt() {
		return txt;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public List<Comment> getComments() {
		return comments;
	}
}