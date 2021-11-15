package com.luxoft.chat.server;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatMessagesDispatch implements Runnable {

	private Socket clientSocket;
	private ChatServer server;
	private Scanner inputStream;

	public ChatMessagesDispatch(Socket clientSocket, ChatServer server) {
		this.clientSocket = clientSocket;
		this.server = server;
	}

	@Override
	public void run() {
		try {
			inputStream = new Scanner(clientSocket.getInputStream());
			while(true)
			{
				if(!inputStream.hasNext())
					return;
				String chatLine = inputStream.nextLine();
				System.out.println(clientSocket.getRemoteSocketAddress() + " said: " + chatLine);
				server.sendChatMessageToAll(chatLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}