import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception
    {
        //Oppretter et IP-adresse objekt tilsvarende mottakers adresse (klient og server kj�rer her p� samme maskin):
        InetAddress IPAddress = InetAddress.getByName("localhost");


        //Oppretter (tomme) byte-buffer:
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        //Leser fra tastaturet:
        System.out.print("Skriv inn tekst: ");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String sentence = inFromUser.readLine();
        
        //Oversetter til bytes...
        sendData = sentence.getBytes();
        //Lager en pakke / datagram...
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, UDPServer.UDP_SERVER_PORT);
        //Lager Socket-objekt, sender pakken...
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.send(sendPacket);
        
        //Oppretter en (tom) pakke som kan holde p� svaret:
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        //Vent p� svar...
        clientSocket.receive(receivePacket);
        
        //Fortsetter her n�r svar kommer:
        String modifiedSentence = new String(receivePacket.getData());
        
        //Skriver ut svar:
        System.out.println("\nTekst som store bokstaver: ");
        System.out.println(modifiedSentence.trim());
        
        //Lukker socket:
        clientSocket.close();
    }
}
