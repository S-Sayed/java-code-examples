package com.ssayed.examples.creational.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssayed.examples.creational.prototype.PrototypeRegistry.PrototypeEnum;

public class PrototypeExample {
	public static void main(String[] args) {
		News news = (News) PrototypeRegistry.getPrototype(PrototypeEnum.NEWS);
		System.out.println("Same Original: News object 1: " + news.getAllNews());

		News news2 = (News) PrototypeRegistry.getPrototype(PrototypeEnum.NEWS);
		news2.getAllNews().remove("New #4");
		System.out.println("Updated: News object 2: " + news2.getAllNews());

		News news3 = (News) PrototypeRegistry.getPrototype(PrototypeEnum.NEWS);
		System.out.println("Same Original: News object 3: " + news3.getAllNews());

		News news4 = (News) PrototypeRegistry.getPrototype(PrototypeEnum.NEWS);
		news4.getAllNews().remove("New #2");
		System.out.println("Updated: News object 4: " + news4.getAllNews());

		News news5 = (News) PrototypeRegistry.getPrototype(PrototypeEnum.NEWS);
		System.out.println("Same Original: News object 5: " + news5.getAllNews());

	}
}

class PrototypeRegistry {
	public enum PrototypeEnum {
		NEWS
	}

	private static Map<PrototypeEnum, Prototype> prototypes = new HashMap<>();

	static {
		News news = new News();
		news.setAllNews(new NewsService().loadAllNewsFromDB());
		prototypes.put(PrototypeEnum.NEWS, news);
	}

	public static Prototype getPrototype(PrototypeEnum prototypeEnum) {
		return prototypes.get(prototypeEnum).clone();
	}
}

interface Prototype {
	Prototype clone();
}

class News implements Prototype {

	private List<String> allNews = null;

	@Override
	public News clone() {
		News news = new News();
		news.allNews = new ArrayList<>(this.allNews);
		return news;
	}

	public List<String> getAllNews() {
		return allNews;
	}

	public void setAllNews(List<String> allNews) {
		this.allNews = allNews;
	}
}

class NewsService {
	List<String> loadAllNewsFromDB() {
		List<String> allNews = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			allNews.add("New #" + i);
		}
		return allNews;
	}
}