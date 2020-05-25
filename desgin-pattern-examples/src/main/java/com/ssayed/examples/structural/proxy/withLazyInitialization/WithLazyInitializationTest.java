package com.ssayed.examples.structural.proxy.withLazyInitialization;

public class WithLazyInitializationTest {
	public static void main(String[] args) {
		PostService postService = new PostService();
		Post post = postService.getPostDetails(1);
		// now this client of Post object will get only the post details, and will not
		// get the comments list, till he calls it, this is called lazy
		// initialization
		System.out.println("Post: " + post.getTxt() + ", by " + post.getPostedBy() + ", with "
				+ post.getComments().size() + " comments loaded on demand");
	}
}
