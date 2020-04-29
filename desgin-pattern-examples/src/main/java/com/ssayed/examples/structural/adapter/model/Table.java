package com.ssayed.examples.structural.adapter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
	List<Map<Column, String>> data = new ArrayList<>();

	public List<Map<Column, String>> getData() {
		return data;
	}

	public static class Column {
		private String labelName;

		public Column(String labelName) {
			this.labelName = labelName;
		}

		public String getLabelName() {
			return labelName;
		}

		@Override
		public boolean equals(Object obj) {
			return labelName.equals(((Column) obj).getLabelName());
		}

		@Override
		public String toString() {
			return labelName;
		}
	}
}
