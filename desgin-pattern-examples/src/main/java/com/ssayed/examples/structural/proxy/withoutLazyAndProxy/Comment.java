package com.ssayed.examples.structural.proxy.withoutLazyAndProxy;

class Comment {
	private long id;
	private String txt;
	private String commentedBy;

	public Comment(long id, String txt, String commentedBy) {
		this.id = id;
		this.txt = txt;
		this.commentedBy = commentedBy;
	}

	public long getId() {
		return id;
	}

	public String getTxt() {
		return txt;
	}

	public String getCommentedBy() {
		return commentedBy;
	}
}