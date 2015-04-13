import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class byteRequestThread extends clientHelperThread
{
	private Scanner serverInput;
	private PrintWriter serverOutput;
	private Socket theSocket;
	public byteRequestThread(int[] theFileArray, Socket theSocket)
	{
		super(theFileArray, theSocket);
		this.theSocket = theSocket;
		System.out.println(theSocket);
		try
		{
			this.serverInput = new Scanner(this.theSocket.getInputStream());
			this.serverOutput = new PrintWriter(this.theSocket.getOutputStream(), true);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void run()
	{
		//this guy constantly listens for a request from the server
		//for a certain byte and responds with that byte
		while(true)
		{
			String request = this.serverInput.nextLine();
			System.out.println("received request");
			serverOutput.println(theFileArray[Integer.parseInt(request)]);
			System.out.println("Done");
			//*****Write Code HERE****
		}
	}
}