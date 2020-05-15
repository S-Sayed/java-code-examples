package com.ssayed.examples.structural.flyweight;

// context Object that has unique data / extrinsic states
public class Tree {
	private int x; // 4b
	private int y; // 4b
	private TreeType type;

	public Tree(int x, int y, TreeType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public TreeType getType() {
		return type;
	}
}
