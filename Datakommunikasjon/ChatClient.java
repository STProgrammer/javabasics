import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient {
  private static final int server_port = 8190;
  private static String host = "localhost";
  //definer nødvendige variabler:
  Socket clientSocket;
  DataOutputStream out;
  BufferedReader in;


  public static void main(String[] args) {
     ChatClient myChatClient1 = new ChatClient();
  }

  public ChatClient() {
    try {
      // Kople til tjener på port 8190:
      clientSocket = new Socket(host, server_port);
      out = new DataOutputStream(clientSocket.getOutputStream());
      in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      
      try {
	// Motta tekst fra tjener; "What is your name?"
    	String message = in.readLine();	
        System.out.println(message);
        
        //Bruker skriver navn og sender det til tjener:
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));        
        String sendTxt = inFromUser.readLine();
        out.writeBytes(sendTxt + '\n');
        
        //Motta "OK" fra tjener, skriv OK ut til skjermen:
        System.out.println(in.readLine());
        
        System.out.println("Skriv tekst som skal sendes til tjener (BYE avslutter):");

        // Lag en while-løkke som terminierer dersom mottatt tekst = "BYE" {
        while (!sendTxt.equals("BYE")) {
          // Skriv ut en ledetekst slik at brukeren skjønner at tekst
          // skal skrives inn, les inn tekst fra tastatur:
         
          sendTxt = inFromUser.readLine();
	  out.writeBytes(sendTxt + '\n');
          // Send tekst til tjener, motta "OK" fra tjener som skrives ut til skjerm:
	  System.out.println(in.readLine());

        }
        // Ved terminerig av while-løkke må "BYE" sendes til tjener:
        out.writeBytes(sendTxt);

      } catch (Exception e) {
        System.out.println("Chatter client error: " + e);
      }
    } catch (IOException e) {
      System.out.println("exception i constructor: " + e.toString());
    } finally { disconnectFromServer();}
  }

  private void disconnectFromServer()
  {
    try {
      clientSocket.close();
    } catch (IOException ioe) {
      System.out.println("error disconnecting client: " + ioe);
    }
  }
}