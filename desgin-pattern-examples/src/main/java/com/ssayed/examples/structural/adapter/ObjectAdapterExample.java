package com.ssayed.examples.structural.adapter;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.ssayed.examples.structural.adapter.model.SocialMediaType;
import com.ssayed.examples.structural.adapter.model.Table;
import com.ssayed.examples.structural.adapter.model.Table.Column;

// client/ UI layer
public class ObjectAdapterExample {

	public static void main(String[] args) {

		UserProfileController controller = new UserProfileController();
		System.out.println("|---------------------------|");
		System.out.println("|--------- Twitter ---------|");
		System.out.println("|---------------------------|");
		Table tweetsTable = controller.getUserTweetsFromTwitter();
		renderTable(tweetsTable);

		System.out.println("|----------------------------|");
		System.out.println("|--------- Facebook ---------|");
		System.out.println("|----------------------------|");
		Table facebooktable = controller.getUserPostsFromFacebook();
		renderTable(facebooktable);
	}

	private static void renderTable(Table table) {
		for (int i = 0; i < table.getData().size(); i++) {
			Map<Column, String> row = table.getData().get(i);

			if (i == 0) {
				Iterator<Column> iterator = row.keySet().iterator();
				while (iterator.hasNext()) {
					System.out.print(iterator.next().getLabelName() + "\t\t\t\t");
				}

				System.out.println("");
				System.out.println("----------------------------------------");
			}

			for (Entry<Column, String> entry : row.entrySet()) {
				System.out.print(entry.getValue() + "\t\t");
			}

			System.out.println();
			System.out.println("----------------------------------------");
		}
	}
}

// controller layer
class UserProfileController {
	UserProfileService service = new UserProfileService();
	String loggedInUserName = "sameh";

	Table getUserTweetsFromTwitter() {
		return service.getUserTweetsFromTwitter(loggedInUserName);
	}

	Table getUserPostsFromFacebook() {
		return service.getUserPostsFromFacebook(loggedInUserName);
	}
}

// service layer
class UserProfileService {
	ActionHandler adapter = new SocialMediaAdapter();

	public Table getUserTweetsFromTwitter(String username) {
		return adapter.execute(SocialMediaType.TWITTER, username);
	}

	public Table getUserPostsFromFacebook(String username) {
		return adapter.execute(SocialMediaType.FACE_BOOK, username);
	}
}

// Target class that client expect
// Table.class

// Adapter
// SocialMediaAdapter.class

// Adaptee
// TwitterHandler.class

// Adaptee
// FacebookHandler.class