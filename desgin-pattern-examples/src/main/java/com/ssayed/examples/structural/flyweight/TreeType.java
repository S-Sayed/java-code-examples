package com.ssayed.examples.structural.flyweight;

// flyweight Object that has common/ repeated data (intrinsic states) over all objects
import java.awt.Color;
import java.awt.image.BufferedImage;

public class TreeType {

	private String name; // 8b
	private Color color; // 8b
	private String description; // 8b
	private BufferedImage image; // 6kb

	public TreeType(String name, Color color, String description, BufferedImage image) {
		this.name = name;
		this.color = color;
		this.description = description;
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public Color getColor() {
		return color;
	}

	public BufferedImage getImage() {
		return image;
	}
}
