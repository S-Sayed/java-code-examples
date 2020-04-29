package com.ssayed.javase.equalAndHash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EqualsAndHashCodeExample {

	public static void main(String[] args) {
		testNull();

		StudentWithoutEqualsAndHashCode s = new StudentWithoutEqualsAndHashCode();

		// object memory address =
		// com.ssayed.javase.StudentWithoutHashCode@7852e922,
		// and its hash code =2018699554

		System.out.println("\nstudent with default hashcode implementation, object memory address = " + s
				+ ", and its hash code =" + s.hashCode());

		StudentWithEqualsAndHashCode s1 = new StudentWithEqualsAndHashCode();
		StudentWithEqualsAndHashCode s2 = new StudentWithEqualsAndHashCode();

		System.out.println("\nstudent with custom hashcode implementation");
		System.out.println("s1 hash code =" + s1.hashCode()); // 0
		System.out.println("s2 hash code =" + s2.hashCode()); // 0

		System.out.println("\nbefore populating");
		// here if they are referring to the same memory location
		System.out.println(s1 == s2); // false
		System.out.println(s1.hashCode() == s2.hashCode()); // true

		// s1 and s2 are completely different objects so the JVM will check the
		// equals method implementation, if there is no implementation, will
		// always return false even if they have the same data members values
		System.out.println(s1.equals(s2)); // true

		s1 = new StudentWithEqualsAndHashCode(1, "Sameh");
		s2 = new StudentWithEqualsAndHashCode(1, "Sameh");

		System.out.println("\nafter populating");
		// compare references not equals implementation
		System.out.println(s1 == s2); // false
		System.out.println(s1.hashCode() == s2.hashCode()); // true
		// it is called "deep comparison"
		System.out.println(s1.equals(s2)); // true

		// s3 refer to the same object in s1, so they are equal and referring to
		// the same memory location
		// it is called "shallow comparison"
		StudentWithEqualsAndHashCode s3 = s1;
		System.out.println(s3 == s1); // true
		System.out.println(s3.hashCode() == s1.hashCode()); // true
		System.out.println(s3.equals(s1)); // true

		testArrayList();
		testSet();
	}

	private static void testSet() {
		System.out.println("Test Set");

		Set<StudentWithoutEqualsAndHashCode> set = new HashSet<>();
		set.add(new StudentWithoutEqualsAndHashCode(1, "Sameh"));
		// false because there is no hashcode implementation
		System.out.println(set.contains(new StudentWithoutEqualsAndHashCode(1, "Sameh")));

		Set<StudentWithEqualsAndHashCode> set1 = new HashSet<>();
		set1.add(new StudentWithEqualsAndHashCode(1, "Sameh"));
		// true because there is hashcode implementation
		System.out.println(set1.contains(new StudentWithEqualsAndHashCode(1, "Sameh")));
	}

	private static void testArrayList() {
		System.out.println("Test ArrayList");

		List<StudentWithoutEqualsAndHashCode> l = new ArrayList<>();
		l.add(new StudentWithoutEqualsAndHashCode(1, "Sameh"));
		// false because there is no equals implementation
		System.out.println(l.contains(new StudentWithoutEqualsAndHashCode(1, "Sameh")));

		List<StudentWithEqualsAndHashCode> ll = new ArrayList<>();
		ll.add(new StudentWithEqualsAndHashCode(1, "Sameh"));
		// true because there is equals implementation
		System.out.println(ll.contains(new StudentWithEqualsAndHashCode(1, "Sameh")));
	}

	private static void testNull() {
		System.out.println("null == null ========>> " + (null == null));
		System.out.println("null == Hi ========>> " + (null == "Hi"));
		System.out.println("Hi == Hi ========>> " + ("Hi" == "Hi"));
		System.out.println("Hi == null ========>>" + ("Hi" == null));

	}
}

class StudentWithEqualsAndHashCode {
	private int id;
	private String name;

	StudentWithEqualsAndHashCode() {
	}

	StudentWithEqualsAndHashCode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		// check if two objects are from the same type
		// if(!(obj instanceof Student)) return false; ---> so avoid it because
		// may be someone will pass subclass of it
		if (obj == null || this.getClass() != obj.getClass())
			return false;

		// check if two objects references refer to the same object (has the
		// same memory location), ex
		// Student s1 = new Student(1, "Adam");
		// Student s3 = s1;
		// so s3 == s1 are true
		if (this == obj)
			return true;

		StudentWithEqualsAndHashCode s = (StudentWithEqualsAndHashCode) obj;

		if (id == s.id && name == s.name) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return id; // return id for testing purpose
	}
}

class StudentWithoutEqualsAndHashCode {

	private int id;
	private String name;

	StudentWithoutEqualsAndHashCode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public StudentWithoutEqualsAndHashCode() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
