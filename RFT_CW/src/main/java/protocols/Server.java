package protocols;
import java.net.*;
import java.util.Scanner;

import structures.Segment;
import types.FrameType;

import java.io.*;

public class Server {
	// initialize socket and input stream
	private Socket socket = null;
	private ServerSocket server = null;
	private ObjectInputStream in = null;
	private ObjectOutputStream output = null;


	// constructor with port
	public Server(int port) throws ClassNotFoundException {
		// starts server and waits for a connection
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");
			
			System.out.println("Waiting for a client ...");
			
			socket = server.accept();
			System.out.println("Client accepted");
			
			output = new ObjectOutputStream(socket.getOutputStream());
			
			File myObj = new File("");
			

			// takes input from the client socket

			String line = "";

			// reads message from client until "Over" is sent

			try {
				in = new ObjectInputStream(socket.getInputStream());
				Segment s = (Segment) in.readObject();
				FileWriter myWriter = new FileWriter("src/main/resources/output.txt");
			 	myWriter.write(s.getPayload());
			 	
				System.out.println("Payload recieved sending ack\n");
			 	
				Segment frame = new Segment(s.getSq(), FrameType.TYPE_ACK,s.getLast() );
				output.writeObject(frame);
				
			 	myWriter.close();
				
				// Frame f = new Frame(clientFrame.sq, FrameType.TYPE_ACK, clientFrame.last);

			} catch (IOException i) {
				System.out.println(i);
			}

			System.out.println("Closing connection");

			// close connection
			socket.close();
			in.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) throws ClassNotFoundException {
		Server server = new Server(5000);
	}
}