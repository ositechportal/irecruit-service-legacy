package com.irecruit.service;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.elastic.repository.PositionSearchService;
import com.irecruit.mongo.repository.PositionRepository;
import com.irecruit.mongo.repository.RequisitionRepository;
import com.irecruit.pojo.Position;
import com.irecruit.pojo.Requisition;

@Service
public class JobPostingService implements IJobPostingService {
	
	@Autowired
	private RequisitionRepository requisitionRepository;
	
	@Autowired
	PositionSearchService positionSearchService;
	
	@Autowired
	PositionRepository positionRepository;
	
	@Autowired
	private NotificationService notificationService;
	
	public void postReferalJob(Position position) throws Exception {
		position.setPublishStatus(true);
		positionRepository.updatePublishStatus(position);
		Requisition requisition = requisitionRepository.retrieveRequisitionBasedOnId(position.getRequisitionId());
	 
	 try {
		 //notificationService.sendRefralJob(requisition);
		 notificationService.sendJobToReffarals(position,requisition);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		positionSearchService.updatePositionIndex(position);

		
	}

	

}
