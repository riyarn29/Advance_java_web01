package in.co.rays.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
public static void main(String[] args) throws Exception {
	Socket client = new Socket("localhost", 1234);

	DataInputStream in = new DataInputStream(client.getInputStream());

	DataOutputStream out = new DataOutputStream(client.getOutputStream());

	out.writeBytes("Hello Server\n");

	String line = in.readLine();

	System.out.println(line);

	client.close();
}
}
