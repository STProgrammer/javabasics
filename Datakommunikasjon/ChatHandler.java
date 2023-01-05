import java.io.*;
import java.net.*;

class ChatHandler extends Thread {
  /* Kalles og brukes fra ChatServer-klassen: en tråd for hver klient!
   */
  private Socket toClient;
  private String name;
  // Deklarer nødvendige stream-objekter:

  //Konstruktør tar et socket-objekt som parameter:
  ChatHandler(Socket s) {
    toClient = s;
  }

  // run()-metoden, som blir kjørt ved kall på start() på Thread-objektet, må implementeres:
  public void run() {
    try {
      /* Opprett IO strømmer (/streams) på socketen:
       *      
       */
        InputStreamReader isr = new InputStreamReader(toClient.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        
        
        //Kopler OutputStream til connectionsocket:
        DataOutputStream out = new DataOutputStream(toClient.getOutputStream());
        
        
      // Initialiser stream-objektene og knytt dem til socket-objektet, toClient:
        

      // Send en velkomstmelding på ut-strømmen (objektet)
        String txt = "Welcome! What's your name \n";
        
        out.writeBytes(txt);

      // Les svar fra klienten, send tilbake "OK"
        String s = in.readLine();
        out.writeBytes("OK \n");

      // Lag en while-løkke og les meldinger som måtte komme
      // fra klienten, terminer dersom mottak av "BYE"
      while (!s.equals("BYE")) {
        // Les melding fra klient, send "OK" tilbake:
          s = in.readLine();
          out.writeBytes("OK \n");
      }
      // Frigjør socket-objektet vha. close()
      toClient.close();
    } catch (Exception e) {
      System.out.println("Server error: "+e);
    }
  }
}