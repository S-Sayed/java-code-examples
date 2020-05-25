package com.ssayed.examples.structural.proxy.withoutLazyAndProxy;

public class WithoutLazyAndProxyTest {

	public static void main(String[] args) {
		PostService postService = new PostService();
		Post post = postService.getPostDetails(1);
		// now this client of Post object wants only the post details, and no need the
		// post's comments list, then why the need of loading the comments details
		// early, defer its loading till the client need it, this is called lazy
		// initialization
		System.out.println("Post: " + post.getTxt() + ", by " + post.getPostedBy() + ", with "
				+ post.getComments().size() + " comments already loaded with the post details");
	}
}