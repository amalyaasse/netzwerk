package com.lavalava.tutorial.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MeinServer {

	public static void main(String[] args) {
		
		MeinServer server = new MeinServer(8000);
		server.startListening();
		
	}

	private int port;
	public MeinServer(int port) {
		this.port = port;
		
}

	public void startListening() {
		new Thread(new Runnable(){
			public void run() {
			try{
				ServerSocket serverSocket = new ServerSocket(port);
				Socket remoteClientSocket = serverSocket.accept();
				Scanner s =
						new Scanner(new BufferedReader
								(new InputStreamReader(remoteClientSocket.getInputStream())));
				
				if(s.hasNextLine()) {
					System.out.println("[Server] Message from Client: " + s.nextLine());
				}
				
				// Verbindung schließen
				s.close();
				remoteClientSocket.close();
				serverSocket.close();
			}
			
			catch(Exception e) {
				e.printStackTrace();
				}
			}
		}).start();
		
		
	}
	
	
	
	
}
