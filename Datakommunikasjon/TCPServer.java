import java.io.*;
import java.net.*;

public class TCPServer {
    
    public static final int TCP_SERVER_PORT = 6789;    //mer eller mindre tilfeldig valg portnr.
    
    public static void main(String argv[]) throws Exception
    {
        String setningFraKlient;
        String oversattSetning;

        //Lytter på port TCP_SERVER_PORT:
        System.out.println("Lytter paa TCP-port " + String.valueOf(TCP_SERVER_PORT) + " ...");     
        
        ServerSocket welcomeSocket = new ServerSocket(TCP_SERVER_PORT);
        while(true) {
            //Tjeneren venter, 'henger' på accept(), på at klienten skal ta kontakt:
            Socket connectionSocket = welcomeSocket.accept();
          
            //Fortsetter, skriver ut IP-adressen til klienten:
            System.out.println("Kontakt med: " + connectionSocket.getRemoteSocketAddress().toString());     
            
            //Kopler connectionsocket til InputStream:
            InputStreamReader isr = new InputStreamReader(connectionSocket.getInputStream());
    
            BufferedReader fraKlient = new BufferedReader(isr);
            
            //Kopler OutputStream til connectionsocket:
            DataOutputStream tilKlient = new DataOutputStream(connectionSocket.getOutputStream());

            //Leser data fra klienten:
            setningFraKlient = fraKlient.readLine();
            System.out.println("Tekst fra klient: " + setningFraKlient);     
            
            //Oversetter til store bokstaver:
            oversattSetning = setningFraKlient.toUpperCase() + '\n';
            System.out.println("Gjør om til store bokstaver, returnerer:" + oversattSetning);
            
            //Sender store bokstaver i retur:
            tilKlient.writeBytes(oversattSetning);
        }
    }
}