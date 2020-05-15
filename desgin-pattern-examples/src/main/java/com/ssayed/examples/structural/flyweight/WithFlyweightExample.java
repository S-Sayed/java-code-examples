package com.ssayed.examples.structural.flyweight;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// flyweight client
public class WithFlyweightExample extends JFrame {
	private static final int NO_OF_TREES = 1000;
	private static final int FRAME_SIZE = 1000;
	private static List<Tree> trees = new ArrayList<>();

	// output
	// in case NO_OF_TREES = 50000
	// 50000 trees drawn
	// --------------------------
	// Memory Usage
	// --------------------------
	// Tree object size (~8 bytes) * 50000
	// Tree type object size (~7 kiloBytes) * 3
	// --------------------------
	// Total: 0MB (instead of 342MB)

	// if you tried the same number of trees using (WithoutFlyweightExample), you
	// will get outOfMemoryException

	public static void main(String[] args) throws InterruptedException, IOException {
		Thread.currentThread().setName("Flyweight Thread");

		WithFlyweightExample example = new WithFlyweightExample();
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
		System.out.println("Tree object size (~8 bytes) * " + NO_OF_TREES);
		System.out.println("Tree type object size (~7 kiloBytes) * " + TreeTypeFactory.getTreeTypesSize());
		System.out.println("--------------------------");

		int estimatedTreeObjectSizeInByte = 8;
		int allTreeObjectsSizeinBytes = NO_OF_TREES * estimatedTreeObjectSizeInByte;
		int estimatedTreeTypeObjectSizeInByte = 7 * 1024;
		int allTreeTypeObjectsSizeInBytes = TreeTypeFactory.getTreeTypesSize() * estimatedTreeTypeObjectSizeInByte;
		int totalSizeInKiloBytes = (allTreeObjectsSizeinBytes + allTreeTypeObjectsSizeInBytes) / 1024;
		int totalSizeInMegaBytes = totalSizeInKiloBytes / 1024;

		System.out.println("Total: " + totalSizeInMegaBytes + "MB (instead of "
				+ ((NO_OF_TREES * (estimatedTreeObjectSizeInByte + estimatedTreeTypeObjectSizeInByte)) / 1024 / 1024)
				+ "MB)");
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

			trees.add(new Tree(x, y, TreeTypeFactory.getTreeType(name, color, desc, ImageIO.read(new File(iconPath)))));
		}
	}

	private static int random(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	@Override
	public void paint(Graphics g) {
		for (Tree tree : trees)
			g.drawImage(tree.getType().getImage(), tree.getX(), tree.getY(), 30, 30, null);
	}
}
