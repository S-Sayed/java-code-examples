package com.ssayed.ws;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws-example")
public class WebsocketServer {

	public WebsocketServer() {
		System.out.println("Class Loaded");
	}

	@OnOpen
	public void onOpen(Session session) throws IOException {
		session.getBasicRemote().sendText("We are successfully connected, our session id: " + session.getId());
		doSomethingInBackground(session);
	}

	private void doSomethingInBackground(final Session session) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				try {
					session.getBasicRemote().sendText("Notification: " + "you got a new messages");
				} catch (Exception e) {
					e.printStackTrace();

					try {
						session.getBasicRemote().sendText("Something went wrong: " + e.getMessage());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		scheduler.scheduleAtFixedRate(t, 2, 2, TimeUnit.SECONDS);
	}

	@OnMessage
	public void onMessage(String message, final Session session) throws IOException, InterruptedException {
		Thread.sleep(2000);
		session.getBasicRemote().sendText("We are successfully processed your message: " + message + ", thread: "
				+ Thread.currentThread().getName());
	}

	@OnError
	public void onError(Throwable t) throws IOException {
		t.printStackTrace();
	}

	@OnClose
	public void onCLose(Session session) throws IOException {
		session.close();
		session.getBasicRemote().sendText("We are successfully disconnected, session id: " + session.getId());
	}
}
