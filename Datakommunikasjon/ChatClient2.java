import java.awt.*;
import java.awt.AWTEvent;
import java.io.*;
import java.net.*;
import java.util.*;


public class ChatClient2 extends Frame { 
	private static final int server_port = 8190; 
	private static String host = "localhost"; 
	private DataOutputStream out; 
	private Socket clientSocket; 
 //GUI 
	private Button btSend = new Button("Send"); 
	private Button btClear = new Button("Clear"); 
	private Button btQuit = new Button("Quit"); 
	private TextArea sendText = new TextArea(10, 40); 
	private TextArea receiveText = new TextArea(10, 40); 
	
	public ChatClient2() { 
		super("Java ChatClient"); 
		Panel buttonPanel = new Panel(new BorderLayout()); 
		btSend.addActionListener(new SendListener()); 
		btClear.addActionListener(new ClearListener()); 
		btQuit.addActionListener(new QuitListener()); 
		buttonPanel.add(btSend, BorderLayout.WEST); 
		buttonPanel.add(btClear, BorderLayout.CENTER); 
		buttonPanel.add(btQuit, BorderLayout.EAST); 
		Panel sendTxtPanel = new Panel(new BorderLayout()); 
		Panel receiveTxtPanel = new Panel(new BorderLayout()); 
		sendTxtPanel.add(sendText, BorderLayout.CENTER); 
		receiveTxtPanel.add(receiveText, BorderLayout.CENTER); 
		add(sendTxtPanel, BorderLayout.NORTH);
		add(receiveTxtPanel, BorderLayout.CENTER); 
		add(buttonPanel, BorderLayout.SOUTH); 
		pack(); 
		show();
		try { 
			connectToServer(); 
			} catch (IOException e) { 
				System.out.println("exception:" + e.toString()); 
			}
	}
}