import java.io.*;
import java.net.*;


public class ChatServer {
	  /* Dette er en enkel server som kan ta flere
	   * samtidige forbindelser:
	   * Illustrerer sockets og threads:
	   */
	
	private static int id = 0;

	public static void main(String[] args) throws IOException {
		int port = 8190;  
		new ChatServer(port);
		}

	ChatServer (int port) throws IOException {
		// Opprett en ServerSocket på angitt portnr:
		ServerSocket welcomeSocket = new ServerSocket(port);

	    System.out.println("The Server is running on port "+ port);
	    
	    // Lag en (evig) løkke vha. while(true),
	    // ta imot klientforespørsler og start en ny client-handler,
	    // dvs. instansier et ClientHandler-objekt.
	    while (true) {
	      // gjør accept, opprett nytt socket-objekt:
	    	Socket connectionSocket = welcomeSocket.accept();
	      // Instansier et ChatHandler-objekt og kall på start()-metoden (som sørger for at run kjøres)!
	    	ChatHandler chatHandler = new ChatHandler(connectionSocket);
	    	chatHandler.start();    
	    }
	  }
	}
