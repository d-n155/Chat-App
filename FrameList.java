import java.util.ArrayList;

public class FrameList {
	ArrayList<ChatFrame> frameList = new ArrayList<>(); 
	public void add(ChatFrame frame) {
		frameList.add(frame);
	}
	ArrayList<ChatFrame> getFrameList(){
		return frameList; 
	}
}
