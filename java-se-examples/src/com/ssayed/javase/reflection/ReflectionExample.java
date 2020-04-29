package com.ssayed.javase.reflection;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

public class ReflectionExample {

	enum ClassRetrivalBy {
		FOR_NAME, NEW_KEYWORD, DOT_CLASS;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		displayClassMetaData();
		displayClassFieldsMetaData();
		displayClassMethodsMetadata();
		displayClassConstructorsMetadata();
		createInstanceOfStudent();
		invokeMethodFromStudent();
	}

	@SuppressWarnings("unchecked")
	private static void invokeMethodFromStudent() throws ClassNotFoundException {
		System.out.println("invokeMethodFromStudent - START");

		try {
			Class studentClass = getStudentClassBy(ClassRetrivalBy.FOR_NAME);
			Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
			Student student = (Student) studentClass.newInstance();
			setNameMethod.invoke(student, "SAMEH ELSAYED");
			System.out.println(student.getClass().getDeclaredMethod("getName").invoke(student));
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("invokeMethodFromStudent - END \n");
	}

	@SuppressWarnings("unchecked")
	private static void createInstanceOfStudent() throws ClassNotFoundException {
		System.out.println("createInstanceOfStudent - START");

		try {
			Class studentClass = getStudentClassBy(ClassRetrivalBy.FOR_NAME);
			Constructor<Student> studentConstructor = studentClass.getConstructor(Integer.class, String.class);
			Student studnet = studentConstructor.newInstance(1, "SAMEH");
			System.out.println(studnet.getName());

			studnet = Student.class.newInstance();
			studnet.setName("ADAM");
			System.out.println(studnet.getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("createInstanceOfStudent - END \n");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void displayClassConstructorsMetadata() throws ClassNotFoundException {
		System.out.println("displayClassConstructorsMetadata - START");
		Class studentClass = getStudentClassBy(ClassRetrivalBy.FOR_NAME);

		try {
			System.out.println(
					"constructor name is " + studentClass.getConstructor(Integer.class, String.class).getName());

			System.out.println("getDeclaredConstructors");
			Constructor[] constructors = studentClass.getConstructors();

			for (Constructor constructor : constructors) {
				System.out.println("constructor name is " + constructor.getName());
				System.out.println("constructor modifiers are " + Modifier.toString(constructor.getModifiers()));

				System.out.println("getParameters");
				Parameter[] parameters = constructor.getParameters();
				for (Parameter parameter : parameters) {
					System.out.println("constructor's parameter name is " + parameter.getName());
					System.out.println("constructor's parameter data type is " + parameter.getType().getName());
					System.out.println(
							"constructor's parameter modifiers are " + Modifier.toString(parameter.getModifiers()));
				}

				System.out.println("getParameterTypes");
				Class[] parameterTypes = constructor.getParameterTypes();
				for (Class parameter : parameterTypes) {
					System.out.println("constructor's parameter data type is " + parameter.getName());
					System.out.println(
							"constructor's parameter modifiers are " + Modifier.toString(parameter.getModifiers()));
				}

				System.out.println("getExceptionTypes");
				Class[] exceptions = constructor.getExceptionTypes();
				for (Class exception : exceptions) {
					System.out.println("constructor's declared exception is " + exception.getName());
				}

				System.out.println("-------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("displayClassConstructorsMetadata - END");
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void displayClassMethodsMetadata() throws ClassNotFoundException {
		System.out.println("displayClassMethodsMetadata - START");
		Class studentClass = getStudentClassBy(ClassRetrivalBy.DOT_CLASS);

		try {
			System.out.println("return type of displayData method is "
					+ studentClass.getDeclaredMethod("displayData").getReturnType().getName());

			System.out.println("getDeclaredMethods");
			Method[] methods = studentClass.getDeclaredMethods();

			for (Method method : methods) {
				System.out.println("method name is " + method.getName());
				System.out.println("method return type is " + method.getReturnType().getName());
				System.out.println("method modifiers are " + Modifier.toString(method.getModifiers()));

				System.out.println("getParameters");
				Parameter[] parameters = method.getParameters();
				for (Parameter parameter : parameters) {
					System.out.println("method's parameter name is " + parameter.getName());
					System.out.println("method's parameter data type is " + parameter.getType().getName());
					System.out
							.println("method's parameter modifiers are " + Modifier.toString(parameter.getModifiers()));
				}

				System.out.println("getParameterTypes");
				Class[] parameterTypes = method.getParameterTypes();
				for (Class parameter : parameterTypes) {
					System.out.println("method's parameter data type is " + parameter.getName());
					System.out
							.println("method's parameter modifiers are " + Modifier.toString(parameter.getModifiers()));
				}

				System.out.println("getExceptionTypes");
				Class[] exceptions = method.getExceptionTypes();
				for (Class exception : exceptions) {
					System.out.println("method's declared exception is " + exception.getName());
				}

				System.out.println("-------------------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("displayClassMethodsMetadata - END");
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes" })
	private static void displayClassFieldsMetaData() throws ClassNotFoundException {
		System.out.println("displayClassFieldsMetaData - START");
		Class studentClass = getStudentClassBy(ClassRetrivalBy.NEW_KEYWORD);

		try {
			System.out.println(
					"Data type of name variable is " + studentClass.getDeclaredField("name").getType().getName());

			Field[] fields = studentClass.getDeclaredFields();

			for (Field field : fields) {
				System.out.println("variable name is " + field.getName());
				System.out.println("variable data type is " + field.getType().getName());
				System.out.println("variable modifiers are " + Modifier.toString(field.getType().getModifiers()));
				// the below is working with public fields
				// System.out.println("variable value is " + field.get(field));
				System.out.println("--------------------");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("displayClassFieldsMetaData - END");
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes" })
	private static void displayClassMetaData() throws ClassNotFoundException {
		System.out.println("displayClassMetaData - START");

		Class studentClass = getStudentClassBy(ClassRetrivalBy.FOR_NAME);
		System.out.println("Class name is " + studentClass.getName());
		System.out.println("Super Class name is " + studentClass.getSuperclass().getName());
		Class[] interfaces = studentClass.getInterfaces();
		for (Class interfaceVar : interfaces) {
			System.out.println("Implemented interface name is " + interfaceVar.getName());
		}

		int modifiers = studentClass.getModifiers();
		System.out.println("access modifers of class Student are " + Modifier.toString(modifiers));

		System.out.println("displayClassMetaData - END");
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes" })
	private static Class getStudentClassBy(ClassRetrivalBy classRetrivalBy) throws ClassNotFoundException {
		// you can get instance of the Student class by 3 ways

		Class studentClass = null;

		if (classRetrivalBy == ClassRetrivalBy.FOR_NAME) {
			// 1- By Class.forName
			studentClass = Class.forName("com.ssayed.javase.reflection.Student");
		} else if (classRetrivalBy == ClassRetrivalBy.NEW_KEYWORD) {
			// 2- By new keyword
			Student student = new Student();
			studentClass = student.getClass();
		} else if (classRetrivalBy == ClassRetrivalBy.DOT_CLASS) {
			// 3- By .class
			studentClass = Student.class;
		}

		return studentClass;
	}
}

class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	int id;
	String name;
	public static final String FACULTY_NAME = "FCI";

	public Student(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Student() {
	}

	// throws > just for testing
	public void displayData() throws Exception {
		System.out.println("id=" + id + ", name=" + name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}