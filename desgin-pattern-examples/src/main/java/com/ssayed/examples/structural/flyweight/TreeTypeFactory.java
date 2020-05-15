package com.ssayed.examples.structural.flyweight;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

// flyweight factory that control the flweight objects
public class TreeTypeFactory {

	private static Map<String, TreeType> treeTypes = new HashMap<>();

	public static TreeType getTreeType(String name, Color color, String description, BufferedImage image) {
		TreeType type = treeTypes.get(name);

		if (type == null) {
			type = new TreeType(name, color, description, image);
			treeTypes.put(name, type);
		}

		return type;
	}

	public static int getTreeTypesSize() {
		return treeTypes.size();
	}
}
