package com.backend.crud.folder.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.crud.folder.dao.TopicDao;
import com.backend.crud.folder.model.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicDao topicDao;

	// Participants List
	public List<Topic> getAllTopics() {

		System.out.println("Topics");
		return topicDao.findAll();
	}

	// get Participants by id
	public Topic getTopicById(int topicid) {

		return topicDao.findById(topicid).orElse(null);

	}
	// return participantDao.findById(id).orElse(new Participant());

	// Add Participants
	public int addTopic(Topic topic) {

		if (topicDao.existsById(topic.getId())) {

			return 0;
		} else {

			return topicDao.save(topic).getId();

		}
	}

	// Update Participants
	public Topic updateTopic(Topic topic) {
		if (topicDao.existsById(topic.getId())) {
			return topicDao.save(topic);

		} else {
			return new Topic();
		}
	}

	// Remove Participants
	public boolean removeTopicbyId(int id) {
		if (topicDao.existsById(id)) {
			topicDao.deleteById(id);
			return true;
		} else {
			return false;
		}

	}

}