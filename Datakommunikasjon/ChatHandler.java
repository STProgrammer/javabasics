import java.io.*;
import java.net.*;

class ChatHandler extends Thread {
  /* Kalles og brukes fra ChatServer-klassen: en tr�d for hver klient!
   */
  private Socket toClient;
  private String name;
  // Deklarer n�dvendige stream-objekter:

  //Konstrukt�r tar et socket-objekt som parameter:
  ChatHandler(Socket s) {
    toClient = s;
  }

  // run()-metoden, som blir kj�rt ved kall p� start() p� Thread-objektet, m� implementeres:
  public void run() {
    try {
      /* Opprett IO str�mmer (/streams) p� socketen:
       *      
       */
        InputStreamReader isr = new InputStreamReader(toClient.getInputStream());
        BufferedReader in = new BufferedReader(isr);
        
        
        //Kopler OutputStream til connectionsocket:
        DataOutputStream out = new DataOutputStream(toClient.getOutputStream());
        
        
      // Initialiser stream-objektene og knytt dem til socket-objektet, toClient:
        

      // Send en velkomstmelding p� ut-str�mmen (objektet)
        String txt = "Welcome! What's your name \n";
        
        out.writeBytes(txt);

      // Les svar fra klienten, send tilbake "OK"
        String s = in.readLine();
        out.writeBytes("OK \n");

      // Lag en while-l�kke og les meldinger som m�tte komme
      // fra klienten, terminer dersom mottak av "BYE"
      while (!s.equals("BYE")) {
        // Les melding fra klient, send "OK" tilbake:
          s = in.readLine();
          out.writeBytes("OK \n");
      }
      // Frigj�r socket-objektet vha. close()
      toClient.close();
    } catch (Exception e) {
      System.out.println("Server error: "+e);
    }
  }
}