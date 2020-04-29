package com.ssayed.examples.creational.singleton;

import java.util.Arrays;
import java.util.List;

public class SingletonExample {

	public static void main(String[] args) {
		// will not be initialize as it is not being used
		// GlobalConfiguration config = null;
		System.out.println("1- Instance memory address: " + GlobalConfiguration.getInstance().hashCode());
		GlobalConfiguration config = GlobalConfiguration.getInstance();
		System.out
				.println("2- Instance memory address: " + config.hashCode() + ", countries: " + config.getCountries());
		config = GlobalConfiguration.getInstance();
		System.out
				.println("3- Instance memory address: " + config.hashCode() + ", languages: " + config.getLanguages());
		
		// output
		// ............. Loading Configuration .............
		// 1- Instance memory address: 118352462
		// 2- Instance memory address: 118352462, countries: [EGYPT, UAE, KSA]
		// 3- Instance memory address: 118352462, languages: [Arabic, English, French]

	}
}

class GlobalConfiguration {
	private static GlobalConfiguration config = null;
	private List<String> countries = null;
	private List<String> languages = null;

	private GlobalConfiguration() {
	}

	public static GlobalConfiguration getInstance() {
		if (config == null) {
			config = new GlobalConfiguration();
			config.loadConfiguration();
		}

		return config;
	}

	public void loadConfiguration() {
		System.out.println("............. Loading Configuration .............");
		countries = Arrays.asList("EGYPT", "UAE", "KSA");
		languages = Arrays.asList("Arabic", "English", "French");
		// and more
	}

	public List<String> getCountries() {
		return countries;
	}

	public List<String> getLanguages() {
		return languages;
	}
}