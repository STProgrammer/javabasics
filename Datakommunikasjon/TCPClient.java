import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception
    {
        String sentence="";
        String modifiedSentence="";

        //Oppretter forbindelse mot localhost på port 6789:
        Socket clientSocket = new Socket("localhost", TCPServer.TCP_SERVER_PORT);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        //Spør bruker etter tekst:
        System.out.print("Skriv inn tekst: ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();

        //Skriv ut tekst som store bokstaver:
        System.out.println("\nTekst som store bokstaver: ");
        System.out.println(modifiedSentence);

        //Lukk socket og avslutt:
        clientSocket.close();
    }
}