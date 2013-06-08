package loan.advisor.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import loan.advisor.dto.Feedback;
import loan.advisor.dto.Person;

public class FeedbackService {
	private Map<Person, Feedback> feedbackBucket = new HashMap<>();
	
	public void addFeedback(Person person, String message){
		Feedback feedback = feedbackBucket.get(person);
		if(feedback == null){
			feedback = new Feedback();
		}
		feedback.addMessage(message);
		feedbackBucket.put(person, feedback);
	}

	public String getFeedback(){
		StringBuilder builder = new StringBuilder();
		for(Entry<Person, Feedback> entry: feedbackBucket.entrySet()){
			builder.append(entry.getKey()).append(":\n").append(entry.getValue()).append("\n");
		}
		return builder.toString();
	}
}
