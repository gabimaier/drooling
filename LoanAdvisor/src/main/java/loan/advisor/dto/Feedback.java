package loan.advisor.dto;

import java.util.LinkedList;
import java.util.List;

public class Feedback {
	private List<String> messages = new LinkedList<String>();
	
	public void addMessage(String msg){
		messages.add(msg);
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		for(String msg : messages){
			builder.append(msg).append("\n");
		}
		return builder.toString();
	}
}
