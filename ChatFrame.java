import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class ChatFrame extends Thread {
	static ArrayList <ChatFrame> frameList; 
	
	JFrame frame;  
	JTextPane text;
	JTextField name; 
	JTextField message; 
	JButton button;
	JLabel northText; 

	private FrameList listFrame; 
	private String userName; 
	public ChatFrame(FrameList list) {
		// TODO Auto-generated constructor stub
		this.listFrame = list; 
	}


	public void run() {
		// Creating the frame
		frame = new JFrame(); 
		frame.setLayout(new BorderLayout());
		
		// Panel and its elements 
		text = new JTextPane(); 
		JScrollPane scrollableTextPane = new JScrollPane(text); 
		JPanel panel = new JPanel(); 
		JPanel northPanel = new JPanel(); 
		panel.setLayout(new BorderLayout());
		northPanel.setLayout(new FlowLayout(0));
		northText = new JLabel("UserName: "); 
		message = new JTextField(); 
		name = new JTextField(20); 
		name.setSize(new Dimension(100,50));
		button = new JButton("Send"); 
		frame.setSize(420,420);
		
		northPanel.add(northText); 
		northPanel.add(name); 
		panel.add(northPanel, BorderLayout.NORTH); 
		panel.add(scrollableTextPane, BorderLayout.CENTER); 
		panel.add(button, BorderLayout.EAST);
		panel.add(message, BorderLayout.SOUTH);
		frame.add(panel); 
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				userName = name.getText(); 
				String msg = message.getText() + '\n'; 
				message.setText("");
				frameList = listFrame.getFrameList(); 
				msg = text.getText() + '\n' + userName + ": " + msg; 
				for (ChatFrame f : frameList) {
					f.text.setText(msg);
				}
			}
		});

		frame.setVisible(true);
		
	}
	
}
