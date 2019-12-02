package com.ssayed.javase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class CollectionExampleInJava7 {

	public static void main(String[] args) {
		CollectionExampleInJava7 t = new CollectionExampleInJava7();
		t.testQueue();
		t.testList();
		t.testHashSet();
		t.testSortedSet();
		t.testSortedMap();
		t.testTreeSet();
		t.testLinkedList();
		t.testMap();
		t.testTreeMap();
		t.testPriorityQueue();
		t.testUnmodifiableList();
		t.testCollectionSort();
		t.testCollectionSearch();
		t.testCollectionFrequency();
		t.testCollectionDisjoint();
		t.testCollectionMinMax();
	}

	private void testCollectionMinMax() {
		List<String> l = new ArrayList<>();
		l.add("Sameh");
		l.add("Yasmin");
		l.add("Sila");
		l.add("Adam");
		l.add("Sila");

		System.out.println(Collections.min(l)); // min string length "Adam"
		System.out.println(Collections.max(l)); // max string length "Yasmin"

		List<Integer> al = new ArrayList<>();
		al.add(10);
		al.add(-10);
		al.add(3);

		System.out.println(Collections.min(al)); // min number "-10"
		System.out.println(Collections.max(al)); // max number "10"

	}

	private void testCollectionFrequency() {
		List<String> l = new ArrayList<>();
		l.add("Sameh");
		l.add("Yasmin");
		l.add("Sila");
		l.add("Adam");
		l.add("Sila");

		System.out.println(Collections.frequency(l, "Sila")); // 2
	}

	private void testCollectionDisjoint() {
		List<String> l = new ArrayList<>();
		l.add("Sameh");
		l.add("Yasmin");
		l.add("Sila");
		l.add("Adam");
		l.add("Sila");

		List<String> l2 = new ArrayList<>();
		l2.add("Sameh1"); // true
		// l2.add("Sameh"); // false

		System.out.println(Collections.disjoint(l, l2));
	}

	private void testCollectionSort() {
		List<String> l = new ArrayList<>();
		l.add("Sameh");
		l.add("Yasmin");
		l.add("Sila");
		l.add("Adam");

		System.out.println("Before: ");
		System.out.println(l); // [Sameh, Yasmin, Sila, Adam]

		System.out.println("After Without Comparator: ");
		Collections.sort(l); // [Adam, Sameh, Sila, Yasmin]
		System.out.println(l);

		// using comparator
		// sort by the names with the smallest length first
		Collections.sort(l, (s1, s2) -> s1.length() - s2.length());
		System.out.println("After With Comparator: ");
		System.out.println(l); // [Adam, Sila, Sameh, Yasmin]

	}

	private void testCollectionSearch() {
		List<String> l = new ArrayList<>();
		l.add("Sameh");
		l.add("Yasmin");
		l.add("Sila");
		l.add("Adam");

		System.out.println("Not Sorted");
		// -1 as the list should be sorted first in the asc order
		System.out.println(Collections.binarySearch(l, "Adam"));

		System.out.println("Not Sorted by Comparator");
		// using comparator
		// sort by the names with the smallest length first
		// -1 as the list should be sorted first in the asc order
		System.out.println(Collections.binarySearch(l, "Adam", (s1, s2) -> s1.length() - s2.length()));

		System.out.println("Sorted");
		Collections.sort(l);
		// will return the index 0 as the list is sorted
		System.out.println(Collections.binarySearch(l, "Adam"));

		System.out.println("Sorted by Comparator");
		// using comparator
		// sort by the names with the smallest length first
		// will return the index 0 as the list is sorted
		System.out.println(Collections.binarySearch(l, "Adam", (s1, s2) -> s1.length() - s2.length()));

	}

	private void testUnmodifiableList() {
		List<String> l = new ArrayList<>();
		l.add("Cat1");
		l.add("Cat2");
		l = Collections.unmodifiableList(l);

		// [Cat1, Cat2]
		System.out.println(l);
		// l.add("Cat3"); // java.lang.UnsupportedOperationException
	}

	private void testPriorityQueue() {
		// with their natural order
		PriorityQueue<String> q = new PriorityQueue<>();
		q.add("B");
		q.add("C");
		q.add("D");
		q.add("A");
		// q.add(null); // not allowed
		// [A, B, D, C] no guarantee the order without loop
		System.out.println(q);
		System.out.println(q.peek()); // A

		// A, B, C, D > guarantee the order with loop
		while (!q.isEmpty()) {
			System.out.println(q.remove());
		}

		// with custom comparator
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1; // sort DESC
				// return o1 - o2; // sort ASC
			}
		};

		PriorityQueue<Integer> pq = new PriorityQueue<>(c);
		pq.add(-5);
		pq.add(1);
		pq.add(5);
		pq.add(2);

		// [5, 2, 1, -5] guarantee the order without loop
		System.out.println(pq);
		System.out.println(pq.peek()); // 5

		// 5, 2, 1, -5 > guarantee the order with loop
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}

	}

	private void testTreeMap() {
		Map<Integer, String> m = new TreeMap<>();
		m.put(3, "Adam");
		m.put(1, "Sameh");
		m.put(2, "Sila");
		// m.put(null, "Minna"); // null not allowed in the sorted/tree map
		m.put(7, null);

		// {1=Sameh, 2=Sila, 3=Adam, 7=null}
		System.out.println(m);
	}

	private void testMap() {
		Map<Integer, String> m = new HashMap<>();
		m.put(3, "Adam");
		m.put(1, "Sameh");
		m.put(2, "Sila");
		m.put(null, "Minna");
		m.put(6, null);

		// {null=Minna, 1=Sameh, 2=Sila, 3=Adam, 4=null}
		System.out.println(m);
	}

	private void testLinkedList() {
		LinkedList<String> s = new LinkedList<>();
		s.add("A");
		s.add("B");
		s.addFirst("1");
		s.addLast("2");

		System.out.println(s); // [1, A, B, 2]
		// get method in the List interface is doing the loop on linked list
		// nodes
		System.out.println(s.get(1)); // A

	}

	private void testTreeSet() {
		// Without Comparator
		TreeSet<String> s = new TreeSet<>();
		s.add("Sila");
		s.add("Adam2");
		s.add("Sameh");
		s.add("Yasmin");

		// ASC order > [Adam2, Sameh, Sila, Yasmin]
		System.out.println(s);

		// With Comparator
		// < java 8
		s = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}

		});

		// >= java 8
		// s = new TreeSet<>((s1, s2) -> s1.length() - s2.length());

		// s1 > s2 --> 1
		// s1 < s2 --> -1
		// s1 = s2 --> 0 means don't add into the set

		s.add("Sila");
		s.add("Adam2");
		s.add("Sameh"); // not added to the list, check why
		s.add("Yasmin");

		// [Sila, Adam2, Yasmin]
		System.out.println(s);

	}

	private void testHashSet() {
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(40);
		s.add(21);
		// not maintain the iteration/insertion order
		System.out.println(s); // [40, 1, 2, 3, 21]
	}

	private void testSortedSet() {
		SortedSet<Integer> s = new TreeSet<>();
		s.add(5);
		s.add(3);
		s.add(4);
		s.add(7);
		s.add(3); // no duplicate values

		System.out.println(s); // 3 4 5 7 > sorted ASC
		System.out.println(s.first()); // 3
		System.out.println(s.last()); // 7

		// sub set from the passed element till the end/ tail
		System.out.println(s.tailSet(4));
		// sub set from the head till the element before passed element
		// (means the passed element is exclusive)
		System.out.println(s.headSet(4));
		// sub set from the head till the element before passed element
		// means the passed element is exclusive)
		System.out.println(s.subSet(3, 5));
	}

	private void testSortedMap() {
		SortedMap<Integer, String> sm = new TreeMap<>();
		sm.put(4, "1");
		sm.put(3, "2");
		sm.put(2, "3");
		sm.put(1, "4");
		sm.put(1, "5"); // will override the existing one

		System.out.println(sm); // {1=5, 2=3, 3=2, 4=1}
	}

	private void testList() {
		List<String> s = new ArrayList<>();
		// not working as the list is empty and maintain the insertion order
		// s.add(1,"B1");

		s.add(0, "B0"); // || s.add("A"); - working
		// s.add(2,"B2"); // not working as the list has element in index ZERO
		// and maintain the insertion order, so the next should be in index 1

		// working because the list maintains the insertion order
		s.add(1, "B1");
		s.set(1, "B1-Updated");
		s.add("A");

		// before sort: s -> [B0, B1-Updated, A]
		Collections.sort(s); // after sort: s -> [A, B0, B1-Updated] -> sorted

		// if the list not sorted, and the element is there in the list, it
		// return always -1
		System.out.println(Collections.binarySearch(s, "A"));

		Collections.shuffle(s); // random the order of the elements in the list
								// regardless
								// sorted or not
		System.out.println(s); // shuffle > [B0, B1-Updated, A]

		Collections.reverse(s);
		System.out.println(s); // reverse > [A, B1-Updated, B0]

		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");

		System.out.println("listiterator forward : ");
		ListIterator<String> li = list.listIterator();

		while (li.hasNext()) {
			System.out.println(li.next());
		} // A, B, C

		System.out.println("listiterator reverse : ");
		li = list.listIterator(s.size());

		while (li.hasPrevious()) {
			System.out.println(li.previous());
		} // C, B, A
	}

	private void testQueue() {
		Queue<Integer> q = new LinkedList<>();

		// throws NoSuchElementException, if the queue is empty
		// System.out.println(q.element());

		System.out.println(q.peek()); // return null , if the queue is empty

		// return the head element of the queue then remove it, if the queue is
		// not empty, else throw exception NoSuchElementException
		// System.out.println(q.remove());

		for (int i = 0; i < 5; i++)
			q.add(i);

		System.out.println(q);

		// createThreadToAddElementToQueue(q);

		// java.util.ConcurrentModificationException, if above thread started
		for (int x : q) {
			System.out.println(q.contains(x));

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// java.util.ConcurrentModificationException, if above thread started
		Iterator i = q.iterator();
		while (i.hasNext()) {
			Integer n = (Integer) i.next();
			System.out.println(q.contains(n));

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// CALL method from Collection interface
		System.out.println(q.size());

		// to get the head element of the queue then remove it, return null if
		// the queue is empty
		System.out.println(q.poll());

		System.out.println(q);

		// return the head element of the queue, if the queue is not empty
		System.out.println(q.element());

		// return the head element of the queue, if the queue is not empty
		System.out.println(q.peek());

		System.out.println(q.remove());

		System.out.println(q);
	}

	private void createThreadToAddElementToQueue(Queue<Integer> q) {
		new Thread(() -> {
			int i = 1;
			while (i < 10) {
				System.out.println("Thread " + Thread.currentThread().getName());
				q.add(5);
				i++;
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}
}
