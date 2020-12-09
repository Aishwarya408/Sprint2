package com.backend.crud.folder.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.folder.dao.FeedbackDao;
import com.backend.crud.folder.model.Feedback;

//import finalsprint2.mapping.dao.FeedbackDao;
//import finalsprint2.mapping.model.Feedback;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public List<Feedback> getAllFeedbacks() {
		System.out.println("Feedbacks...");
		return feedbackDao.findAll();
	}

	public Feedback getFeedbackById(int id) {
		System.out.println("Feedback");
		return feedbackDao.findById(id).get();
	}
	
	
	

	public Feedback addFeedback(Feedback feedback) {
		System.out.println("Feedback added.");
		return feedbackDao.save(feedback);

	}

	public String updateFeedback(int id, Feedback feedback) {
		System.out.println("Feedback updated.");

		Optional<Feedback> repFeedback = feedbackDao.findById(id);

		if (repFeedback.isPresent()) {

			Feedback feedbackToBeUpdated = repFeedback.get();
			feedbackToBeUpdated.setFeedbck(feedback.getFeedbck());
			
			Feedback feedback1= feedbackDao.save(feedbackToBeUpdated);
			if(null != feedback) {
				return "Success";
			}
			

		}

		return null;
	}

	public String removeFeedback(int id) {
		System.out.println("Feedback removed.");

		feedbackDao.deleteById(id);
		return "Feedback deleted Sucessfully";
	}

}





















