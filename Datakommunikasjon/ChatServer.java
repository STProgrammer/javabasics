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
		// Opprett en ServerSocket p� angitt portnr:
		ServerSocket welcomeSocket = new ServerSocket(port);

	    System.out.println("The Server is running on port "+ port);
	    
	    // Lag en (evig) l�kke vha. while(true),
	    // ta imot klientforesp�rsler og start en ny client-handler,
	    // dvs. instansier et ClientHandler-objekt.
	    while (true) {
	      // gj�r accept, opprett nytt socket-objekt:
	    	Socket connectionSocket = welcomeSocket.accept();
	      // Instansier et ChatHandler-objekt og kall p� start()-metoden (som s�rger for at run kj�res)!
	    	ChatHandler chatHandler = new ChatHandler(connectionSocket);
	    	chatHandler.start();    
	    }
	  }
	}
