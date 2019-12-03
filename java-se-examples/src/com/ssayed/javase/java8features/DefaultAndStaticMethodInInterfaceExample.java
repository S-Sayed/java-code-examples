package com.ssayed.javase.java8features;

public class DefaultAndStaticMethodInInterfaceExample {

	public static void main(String[] args) {

		Interface1Impl i1 = new Interface1Impl();
		i1.mehtod1();
		i1.log("Test");

		Interface1And2Impl i = new Interface1And2Impl();
		i.mehtod1();
		i.mehtod2();
		i.log("Test");
	}
}

class Interface1Impl implements Interface1 {
	@Override
	public void mehtod1() {
		System.out.println("Interface1Impl - Method 1");
	}

	// no issue if you didn't override this method as it has default logic
	// @Override
	// public void log(String msg) {
	// System.out.println("Interface1Impl - Overridden Log: " + msg);
	// }
}

class Interface1And2Impl implements Interface1, Interface2 {
	@Override
	public void mehtod2() {
		System.out.println("Interface1And2Impl - Method 2");
	}

	@Override
	public void mehtod1() {
		System.out.println("Interface1And2Impl - Method 1");
	}

	// the code will not compile till you provide implementation of the log
	// method as it is there in the both interfaces
	@Override
	public void log(String msg) {
		System.out.println("Interface1And2Impl - Overridden Log: " + msg);
	}
}

@FunctionalInterface
interface Interface1 {

	void mehtod1(); // public abstract

	// default/ static keyword should be there as Functional interface
	// annotation will check them

	// no need to provide implementation in the implementation classes if it is
	// only one method with the same signature in the inheritance hierarchy
	default void log(String msg) {
		if (isNotNull(msg)) {
			System.out.println("interface1 - Default Log: " + msg);
		}
	}

	// to serve the default methods in the interface as utility methods and
	// avoid the poor logic form the implementation classes
	static boolean isNotNull(String msg) {
		System.out.println("Interface1 - Checking Null");
		return msg != null && !("".equals(msg));
	}
}

@FunctionalInterface
interface Interface2 {

	void mehtod2(); // public abstract

	default void log(String msg) {
		System.out.println("interface2 - Default Log: " + msg);
	}
}