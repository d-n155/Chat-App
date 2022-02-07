import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Server extends Thread {
	private int UserNumber;
	private ArrayList<ChatFrame> frameList = new ArrayList<>(); 
	private JFrame frame = new JFrame();
	private JTextField numberUser; 
	private JButton button;
	private FrameList list = new FrameList(); 
	public ArrayList<ChatFrame> getFrameList(){
		return frameList;
	}
	
	public void run() {
		JLabel label = new JLabel("Number of Users: "); 
		frame.setSize(420,420);
		JPanel panel = new JPanel(); 
		panel.setLayout(new FlowLayout());
		button = new JButton("Set"); 
		numberUser = new JTextField(20);
		panel.add(label); 
		panel.add(numberUser); 
		panel.add(button); 
		frame.add(panel); 
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberOfUser = numberUser.getText(); 
				UserNumber=Integer.parseInt(numberOfUser);
				for (int i = 0; i < UserNumber; i++) {
					ChatFrame frame = new ChatFrame(list); 
					frame.start(); 
					list.add(frame); 
				}
			}
		});
	
		
		/*
		ChatFrame frame1 = new ChatFrame(this, "Jim"); 
		frame1.start(); 
		ChatFrame frame2 = new ChatFrame(this, "Guest");
		frame2.start();
		ChatFrame frame3 = new ChatFrame(this, "John"); 
		frame3.start(); 
		frameList.add(frame1); 
		frameList.add(frame2);
		frameList.add(frame3); 
		*/
	}
}
