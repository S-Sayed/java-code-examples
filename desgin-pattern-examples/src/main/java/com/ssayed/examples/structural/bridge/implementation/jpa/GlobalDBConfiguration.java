package com.ssayed.examples.structural.bridge.implementation.jpa;

import java.util.HashMap;
import java.util.Map;

public class GlobalDBConfiguration {
	private static GlobalDBConfiguration globalDBConfiguration = null;
	private static Map<String, String> globalDBConfigurationMap = new HashMap<>();

	private GlobalDBConfiguration() {
	}

	public static GlobalDBConfiguration getInstance() {
		if (globalDBConfiguration == null) {
			globalDBConfiguration = new GlobalDBConfiguration();
			loadDBConfiguration();
		}

		return globalDBConfiguration;
	}

	private static void loadDBConfiguration() {
		globalDBConfigurationMap.put("MY_EC2_URL", "http://someurl.com/mymachine");
		globalDBConfigurationMap.put("MY_EC2_TOKEN", "123456789");
	}

	public static Map<String, String> getGlobalDBConfigurationMap() {
		return globalDBConfigurationMap;
	}
}