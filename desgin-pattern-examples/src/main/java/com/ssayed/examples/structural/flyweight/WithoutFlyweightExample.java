package com.ssayed.examples.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class WithoutFlyweightExample extends JFrame {
	private static final int NO_OF_TREES = 1000;
	private static final int FRAME_SIZE = 1000;
	private static List<Tree> trees = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Thread.currentThread().setName("Without-Flyweight Thread");

		WithoutFlyweightExample example = new WithoutFlyweightExample();
		example.createDummyTrees();

		example.setSize(FRAME_SIZE, FRAME_SIZE);
		example.setVisible(true);
		example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		example.displayEstimatedMemoryInfo();
	}

	private void displayEstimatedMemoryInfo() {
		System.out.println(NO_OF_TREES + " trees drawn");
		System.out.println("--------------------------");
		System.out.println("Memory Usage");
		System.out.println("--------------------------");
		System.out.println(
				"Tree object size (~7 kiloBytes) * " + NO_OF_TREES + " = " + ((NO_OF_TREES * 7) / 1024) + "MB");
	}

	private void createDummyTrees() throws IOException {
		for (int i = 0; i < NO_OF_TREES; i++) {
			int randNumber = random(1, 3);
			int x = random(10, FRAME_SIZE);
			int y = random(10, FRAME_SIZE);
			String name = "Tree_" + randNumber;
			String desc = "TreeDesc_" + randNumber;
			Color color = i % 2 == 0 ? Color.green : Color.yellow;

			String iconPath = ".\\src\\main\\java\\com\\ssayed\\examples\\structural\\flyweight\\icons\\tree"
					+ randNumber + ".png";

			trees.add(new Tree(x, y, name, color, desc, ImageIO.read(new File(iconPath))));
		}
	}

	private static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	@Override
	public void paint(Graphics g) {
		for (Tree tree : trees)
			g.drawImage(tree.getImage(), tree.getX(), tree.getY(), 30, 30, null);
	}

	public static class Tree {
		private int x; // 4b
		private int y; // 4b
		private String name; // 8b
		private Color color; // 8b
		private String description; // 8b
		private BufferedImage image = null; // ~6KB

		// total = ~8KB

		public Tree(int x, int y, String name, Color color, String description, BufferedImage image) {
			this.x = x;
			this.y = y;
			this.name = name;
			this.color = color;
			this.description = description;
			this.image = image;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public String getName() {
			return name;
		}

		public Color getColor() {
			return color;
		}

		public String getDescription() {
			return description;
		}

		public BufferedImage getImage() {
			return image;
		}
	}
}
