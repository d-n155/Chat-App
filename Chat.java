import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Chat {
	static ArrayList <ChatFrame> frameList; 
	public static void main(String []args) {
		Server server = new Server();
		server.start(); 
	}
}
