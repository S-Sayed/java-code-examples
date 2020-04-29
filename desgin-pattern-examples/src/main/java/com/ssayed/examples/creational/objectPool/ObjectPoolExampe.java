package com.ssayed.examples.creational.objectPool;

import java.net.Socket;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ObjectPoolExampe {

	public static void main(String[] args) {
		// setup the pool with minimum number of objects
		JDBCConnectionPool connectionPool = new JDBCConnectionPool(null, null, null, 5);
		displayObjectsInPool(connectionPool);

//		SocketConnectionPool socketPool = new SocketConnectionPool(5);
//		displayObjectsInPool(socketPool);
//		
//		System.out.println(connectionPool.objectPool.hashCode() == socketPool.objectPool.hashCode());

		// Run Query in separate threads
		String query = "SELECT * FROM USER WHERE EMAIL = '?'";
		new Thread(new QueryExecutor(connectionPool, 1, query, "ssayed@gmail.com"), "t1").start();
		new Thread(new QueryExecutor(connectionPool, 2, query, "sila@gmail.com"), "t2").start();
		new Thread(new QueryExecutor(connectionPool, 3, query, "adam@gmail.com"), "t3").start();
		new Thread(new QueryExecutor(connectionPool, 4, query, "yasmin@gmail.com"), "t4").start();
	}

	static <T> void displayObjectsInPool(ObjectPool<T> connectionPool) {
		Iterator<T> iterator = connectionPool.objectPool.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
}

abstract class ObjectPool<T> {

	// use ConcurrentLinkedQueue for pooling as it is thread-safe and follows FIFO
	ConcurrentLinkedQueue<T> objectPool;

	public ObjectPool(int minNumberOfObjects, int maxNumberOfObjects, int validationInterval) {
		initializePool(minNumberOfObjects);

		// create thread to check the missing object to be added/ extra objects to be
		// removed to/from the pool periodically using the passed parameters
	}

	public ObjectPool(int minNumberOfObjects) {
		initializePool(minNumberOfObjects);
	}

	private void initializePool(int minNumberOfObjects) {
		objectPool = new ConcurrentLinkedQueue<>();
		for (int i = 0; i < minNumberOfObjects; i++) {
			objectPool.add(createNewInstance(i));
		}
	}

	public abstract T createNewInstance(int instanceNumber);

	public synchronized T getInstance() {
		return objectPool.poll();
	}

	public void backInstance(T o) {
		objectPool.offer(o);
	}
}

class SocketConnectionPool extends ObjectPool<Socket> {
	public SocketConnectionPool(int minNumberOfObjects) {
		super(minNumberOfObjects);
	}

	@Override
	public Socket createNewInstance(int instanceNumber) {
		return new Socket();
	}
}

class JDBCConnectionPool extends ObjectPool<Connection> {
	private String url, usernmae, password;

	public JDBCConnectionPool(String url, String username, String password, int minNumberOfObjects) {
		super(minNumberOfObjects);
		this.url = url;
		this.usernmae = username;
		this.password = password;
	}

	@Override
	public Connection createNewInstance(int instanceNumber) {
		return new Connection("Connection #" + instanceNumber, url, usernmae, password);
	}
}

class Connection {
	// DB URL, user name, password variables here
	private String name;

	public Connection(String name, String url, String usernmae, String password) {
		this.name = name;
		// you can do some expensive work here like creating DB connection object using
		// the above DB URL, user name, password variables

		System.out.println("Connection object with name [" + name + "] has been created");
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
}

class QueryExecutor implements Runnable {
	private int queryNumber;
	private String query;
	private JDBCConnectionPool connectionPool;

	public QueryExecutor(JDBCConnectionPool connectionPool, int queryNumber, String query, String parameter) {
		this.connectionPool = connectionPool;
		this.queryNumber = queryNumber;
		this.query = query.replace("?", parameter);
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " : Query number [" + queryNumber + "] is started to get executed");

		Connection connection = connectionPool.getInstance();

		System.out.println(
				threadName + " : Connection object with name [" + connection.getName() + "] is taken from the pool");

		System.out.println(threadName + " : Executing the query ... " + query);

		connectionPool.backInstance(connection);
		System.out.println(threadName + " : Connection object with name [" + connection.getName()
				+ "] is returned back into the pool");

		System.out.println(threadName + " : Query number [" + queryNumber + "] is done");
	}
}