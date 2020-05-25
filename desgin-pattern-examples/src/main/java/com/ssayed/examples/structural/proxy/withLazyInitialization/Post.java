package com.ssayed.examples.structural.proxy.withLazyInitialization;

import java.util.List;

class Post {
	private long id = 60_000;
	private String txt;
	private String postedBy;
	private List<Comment> comments = null;

	public Post(long id, String txt, String postedBy) {
		this.id = id;
		this.txt = txt;
		this.postedBy = postedBy;
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
		if (comments == null) {
			System.out.println("Loading comments for post with id " + this.id);
			comments = new PostService().getCommentsByPostId(this.id);
		}

		return comments;
	}
}