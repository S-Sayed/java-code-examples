package com.ssayed.javase.java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}

		testSequentialProcessing(l);
		testparallelProcessing(l);
		sumElementsBeforeJava8(l);
		sumElementsInJava8(l);
	}

	private static void sumElementsBeforeJava8(List<Integer> l) {
		System.out.println("sumElementsBeforeJava8");
		int sum = 0;
		for (int i : l) {
			sum += i;
		}

		System.out.println(sum);
	}

	private static void sumElementsInJava8(List<Integer> l) {
		System.out.println("sumElementsInJava8");
		System.out.print(l.stream().mapToInt(i -> i).sum());
		System.out.println();
	}

	private static void testparallelProcessing(List<Integer> l) {
		System.out.println("testparallelProcessing");
		Stream<Integer> parallel = l.parallelStream().filter(e -> e > 5);
		// parallel.forEach(e -> System.out.print(e));
		// or both will give us same result
		parallel.forEach(System.out::print); // 6879
		System.out.println();
	}

	private static void testSequentialProcessing(List<Integer> l) {
		Stream<Integer> seq = l.stream().filter(e -> e > 5);
		System.out.println("testSequentialProcessing");
		// the result will be not ordered for example 6789 unlike sequential
		seq.forEach((e) -> System.out.print(e)); // 6789
		System.out.println();
	}
}
