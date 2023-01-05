import java.io.*;
import java.net.*;

public class UDPServer {
    
    public static final int UDP_SERVER_PORT = 6789;    //mer eller mindre tilfeldig valg portnr.
    
    public static void main(String args[]) throws Exception
    {
        //Oppretter et server socket objekt, knytter til port UDP_SERVER_PORT:
        DatagramSocket serverSocket = new DatagramSocket(UDP_SERVER_PORT);
        
        while(true) {
            //Oppretter (tomme) byte-buffer:
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
        
            //Oppretter en (tom) pakke som kan holde på data som kommer fra klienter:
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            
            //Lytter på port UDP_SERVER_PORT:
            System.out.println("Lytter paa UDP-port " + String.valueOf(UDP_SERVER_PORT) + " ...");     
            serverSocket.receive(receivePacket);
            
            //Fortsetter når pakke ankommer, leser data som nå ligger i receivePacket:
            String sentence = new String(receivePacket.getData());
            System.out.println("Tekst fra klient: " + sentence.trim());
            
            //Leser IP-adresse og portnr fra mottatt pakke:
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            //Gjør om til store bokstaver:
            String capitalizedSentence = sentence.toUpperCase().trim();
            System.out.println("Gjør om til store bokstaver, returnerer:" + capitalizedSentence + "\n");
            
            //Gjør om til bytes:
            sendData = capitalizedSentence.trim().getBytes();
            
            //Returnerer:
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }
}