package loan.advisor.services;

import java.util.HashMap;
import java.util.Map;

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

}
