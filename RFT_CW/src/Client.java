
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Client {

	// initialise socket and i/o streams

	private Socket socket = null;
	private Scanner input = new Scanner(System.in);
	private ObjectOutputStream output = null;

	public Client(String address, int port) throws FileNotFoundException {

		 File inputFile = new File("input.txt");
	     Scanner fileReader = new Scanner(inputFile);

		
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

				line ="Over";
//				line = input.nextLine();
				Frame frame = new Frame(port, FrameType.TYPE_DATA, line,1 ,0 );
				output.writeObject(frame);

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

	public static void main(String args[]) throws FileNotFoundException {
		Client client = new Client("127.0.0.1", 5000);
	}
	

}
