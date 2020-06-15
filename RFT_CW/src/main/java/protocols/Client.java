package protocols;

import java.net.*;
import java.util.Scanner;

import structures.Segment;
import types.FrameType;

import java.io.*;

public class Client {

	// initialise socket and i/o streams

	private Socket socket = null;
	private Scanner input = new Scanner(System.in);
	private ObjectOutputStream output = null;
	private ObjectInputStream in = null;


	public Client(String address, int port) throws FileNotFoundException, ClassNotFoundException, InterruptedException {
		
      File myObj = new File("src/main/resources/input.txt");
      Scanner myReader = new Scanner(myObj);
		
		try {

			socket = new Socket(address, port);
			System.out.println("Connected");
			output = new ObjectOutputStream(socket.getOutputStream());

		} catch (UnknownHostException u) {

			System.out.println(u);

		} catch (IOException i) {

			System.out.println(i);

		}

		System.out.println("Enter payload details:");
		
		// String to read message from input
		
		String line = "";

		// Read until over is input
		

			try {

				line = myReader.nextLine();
				Segment frame = new Segment(1, FrameType.TYPE_DATA, line,1 ,0 );
				output.writeObject(frame);
				
				in = new ObjectInputStream(socket.getInputStream());
				System.out.println("Ack with sequence number " + (((Segment)in.readObject()).getSq()) + " recieved");

				

			} catch (IOException i) {

				System.out.println(i);

			}


		// close the connection
		try {
			input.close();
			output.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String args[]) throws FileNotFoundException, ClassNotFoundException, InterruptedException {
		Client client = new Client("127.0.0.1", 5000);
	}
	

}
