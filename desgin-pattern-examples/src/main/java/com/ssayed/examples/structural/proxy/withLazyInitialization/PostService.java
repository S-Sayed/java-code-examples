package com.ssayed.examples.structural.proxy.withLazyInitialization;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PostService {
	Post getPostDetails(long id) {
		// String query = "SELECT * FROM POST WHERE ID = " + id;
		Post post = new Post(id, "Hello world", "SAMEH");
		return post;
	}

	List<Comment> getCommentsByPostId(long postId) {
		// mock the result
		List<Comment> comments = Stream.of(new Comment(11, "COMMENT_1", "ADAM"), new Comment(12, "COMMENT_2", "YASMIN"),
				new Comment(13, "COMMENT_3", "SILA")).collect(Collectors.toList());

		return comments;
	}
}