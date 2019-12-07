package com.ssayed.javase.java8features;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFeaturesExample {

	public static void main(String[] args) {
		StreamFeaturesExample s = new StreamFeaturesExample();

		s.testSequentialProcessing();
		s.testparallelProcessing();
		s.sumElementsBeforeJava8();
		s.sumElementsInJava8();
		s.generateStream();
		s.generateInfiniteStream();
		s.convertStreamToCollection();
		s.convertStreamToArray();
		s.testIntermediateOperations();
		s.testTerminalOperations();
	}

	private void testTerminalOperations() {
		testReduce();
		testCount();
		testForEach();
		testMatch();
		testFind();
	}

	private void testFind() {
		System.out.println("\n testFind");
		Optional<Integer> result = Stream.of(1, 2, 3, 4).filter(e -> e > 4).findAny();
		System.out.println("find any element match > 4: " + (result.isPresent() ? result.get() : " No"));

		result = Stream.of(1, 2, 3, 4).filter(e -> e == 4).findFirst();
		System.out.println("find any element match = 4: " + (result.isPresent() ? result.get() : " No"));
	}

	private void testMatch() {
		System.out.println("\n testMatch");
		// true
		System.out.println("any element match = 4: " + Stream.of(1, 2, 3, 4).anyMatch(e -> e == 4));
		// true
		System.out.println("all element match < 5: " + Stream.of(1, 2, 3, 4).allMatch(e -> e < 5));
		// false
		System.out.println("no element match > 5: " + Stream.of(1, 2, 3, 4).allMatch(e -> e > 5));
	}

	private void testForEach() {
		System.out.println("\n testForEach");
		Stream.of(1, 2, 3, 4).forEach(e -> System.out.println(e));
	}

	private void testCount() {
		System.out.println("\n testCount");
		System.out.println(Stream.of(1, 2, 3, 4).count());
	}

	private void testReduce() {
		System.out.println("\n testReduce");
		Optional<Integer> result = Stream.of(1, 2, 3, 4).reduce((i, j) -> i * j);
		System.out.println(result.isPresent() ? result.get() : "0");
	}

	private void testIntermediateOperations() {
		testFilter();
		testMap();
		testSorted();
		testReverseSorted();
		testSortedUsingComparator();
	}

	private void testSortedUsingComparator() {
		System.out.println("\n testSortedUsingComparator");
		// 2a b3 22 2h 1 >> custom sorting code using comparator
		Stream.of("1", "2a", "b3", "22", "2h").sorted(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		}).forEach(e -> System.out.print(e + " "));

	}

	private void testReverseSorted() {
		System.out.println("\n testReverseSorted in the reverse of natural order");
		// b3 2h 2a 22 1 >> the reverse of natural order
		Stream.of("1", "2a", "b3", "22", "2h").sorted(Comparator.reverseOrder())
				.forEach(e -> System.out.print(e + " "));
	}

	private void testSorted() {
		System.out.println("\ntestSorted in natural order");
		// 1 22 2a 2h b3 >> natural order
		Stream.of("1", "2a", "b3", "22", "2h").sorted().forEach(e -> System.out.print(e + " "));

	}

	private void testFilter() {
		System.out.println("\ntestFilter");
		Stream<String> ss = Stream.of("1", "2a", "b3", "22", "2h");
		// 2a 22 2h
		ss.filter(e -> e.startsWith("2")).forEach(e -> System.out.print(e + " "));

	}

	private void testMap() {
		System.out.println("\ntestMap");
		Stream<String> ss = Stream.of("1", "2a", "b3", "22", "2h");
		// 1 2A B3 22 2H
		ss.map(e -> e.toUpperCase()).forEach(e -> System.out.print(e + " "));

	}

	private void convertStreamToArray() {
		System.out.println("\nconvertStreamToArray");
		Stream<Integer> is = Stream.of(1, 2, 3);
		Integer[] i = is.toArray(Integer[]::new);
		System.out.println(Arrays.toString(i)); // [1, 2, 3]
	}

	private void convertStreamToCollection() {
		System.out.println("\nconvertStreamToCollection");
		Stream<Integer> is = Stream.of(1, 2, 3);
		List<Integer> li = is.collect(Collectors.toList());
		System.out.println(li); // [1, 2, 3]

	}

	private void generateInfiniteStream() {
		System.out.println("\ngenerateInfiniteStream using generator and limit");

		// generate infinite stream and limit it using limit method
		// generate > re-execute its logic on every iteration

		// abc abc abc abc abc
		Stream.generate(() -> {
			return "abc";
		}).limit(5).forEach(i -> System.out.print(i + " "));

		// 5 8 6 3 5
		Stream<Integer> si3 = Stream.generate(() -> new Random().nextInt(11)).limit(5);
		si3.forEach(i -> System.out.print(i + " "));

		System.out.println("\ngenerateInfiniteStream using iterate and limit");
		// working as function of operation in math f(x)
		// 2 4 16 256 65536
		// seed-value is 2 then do f(2) the f(f(2)) or f(2*2) then f(f(f(2))) or f(4*4)
		// and so on
		Stream<Integer> si4 = Stream.iterate(2, i -> i * i).limit(5);
		si4.forEach(i -> System.out.print(i + " "));
	}

	private void generateStream() {
		Stream<Integer> s = Stream.of(1, 2, 3, 4);
		System.out.println(s); // you will get the stream pipleline memory reference
		System.out.println("generateStream of integers");
		s.forEach(i -> System.out.print(i));

		Stream<Integer> sa = Stream.of(new Integer[] { 1, 2, 3, 4 });
		// stream is not working with primitive data type directly
		// Stream.of(new int[]{1,2,3,4}); // compile time error
		// Stream.of({1,2,3,4}); // compile time error
		// instead, you can do the following
		System.out.println("\n generateStream from array of integers");
		// IntStream is = Arrays.stream(new int[] {1,2,3,5,8,7});
		int[] arr = { 8, 9, 7, 50 };
		IntStream is = Arrays.stream(arr);
		is.forEach(i -> System.out.print(i + " "));
	}

	private void sumElementsBeforeJava8() {
		System.out.println("\n sumElementsBeforeJava8");
		List<Integer> l = generateArrayList();
		int sum = 0;
		for (int i : l) {
			sum += i;
		}

		System.out.println(sum);
	}

	private List<Integer> generateArrayList() {
		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(i);
		}
		return l;
	}

	private void sumElementsInJava8() {
		System.out.println("\n sumElementsInJava8");
		List<Integer> l = generateArrayList();
		System.out.print(l.stream().mapToInt(i -> i).sum());
		System.out.println();
	}

	private void testparallelProcessing() {
		System.out.println("\n testparallelProcessing");
		List<Integer> l = generateArrayList();
		Stream<Integer> parallel = l.parallelStream();
		// parallel.forEach(e -> System.out.print(e));
		// or both will give us same result
		parallel.forEach(System.out::println); // 6 5 2 1 8 4 9 3 7 0
		System.out.println();
	}

	private void testSequentialProcessing() {
		System.out.println("\n testSequentialProcessing");
		List<Integer> l = generateArrayList();
		Stream<Integer> seq = l.stream();
		// the result will be not ordered for example 6789 unlike sequential
		seq.forEach((e) -> System.out.println(e)); // 0 1 2 3 4 5 6 7 8 9
		System.out.println();
	}
}
