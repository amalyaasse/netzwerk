package com.lavalava.tutorial.client;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MeinClient {

	public static void main(String[] args) {
		MeinClient client = new MeinClient("192.160.176.30", 8000);
		client.sendMessage("Guten Tag, Frau Server! wie gehts Ihnen");

	}
	
	private InetSocketAddress address;

	public MeinClient(String hostname, int port) {
		address = new InetSocketAddress(hostname, port);
		
	}
	
	public void sendMessage(String msg) {
		try {
		Socket socket = new Socket();
		socket.connect(address, 5000);
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		pw.println(msg);
		pw.flush();
		
		//verbindung schließen
		pw.close();
		socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
