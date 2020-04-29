package com.ssayed.javase.equalAndHash;

import java.util.ArrayList;
import java.util.List;

public class EqualAndHashCodeExample2 {

	public static void main(String[] args) {
		String str1 = "Sameh";
		String str2 = str1;
		String str3 = "Sameh";
		System.out.println(str1.hashCode() == str2.hashCode()); // true
		System.out.println(str1.hashCode() == str3.hashCode()); // true

		Student student1 = new Student(1, "Sameh");
		Student student2 = student1;
		Student student3 = new Student(1, "Sameh");
		System.out.println(student1.hashCode() == student2.hashCode()); // true
		System.out.println(student1.hashCode() == student3.hashCode()); // false
		System.out.println(student1.name.hashCode() == str1.hashCode()); // true
		System.out.println(student1.id.hashCode() == student2.id.hashCode()); // true
		System.out.println(student1.id.hashCode() == student3.id.hashCode()); // true

		List<Student> list1 = new ArrayList<>();
		list1.add(student1);
		list1.add(student2);
		list1.add(student3);

		List<Student> list2 = list1;
		list2.add(new Student(1, "Sameh"));
		System.out.println(list1.hashCode() == list2.hashCode()); // true
		System.out.println(list1.get(0).hashCode() == list2.get(0).hashCode()); // true
		System.out.println(list1.get(0).hashCode() == list2.get(3).hashCode()); // false
		System.out.println(list1.get(0).name.hashCode() == list2.get(3).name.hashCode()); // true
		System.out.println(list1.get(0).id.hashCode() == list2.get(3).id.hashCode()); // true
		System.out.println(list1.get(0).id == list2.get(3).id); // true

		List<Student> list3 = new ArrayList<>(list1);
		System.out.println(list3.get(0).hashCode() == list1.get(0).hashCode()); // true

		// the value of hashcode of any variable of primitive's wrappers is the value
		// itself
		// but String and user-defined objects and any other object has memory address
		// calculated by JVM/ your hashcode implementation
		// 5, 79649954
		System.out.println(new Integer(5).hashCode() + ", " + "Sameh".hashCode());
	}

	public static class Student {
		Integer id;
		String name;

		Student(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}
}
